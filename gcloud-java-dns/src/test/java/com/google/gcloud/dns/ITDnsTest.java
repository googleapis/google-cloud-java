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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.Page;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ITDnsTest {

  // todo(mderka) Implement test for creating invalid change when DnsException is finished. #673

  public static final int TIME_LIMIT = 10;
  public static final String PREFIX = "gcldjvit-";
  public static final Dns DNS = DnsOptions.builder().build().service();
  public static final String PROJECT_ID = DNS.options().projectId();
  public static final String ZONE_NAME1 = (PREFIX + UUID.randomUUID()).substring(0, 32);
  public static final String ZONE_NAME_EMPTY_DESCRIPTION =
      ("gcldjvit-" + UUID.randomUUID()).substring(0, 32);
  public static final String ZONE_NAME_TOO_LONG = (PREFIX + UUID.randomUUID());
  public static final String ZONE_DESCRIPTION1 = "first zone";
  public static final String ZONE_DNS_NAME1 = ZONE_NAME1 + ".com.";
  public static final String ZONE_DNS_EMPTY_DESCRIPTION = ZONE_NAME_EMPTY_DESCRIPTION + ".com.";
  public static final String ZONE_DNS_NAME_NO_PERIOD = ZONE_NAME1 + ".com";
  public static final ZoneInfo ZONE1 = ZoneInfo.builder(ZONE_NAME1)
      .description(ZONE_DESCRIPTION1)
      .dnsName(ZONE_DNS_EMPTY_DESCRIPTION)
      .build();
  public static final ZoneInfo ZONE_EMPTY_DESCRIPTION =
      ZoneInfo.builder(ZONE_NAME_EMPTY_DESCRIPTION)
          .description(ZONE_DESCRIPTION1)
          .dnsName(ZONE_DNS_NAME1)
          .build();
  public static final ZoneInfo ZONE_NAME_ERROR =
      ZoneInfo.builder(ZONE_NAME_TOO_LONG)
          .description(ZONE_DESCRIPTION1)
          .dnsName(ZONE_DNS_NAME1)
          .build();
  public static final ZoneInfo ZONE_MISSING_DESCRIPTION =
      ZoneInfo.builder(ZONE_NAME1)
          .dnsName(ZONE_DNS_NAME1)
          .build();
  public static final ZoneInfo ZONE_MISSING_DNS_NAME =
      ZoneInfo.builder(ZONE_NAME1)
          .description(ZONE_DESCRIPTION1)
          .build();
  public static final ZoneInfo ZONE_DNS_NO_PERIOD =
      ZoneInfo.builder(ZONE_NAME1)
          .description(ZONE_DESCRIPTION1)
          .dnsName(ZONE_DNS_NAME_NO_PERIOD)
          .build();
  public static final DnsRecord A_RECORD_ZONE1 = DnsRecord
      .builder("www." + ZONE1.dnsName(), DnsRecord.Type.A)
      .records(ImmutableList.of("123.123.55.1"))
      .ttl(25, TimeUnit.SECONDS)
      .build();
  public static final DnsRecord AAAA_RECORD_ZONE1 = DnsRecord
      .builder("www." + ZONE1.dnsName(), DnsRecord.Type.AAAA)
      .records(ImmutableList.of("ed:ed:12:aa:36:3:3:105"))
      .ttl(25, TimeUnit.SECONDS)
      .build();
  public static final ChangeRequest CHANGE_ADD_ZONE1 = ChangeRequest.builder()
      .add(A_RECORD_ZONE1)
      .add(AAAA_RECORD_ZONE1)
      .build();
  public static final ChangeRequest CHANGE_DELETE_ZONE1 = ChangeRequest.builder()
      .delete(A_RECORD_ZONE1)
      .delete(AAAA_RECORD_ZONE1)
      .build();

  public static void purge() {
    Page<Zone> zones = DNS.listZones();
    Iterator<Zone> zoneIterator = zones.iterateAll();
    while (zoneIterator.hasNext()) {
      Zone zone = zoneIterator.next();
      List<DnsRecord> toDelete = new LinkedList<>();
      if (zone.name().startsWith(PREFIX)) {
        Iterator<DnsRecord> dnsRecordIterator = zone.listDnsRecords().iterateAll();
        while (dnsRecordIterator.hasNext()) {
          DnsRecord record = dnsRecordIterator.next();
          if (!ImmutableList.of(DnsRecord.Type.NS, DnsRecord.Type.SOA).contains(record.type())) {
            toDelete.add(record);
          }
        }
        if (!toDelete.isEmpty()) {
          zone.applyChangeRequest(ChangeRequest.builder().deletions(toDelete).build());
        }
        zone.delete();
      }
    }
  }

  private static List<Zone> filter(Iterator<Zone> iterator) {
    List<Zone> result = new LinkedList<>();
    while (iterator.hasNext()) {
      Zone zone = iterator.next();
      if (zone.name().startsWith(PREFIX)) {
        result.add(zone);
      }
    }
    return result;
  }

  @BeforeClass
  public static void before() {
    purge();
  }

  @AfterClass
  public static void after() {
    purge();
  }

  @Test
  public void testCreateValidZone() {
    Zone created = DNS.create(ZONE1);
    assertEquals(ZONE1.description(), created.description());
    assertEquals(ZONE1.dnsName(), created.dnsName());
    assertEquals(ZONE1.name(), created.name());
    assertNotNull(created.creationTimeMillis());
    assertNotNull(created.nameServers());
    assertNull(created.nameServerSet());
    assertNotNull(created.id());
    Zone retrieved = DNS.getZone(ZONE1.name());
    assertEquals(created, retrieved);
    created = DNS.create(ZONE_EMPTY_DESCRIPTION);
    assertEquals(ZONE_EMPTY_DESCRIPTION.description(), created.description());
    assertEquals(ZONE_EMPTY_DESCRIPTION.dnsName(), created.dnsName());
    assertEquals(ZONE_EMPTY_DESCRIPTION.name(), created.name());
    assertNotNull(created.creationTimeMillis());
    assertNotNull(created.nameServers());
    assertNull(created.nameServerSet());
    assertNotNull(created.id());
    retrieved = DNS.getZone(ZONE_EMPTY_DESCRIPTION.name());
    assertEquals(created, retrieved);
  }

  @After
  public void tearDown() {
    purge();
  }

  @Test
  public void testCreateZoneWithErrors() {
    try {
      DNS.create(ZONE_MISSING_DNS_NAME);
      fail("Zone is missing DNS name. The service returns an error.");
    } catch (DnsException ex) {
      // expected
      // todo(mderka) test non-retryable when implemented within #593
    }
    try {
      DNS.create(ZONE_MISSING_DESCRIPTION);
      fail("Zone is missing description name. The service returns an error.");
    } catch (DnsException ex) {
      // expected
      // todo(mderka) test non-retryable when implemented within #593
    }
    try {
      DNS.create(ZONE_NAME_ERROR);
      fail("Zone name is missing a period. The service returns an error.");
    } catch (DnsException ex) {
      // expected
      // todo(mderka) test non-retryable when implemented within #593
    }
    try {
      DNS.create(ZONE_DNS_NO_PERIOD);
      fail("Zone name is missing a period. The service returns an error.");
    } catch (DnsException ex) {
      // expected
      // todo(mderka) test non-retryable when implemented within #593
    }
  }

  @Test
  public void testCreateZoneWithOptions() {
    Zone created = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.CREATION_TIME));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNotNull(created.creationTimeMillis());
    assertNull(created.description());
    assertNull(created.dnsName());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created.delete();
    created = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.DESCRIPTION));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertEquals(ZONE1.description(), created.description());
    assertNull(created.dnsName());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created.delete();
    created = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.DNS_NAME));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertEquals(ZONE1.dnsName(), created.dnsName());
    assertNull(created.description());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created.delete();
    created = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.NAME));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created.delete();
    created = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.NAME_SERVER_SET));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet()); // we did not set it
    assertNull(created.id());
    created.delete();
    created = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.NAME_SERVERS));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertFalse(created.nameServers().isEmpty());
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created.delete();
    created = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.ZONE_ID));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertNotNull(created.nameServers());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNotNull(created.id());
    created.delete();
    // combination of multiple things
    created = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.ZONE_ID,
        Dns.ZoneField.NAME_SERVERS, Dns.ZoneField.NAME_SERVER_SET, Dns.ZoneField.DESCRIPTION));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertEquals(ZONE1.description(), created.description());
    assertFalse(created.nameServers().isEmpty());
    assertNull(created.nameServerSet()); // we did not set it
    assertNotNull(created.id());
  }

  @Test
  public void testZoneReload() {
    Zone created = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.NAME));
    created = created.reload(Dns.ZoneOption.fields(Dns.ZoneField.CREATION_TIME));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNotNull(created.creationTimeMillis());
    assertNull(created.description());
    assertNull(created.dnsName());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created = created.reload(Dns.ZoneOption.fields(Dns.ZoneField.DESCRIPTION));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertEquals(ZONE1.description(), created.description());
    assertNull(created.dnsName());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created = created.reload(Dns.ZoneOption.fields(Dns.ZoneField.DNS_NAME));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertEquals(ZONE1.dnsName(), created.dnsName());
    assertNull(created.description());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created = created.reload(Dns.ZoneOption.fields(Dns.ZoneField.NAME));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created = created.reload(Dns.ZoneOption.fields(Dns.ZoneField.NAME_SERVER_SET));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet()); // we did not set it
    assertNull(created.id());
    created = created.reload(Dns.ZoneOption.fields(Dns.ZoneField.NAME_SERVERS));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertFalse(created.nameServers().isEmpty());
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created = created.reload(Dns.ZoneOption.fields(Dns.ZoneField.ZONE_ID));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertNotNull(created.nameServers());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNotNull(created.id());
    // combination of multiple things
    created = created.reload(Dns.ZoneOption.fields(Dns.ZoneField.ZONE_ID,
        Dns.ZoneField.NAME_SERVERS, Dns.ZoneField.NAME_SERVER_SET, Dns.ZoneField.DESCRIPTION));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertEquals(ZONE1.description(), created.description());
    assertFalse(created.nameServers().isEmpty());
    assertNull(created.nameServerSet()); // we did not set it
    assertNotNull(created.id());
  }

  @Test
  public void testGetZone() {
    DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.NAME));
    Zone created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(Dns.ZoneField.CREATION_TIME));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNotNull(created.creationTimeMillis());
    assertNull(created.description());
    assertNull(created.dnsName());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(Dns.ZoneField.DESCRIPTION));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertEquals(ZONE1.description(), created.description());
    assertNull(created.dnsName());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(Dns.ZoneField.DNS_NAME));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertEquals(ZONE1.dnsName(), created.dnsName());
    assertNull(created.description());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(Dns.ZoneField.NAME));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(Dns.ZoneField.NAME_SERVER_SET));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNull(created.nameServerSet()); // we did not set it
    assertNull(created.id());
    created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(Dns.ZoneField.NAME_SERVERS));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertFalse(created.nameServers().isEmpty());
    assertNull(created.nameServerSet());
    assertNull(created.id());
    created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(Dns.ZoneField.ZONE_ID));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertNull(created.description());
    assertNotNull(created.nameServers());
    assertTrue(created.nameServers().isEmpty()); // never returns null
    assertNotNull(created.id());
    // combination of multiple things
    created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(Dns.ZoneField.ZONE_ID,
        Dns.ZoneField.NAME_SERVERS, Dns.ZoneField.NAME_SERVER_SET, Dns.ZoneField.DESCRIPTION));
    assertEquals(ZONE1.name(), created.name()); // always returned
    assertNull(created.creationTimeMillis());
    assertNull(created.dnsName());
    assertEquals(ZONE1.description(), created.description());
    assertFalse(created.nameServers().isEmpty());
    assertNull(created.nameServerSet()); // we did not set it
    assertNotNull(created.id());
  }

  @Test
  public void testListZones() {
    List<Zone> zones = filter(DNS.listZones().iterateAll());
    assertEquals(0, zones.size());
    // some zones exists
    Zone created = DNS.create(ZONE1);
    zones = filter(DNS.listZones().iterateAll());
    assertEquals(created, zones.get(0));
    assertEquals(1, zones.size());
    created = DNS.create(ZONE_EMPTY_DESCRIPTION);
    zones = filter(DNS.listZones().iterateAll());
    assertEquals(2, zones.size());
    assertTrue(zones.contains(created));
    // error in options
    try {
      DNS.listZones(Dns.ZoneListOption.pageSize(0));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test not-retryable
    }
    try {
      DNS.listZones(Dns.ZoneListOption.pageSize(-1));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test not-retryable
    }
    // ok size
    zones = filter(DNS.listZones(Dns.ZoneListOption.pageSize(1000)).iterateAll());
    assertEquals(2, zones.size()); // we still have only 2 zones
    // dns name problems
    try {
      DNS.listZones(Dns.ZoneListOption.dnsName("aaaaa"));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test not-retryable
    }
    // ok name
    zones = filter(DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName())).iterateAll());
    assertEquals(1, zones.size());
    // field options
    zones = ImmutableList.copyOf(DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
        Dns.ZoneListOption.fields(Dns.ZoneField.ZONE_ID)).iterateAll());
    assertEquals(1, zones.size());
    Zone zone = zones.get(0);
    assertNull(zone.creationTimeMillis());
    assertNotNull(zone.name());
    assertNull(zone.dnsName());
    assertNull(zone.description());
    assertNull(zone.nameServerSet());
    assertTrue(zone.nameServers().isEmpty());
    assertNotNull(zone.id());
    zones = ImmutableList.copyOf(DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
        Dns.ZoneListOption.fields(Dns.ZoneField.CREATION_TIME)).iterateAll());
    assertEquals(1, zones.size());
    zone = zones.get(0);
    assertNotNull(zone.creationTimeMillis());
    assertNotNull(zone.name());
    assertNull(zone.dnsName());
    assertNull(zone.description());
    assertNull(zone.nameServerSet());
    assertTrue(zone.nameServers().isEmpty());
    assertNull(zone.id());
    zones = ImmutableList.copyOf(DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
        Dns.ZoneListOption.fields(Dns.ZoneField.DNS_NAME)).iterateAll());
    assertEquals(1, zones.size());
    zone = zones.get(0);
    assertNull(zone.creationTimeMillis());
    assertNotNull(zone.name());
    assertNotNull(zone.dnsName());
    assertNull(zone.description());
    assertNull(zone.nameServerSet());
    assertTrue(zone.nameServers().isEmpty());
    assertNull(zone.id());
    zones = ImmutableList.copyOf(DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
        Dns.ZoneListOption.fields(Dns.ZoneField.DESCRIPTION)).iterateAll());
    assertEquals(1, zones.size());
    zone = zones.get(0);
    assertNull(zone.creationTimeMillis());
    assertNotNull(zone.name());
    assertNull(zone.dnsName());
    assertNotNull(zone.description());
    assertNull(zone.nameServerSet());
    assertTrue(zone.nameServers().isEmpty());
    assertNull(zone.id());
    zones = ImmutableList.copyOf(DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
        Dns.ZoneListOption.fields(Dns.ZoneField.NAME_SERVERS)).iterateAll());
    assertEquals(1, zones.size());
    zone = zones.get(0);
    assertNull(zone.creationTimeMillis());
    assertNotNull(zone.name());
    assertNull(zone.dnsName());
    assertNull(zone.description());
    assertNull(zone.nameServerSet());
    assertTrue(!zone.nameServers().isEmpty());
    assertNull(zone.id());
    zones = ImmutableList.copyOf(DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
        Dns.ZoneListOption.fields(Dns.ZoneField.NAME_SERVER_SET)).iterateAll());
    assertEquals(1, zones.size());
    zone = zones.get(0);
    assertNull(zone.creationTimeMillis());
    assertNotNull(zone.name());
    assertNull(zone.dnsName());
    assertNull(zone.description());
    assertNull(zone.nameServerSet()); // we cannot set it using gcloud java
    assertTrue(zone.nameServers().isEmpty());
    assertNull(zone.id());
    // several combined
    zones = filter(DNS.listZones(Dns.ZoneListOption.fields(Dns.ZoneField.ZONE_ID,
        Dns.ZoneField.DESCRIPTION),
        Dns.ZoneListOption.pageSize(1)).iterateAll());
    assertEquals(2, zones.size());
    for (Zone current : zones) {
      assertNull(current.creationTimeMillis());
      assertNotNull(current.name());
      assertNull(current.dnsName());
      assertNotNull(current.description());
      assertNull(current.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNotNull(current.id());
    }
  }

  @Test
  public void testDeleteZoneUsingServiceObject() {
    Zone created = DNS.create(ZONE1);
    assertEquals(created, DNS.getZone(ZONE1.name()));
    DNS.delete(ZONE1.name());
    assertNull(DNS.getZone(ZONE1.name()));
  }

  @Test
  public void testDeleteZoneUsingZoneObject() {
    Zone created = DNS.create(ZONE1);
    assertEquals(created, DNS.getZone(ZONE1.name()));
    created.delete();
    assertNull(DNS.getZone(ZONE1.name()));
  }

  private void assertEqChangesIgnoreStatus(ChangeRequest expected, ChangeRequest actual) {
    ChangeRequest unifiedEx = ChangeRequest.fromPb(expected.toPb().setStatus("pending"));
    ChangeRequest unifiedAct = ChangeRequest.fromPb(actual.toPb().setStatus("pending"));
    assertEquals(unifiedEx, unifiedAct);
  }

  private static void checkChangeComplete(String zoneName, String changeId) {
    for (int i = 0; i < TIME_LIMIT; i++) {
      ChangeRequest changeRequest = DNS.getChangeRequest(zoneName, changeId,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS));
      if (ChangeRequest.Status.DONE.equals(changeRequest.status())) {
        break;
      } else {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException("Thread was interrupted while waiting for change.");
        }
      }
    }
  }

  @Test
  public void testCreateChangeUsingServiceObject() {
    DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.NAME));
    ChangeRequest created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
    assertEquals(CHANGE_ADD_ZONE1.additions(), created.additions());
    assertNotNull(created.startTimeMillis());
    assertTrue(created.deletions().isEmpty());
    assertEquals("1", created.id());
    assertTrue(ImmutableList.of(ChangeRequest.Status.PENDING, ChangeRequest.Status.DONE)
        .contains(created.status()));
    assertEqChangesIgnoreStatus(created, DNS.getChangeRequest(ZONE1.name(), "1"));
    checkChangeComplete(ZONE1.name(), "1");
    DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "2");
    // with options
    created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ID));
    assertTrue(created.additions().isEmpty());
    assertNull(created.startTimeMillis());
    assertTrue(created.deletions().isEmpty());
    assertEquals("3", created.id());
    assertNull(created.status());
    checkChangeComplete(ZONE1.name(), "3");
    DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "4");
    created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS));
    assertTrue(created.additions().isEmpty());
    assertNull(created.startTimeMillis());
    assertTrue(created.deletions().isEmpty());
    assertEquals("5", created.id());
    assertNotNull(created.status());
    checkChangeComplete(ZONE1.name(), "5");
    DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "6");
    created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME));
    assertTrue(created.additions().isEmpty());
    assertNotNull(created.startTimeMillis());
    assertTrue(created.deletions().isEmpty());
    assertEquals("7", created.id());
    assertNull(created.status());
    checkChangeComplete(ZONE1.name(), "7");
    DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "8");
    created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ADDITIONS));
    assertEquals(CHANGE_ADD_ZONE1.additions(), created.additions());
    assertNull(created.startTimeMillis());
    assertTrue(created.deletions().isEmpty());
    assertEquals("9", created.id());
    assertNull(created.status());
    // finishes with delete otherwise we cannot delete the zone
    checkChangeComplete(ZONE1.name(), "9");
    created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.DELETIONS));
    checkChangeComplete(ZONE1.name(), "10");
    assertEquals(CHANGE_DELETE_ZONE1.deletions(), created.deletions());
    assertNull(created.startTimeMillis());
    assertTrue(created.additions().isEmpty());
    assertEquals("10", created.id());
    assertNull(created.status());
    checkChangeComplete(ZONE1.name(), "10");
  }

  @Test
  public void testCreateChangeUsingZoneObject() {
    Zone zone = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.NAME));
    ChangeRequest created = zone.applyChangeRequest(CHANGE_ADD_ZONE1);
    assertEquals(CHANGE_ADD_ZONE1.additions(), created.additions());
    assertNotNull(created.startTimeMillis());
    assertTrue(created.deletions().isEmpty());
    assertEquals("1", created.id());
    assertTrue(ImmutableList.of(ChangeRequest.Status.PENDING, ChangeRequest.Status.DONE)
        .contains(created.status()));
    assertEqChangesIgnoreStatus(created, DNS.getChangeRequest(ZONE1.name(), "1"));
    checkChangeComplete(ZONE1.name(), "1");
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "2");
    // with options
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ID));
    assertTrue(created.additions().isEmpty());
    assertNull(created.startTimeMillis());
    assertTrue(created.deletions().isEmpty());
    assertEquals("3", created.id());
    assertNull(created.status());
    checkChangeComplete(ZONE1.name(), "3");
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "4");
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS));
    assertTrue(created.additions().isEmpty());
    assertNull(created.startTimeMillis());
    assertTrue(created.deletions().isEmpty());
    assertEquals("5", created.id());
    assertNotNull(created.status());
    checkChangeComplete(ZONE1.name(), "5");
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "6");
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME));
    assertTrue(created.additions().isEmpty());
    assertNotNull(created.startTimeMillis());
    assertTrue(created.deletions().isEmpty());
    assertEquals("7", created.id());
    assertNull(created.status());
    checkChangeComplete(ZONE1.name(), "7");
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "8");
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ADDITIONS));
    assertEquals(CHANGE_ADD_ZONE1.additions(), created.additions());
    assertNull(created.startTimeMillis());
    assertTrue(created.deletions().isEmpty());
    assertEquals("9", created.id());
    assertNull(created.status());
    // finishes with delete otherwise we cannot delete the zone
    checkChangeComplete(ZONE1.name(), "9");
    created = zone.applyChangeRequest(CHANGE_DELETE_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.DELETIONS));
    checkChangeComplete(ZONE1.name(), "10");
    assertEquals(CHANGE_DELETE_ZONE1.deletions(), created.deletions());
    assertNull(created.startTimeMillis());
    assertTrue(created.additions().isEmpty());
    assertEquals("10", created.id());
    assertNull(created.status());
    checkChangeComplete(ZONE1.name(), "10");
  }

  @Test
  public void testListChangesUsingService() {
    // no such zone exists
    try {
      DNS.listChangeRequests(ZONE1.name());
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(404, ex.code());
      // todo(mderka) test retry functionality
    }
    // zone exists but has no changes
    DNS.create(ZONE1);
    ImmutableList<ChangeRequest> changes = ImmutableList.copyOf(
        DNS.listChangeRequests(ZONE1.name()).iterateAll());
    assertEquals(1, changes.size()); // default change creating SOA and NS
    // zone has changes
    ChangeRequest change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
    checkChangeComplete(ZONE1.name(), change.id());
    change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), change.id());
    change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
    checkChangeComplete(ZONE1.name(), change.id());
    change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), change.id());
    changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.name()).iterateAll());
    assertEquals(5, changes.size());
    // error in options
    try {
      DNS.listChangeRequests(ZONE1.name(), Dns.ChangeRequestListOption.pageSize(0));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test retry functionality
    }
    try {
      DNS.listChangeRequests(ZONE1.name(), Dns.ChangeRequestListOption.pageSize(-1));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test retry functionality
    }
    // sorting order
    ImmutableList<ChangeRequest> ascending = ImmutableList.copyOf(DNS.listChangeRequests(
        ZONE1.name(),
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING)).iterateAll());
    ImmutableList<ChangeRequest> descending = ImmutableList.copyOf(DNS.listChangeRequests(
        ZONE1.name(),
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.DESCENDING)).iterateAll());
    int size = 5;
    assertEquals(size, descending.size());
    assertEquals(size, ascending.size());
    for (int i = 0; i < size; i++) {
      assertEquals(descending.get(i), ascending.get(size - i - 1));
    }
    // field options
    changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.name(),
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
        Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.ADDITIONS)).iterateAll());
    change = changes.get(1);
    assertEquals(CHANGE_ADD_ZONE1.additions(), change.additions());
    assertTrue(change.deletions().isEmpty());
    assertEquals("1", change.id());
    assertNull(change.startTimeMillis());
    assertNull(change.status());
    changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.name(),
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
        Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.DELETIONS)).iterateAll());
    change = changes.get(2);
    assertTrue(change.additions().isEmpty());
    assertNotNull(change.deletions());
    assertEquals("2", change.id());
    assertNull(change.startTimeMillis());
    assertNull(change.status());
    changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.name(),
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
        Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.ID)).iterateAll());
    change = changes.get(1);
    assertTrue(change.additions().isEmpty());
    assertTrue(change.deletions().isEmpty());
    assertEquals("1", change.id());
    assertNull(change.startTimeMillis());
    assertNull(change.status());
    changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.name(),
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
        Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.START_TIME)).iterateAll());
    change = changes.get(1);
    assertTrue(change.additions().isEmpty());
    assertTrue(change.deletions().isEmpty());
    assertEquals("1", change.id());
    assertNotNull(change.startTimeMillis());
    assertNull(change.status());
    changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.name(),
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
        Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.STATUS)).iterateAll());
    change = changes.get(1);
    assertTrue(change.additions().isEmpty());
    assertTrue(change.deletions().isEmpty());
    assertEquals("1", change.id());
    assertNull(change.startTimeMillis());
    assertEquals(ChangeRequest.Status.DONE, change.status());
  }

  @Test
  public void testListChangesUsingZoneObject() {
    // zone exists but has no changes
    Zone created = DNS.create(ZONE1);
    ImmutableList<ChangeRequest> changes = ImmutableList.copyOf(
        created.listChangeRequests().iterateAll());
    assertEquals(1, changes.size()); // default change creating SOA and NS
    // zone has changes
    ChangeRequest change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
    checkChangeComplete(ZONE1.name(), change.id());
    change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), change.id());
    change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
    checkChangeComplete(ZONE1.name(), change.id());
    change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), change.id());
    changes = ImmutableList.copyOf(created.listChangeRequests().iterateAll());
    assertEquals(5, changes.size());
    // error in options
    try {
      created.listChangeRequests(Dns.ChangeRequestListOption.pageSize(0));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test retry functionality
    }
    try {
      created.listChangeRequests(Dns.ChangeRequestListOption.pageSize(-1));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test retry functionality
    }
    // sorting order
    ImmutableList<ChangeRequest> ascending = ImmutableList.copyOf(created.listChangeRequests(
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING)).iterateAll());
    ImmutableList<ChangeRequest> descending = ImmutableList.copyOf(created.listChangeRequests(
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.DESCENDING)).iterateAll());
    int size = 5;
    assertEquals(size, descending.size());
    assertEquals(size, ascending.size());
    for (int i = 0; i < size; i++) {
      assertEquals(descending.get(i), ascending.get(size - i - 1));
    }
    // field options
    changes = ImmutableList.copyOf(created.listChangeRequests(
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
        Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.ADDITIONS)).iterateAll());
    change = changes.get(1);
    assertEquals(CHANGE_ADD_ZONE1.additions(), change.additions());
    assertTrue(change.deletions().isEmpty());
    assertEquals("1", change.id());
    assertNull(change.startTimeMillis());
    assertNull(change.status());
    changes = ImmutableList.copyOf(created.listChangeRequests(
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
        Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.DELETIONS)).iterateAll());
    change = changes.get(2);
    assertTrue(change.additions().isEmpty());
    assertNotNull(change.deletions());
    assertEquals("2", change.id());
    assertNull(change.startTimeMillis());
    assertNull(change.status());
    changes = ImmutableList.copyOf(created.listChangeRequests(
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
        Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.ID)).iterateAll());
    change = changes.get(1);
    assertTrue(change.additions().isEmpty());
    assertTrue(change.deletions().isEmpty());
    assertEquals("1", change.id());
    assertNull(change.startTimeMillis());
    assertNull(change.status());
    changes = ImmutableList.copyOf(created.listChangeRequests(
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
        Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.START_TIME)).iterateAll());
    change = changes.get(1);
    assertTrue(change.additions().isEmpty());
    assertTrue(change.deletions().isEmpty());
    assertEquals("1", change.id());
    assertNotNull(change.startTimeMillis());
    assertNull(change.status());
    changes = ImmutableList.copyOf(created.listChangeRequests(
        Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
        Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.STATUS)).iterateAll());
    change = changes.get(1);
    assertTrue(change.additions().isEmpty());
    assertTrue(change.deletions().isEmpty());
    assertEquals("1", change.id());
    assertNull(change.startTimeMillis());
    assertEquals(ChangeRequest.Status.DONE, change.status());
  }

  @Test
  public void testGetChangeUsingZoneObject() {
    Zone zone = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.NAME));
    ChangeRequest created = zone.applyChangeRequest(CHANGE_ADD_ZONE1);
    ChangeRequest retrieved = zone.getChangeRequest(created.id());
    assertEqChangesIgnoreStatus(created, retrieved);
    checkChangeComplete(ZONE1.name(), "1");
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "2");
    // with options
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ID));
    retrieved = zone.getChangeRequest(created.id(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ID));
    assertEqChangesIgnoreStatus(created, retrieved);
    checkChangeComplete(ZONE1.name(), "3");
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "4");
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS));
    retrieved = zone.getChangeRequest(created.id(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS));
    assertEqChangesIgnoreStatus(created, retrieved);
    checkChangeComplete(ZONE1.name(), "5");
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "6");
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME));
    retrieved = zone.getChangeRequest(created.id(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME));
    assertEqChangesIgnoreStatus(created, retrieved);
    checkChangeComplete(ZONE1.name(), "7");
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    checkChangeComplete(ZONE1.name(), "8");
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ADDITIONS));
    retrieved = zone.getChangeRequest(created.id(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ADDITIONS));
    assertEqChangesIgnoreStatus(created, retrieved);
    // finishes with delete otherwise we cannot delete the zone
    checkChangeComplete(ZONE1.name(), "9");
    created = zone.applyChangeRequest(CHANGE_DELETE_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.DELETIONS));
    retrieved = zone.getChangeRequest(created.id(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.DELETIONS));
    assertEqChangesIgnoreStatus(created, retrieved);
    checkChangeComplete(ZONE1.name(), "10");
  }

  @Test
  public void testGetChangeUsingServiceObject() {
    Zone zone = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.NAME));
    ChangeRequest created = zone.applyChangeRequest(CHANGE_ADD_ZONE1);
    ChangeRequest retrieved = DNS.getChangeRequest(zone.name(), created.id());
    assertEqChangesIgnoreStatus(created, retrieved);
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    // with options
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ID));
    retrieved = DNS.getChangeRequest(zone.name(), created.id(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ID));
    assertEqChangesIgnoreStatus(created, retrieved);
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS));
    retrieved = DNS.getChangeRequest(zone.name(), created.id(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS));
    assertEqChangesIgnoreStatus(created, retrieved);
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME));
    retrieved = DNS.getChangeRequest(zone.name(), created.id(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME));
    assertEqChangesIgnoreStatus(created, retrieved);
    zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ADDITIONS));
    retrieved = DNS.getChangeRequest(zone.name(), created.id(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ADDITIONS));
    assertEqChangesIgnoreStatus(created, retrieved);
    // finishes with delete otherwise we cannot delete the zone
    created = zone.applyChangeRequest(CHANGE_DELETE_ZONE1,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.DELETIONS));
    retrieved = DNS.getChangeRequest(zone.name(), created.id(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.DELETIONS));
    assertEqChangesIgnoreStatus(created, retrieved);
  }

  @Test
  public void testGetProject() {
    // fetches all fields
    ProjectInfo project = DNS.getProject();
    assertNotNull(project.quota());
    assertNotNull(project.number());
    assertNotNull(project.id());
    assertEquals(PROJECT_ID, project.id());
    // options
    project = DNS.getProject(Dns.ProjectOption.fields(Dns.ProjectField.QUOTA));
    assertNotNull(project.quota());
    assertNull(project.number());
    assertNotNull(project.id()); // id is always returned
    project = DNS.getProject(Dns.ProjectOption.fields(Dns.ProjectField.PROJECT_ID));
    assertNull(project.quota());
    assertNull(project.number());
    assertNotNull(project.id());
    project = DNS.getProject(Dns.ProjectOption.fields(Dns.ProjectField.PROJECT_NUMBER));
    assertNull(project.quota());
    assertNotNull(project.number());
    assertNotNull(project.id());
    project = DNS.getProject(Dns.ProjectOption.fields(Dns.ProjectField.PROJECT_NUMBER,
        Dns.ProjectField.QUOTA, Dns.ProjectField.PROJECT_ID));
    assertNotNull(project.quota());
    assertNotNull(project.number());
    assertNotNull(project.id());
  }

  @Test
  public void testListDnsRecordsUsingService() {
    Zone zone = DNS.create(ZONE1);
    ImmutableList<DnsRecord> dnsRecords = ImmutableList.copyOf(
        DNS.listDnsRecords(zone.name()).iterateAll());
    assertEquals(2, dnsRecords.size());
    ImmutableList<DnsRecord.Type> defaultRecords =
        ImmutableList.of(DnsRecord.Type.NS, DnsRecord.Type.SOA);
    for (DnsRecord record : dnsRecords) {
      assertTrue(defaultRecords.contains(record.type()));
    }
    // field options
    Iterator<DnsRecord> dnsRecordIterator = DNS.listDnsRecords(zone.name(),
        Dns.DnsRecordListOption.fields(Dns.DnsRecordField.TTL)).iterateAll();
    int counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertEquals(dnsRecords.get(counter).ttl(), record.ttl());
      assertEquals(dnsRecords.get(counter).name(), record.name());
      assertEquals(dnsRecords.get(counter).type(), record.type());
      assertTrue(record.records().isEmpty());
      counter++;
    }
    assertEquals(2, counter);
    dnsRecordIterator = DNS.listDnsRecords(zone.name(),
        Dns.DnsRecordListOption.fields(Dns.DnsRecordField.NAME)).iterateAll();
    counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertEquals(dnsRecords.get(counter).name(), record.name());
      assertEquals(dnsRecords.get(counter).type(), record.type());
      assertTrue(record.records().isEmpty());
      assertNull(record.ttl());
      counter++;
    }
    assertEquals(2, counter);
    dnsRecordIterator = DNS.listDnsRecords(zone.name(),
        Dns.DnsRecordListOption.fields(Dns.DnsRecordField.DNS_RECORDS)).iterateAll();
    counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertEquals(dnsRecords.get(counter).records(), record.records());
      assertEquals(dnsRecords.get(counter).name(), record.name());
      assertEquals(dnsRecords.get(counter).type(), record.type());
      assertNull(record.ttl());
      counter++;
    }
    assertEquals(2, counter);
    dnsRecordIterator = DNS.listDnsRecords(zone.name(),
        Dns.DnsRecordListOption.fields(Dns.DnsRecordField.TYPE),
        Dns.DnsRecordListOption.pageSize(1)).iterateAll(); // also test paging
    counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertEquals(dnsRecords.get(counter).type(), record.type());
      assertEquals(dnsRecords.get(counter).name(), record.name());
      assertTrue(record.records().isEmpty());
      assertNull(record.ttl());
      counter++;
    }
    assertEquals(2, counter);
    // test page size
    Page<DnsRecord> dnsRecordPage = DNS.listDnsRecords(zone.name(),
        Dns.DnsRecordListOption.fields(Dns.DnsRecordField.TYPE),
        Dns.DnsRecordListOption.pageSize(1));
    assertEquals(1, ImmutableList.copyOf(dnsRecordPage.values().iterator()).size());
    // test name filter
    ChangeRequest change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
    checkChangeComplete(ZONE1.name(), change.id());
    dnsRecordIterator = DNS.listDnsRecords(ZONE1.name(),
        Dns.DnsRecordListOption.dnsName(A_RECORD_ZONE1.name())).iterateAll();
    counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertTrue(ImmutableList.of(A_RECORD_ZONE1.type(), AAAA_RECORD_ZONE1.type())
          .contains(record.type()));
      counter++;
    }
    assertEquals(2, counter);
    // test type filter
    checkChangeComplete(ZONE1.name(), change.id());
    dnsRecordIterator = DNS.listDnsRecords(ZONE1.name(),
        Dns.DnsRecordListOption.dnsName(A_RECORD_ZONE1.name()),
        Dns.DnsRecordListOption.type(A_RECORD_ZONE1.type()))
        .iterateAll();
    counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertEquals(A_RECORD_ZONE1, record);
      counter++;
    }
    assertEquals(1, counter);
    change = zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    // check wrong arguments
    try {
      // name is not set
      DNS.listDnsRecords(ZONE1.name(),
          Dns.DnsRecordListOption.type(A_RECORD_ZONE1.type()));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test retry functionality when available
    }
    try {
      DNS.listDnsRecords(ZONE1.name(),
          Dns.DnsRecordListOption.pageSize(0));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test retry functionality when available
    }
    try {
      DNS.listDnsRecords(ZONE1.name(),
          Dns.DnsRecordListOption.pageSize(-1));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test retry functionality when available
    }
    checkChangeComplete(ZONE1.name(), change.id());
  }

  @Test
  public void testListDnsRecordsUsingZoneObject() {
    Zone zone = DNS.create(ZONE1);
    ImmutableList<DnsRecord> dnsRecords = ImmutableList.copyOf(
        zone.listDnsRecords().iterateAll());
    assertEquals(2, dnsRecords.size());
    ImmutableList<DnsRecord.Type> defaultRecords =
        ImmutableList.of(DnsRecord.Type.NS, DnsRecord.Type.SOA);
    for (DnsRecord record : dnsRecords) {
      assertTrue(defaultRecords.contains(record.type()));
    }
    // field options
    Iterator<DnsRecord> dnsRecordIterator = zone.listDnsRecords(
        Dns.DnsRecordListOption.fields(Dns.DnsRecordField.TTL)).iterateAll();
    int counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertEquals(dnsRecords.get(counter).ttl(), record.ttl());
      assertEquals(dnsRecords.get(counter).name(), record.name());
      assertEquals(dnsRecords.get(counter).type(), record.type());
      assertTrue(record.records().isEmpty());
      counter++;
    }
    assertEquals(2, counter);
    dnsRecordIterator = zone.listDnsRecords(
        Dns.DnsRecordListOption.fields(Dns.DnsRecordField.NAME)).iterateAll();
    counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertEquals(dnsRecords.get(counter).name(), record.name());
      assertEquals(dnsRecords.get(counter).type(), record.type());
      assertTrue(record.records().isEmpty());
      assertNull(record.ttl());
      counter++;
    }
    assertEquals(2, counter);
    dnsRecordIterator = zone.listDnsRecords(
        Dns.DnsRecordListOption.fields(Dns.DnsRecordField.DNS_RECORDS)).iterateAll();
    counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertEquals(dnsRecords.get(counter).records(), record.records());
      assertEquals(dnsRecords.get(counter).name(), record.name());
      assertEquals(dnsRecords.get(counter).type(), record.type());
      assertNull(record.ttl());
      counter++;
    }
    assertEquals(2, counter);
    dnsRecordIterator = zone.listDnsRecords(
        Dns.DnsRecordListOption.fields(Dns.DnsRecordField.TYPE),
        Dns.DnsRecordListOption.pageSize(1)).iterateAll(); // also test paging
    counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertEquals(dnsRecords.get(counter).type(), record.type());
      assertEquals(dnsRecords.get(counter).name(), record.name());
      assertTrue(record.records().isEmpty());
      assertNull(record.ttl());
      counter++;
    }
    assertEquals(2, counter);
    // test page size
    Page<DnsRecord> dnsRecordPage = zone.listDnsRecords(
        Dns.DnsRecordListOption.fields(Dns.DnsRecordField.TYPE),
        Dns.DnsRecordListOption.pageSize(1));
    assertEquals(1, ImmutableList.copyOf(dnsRecordPage.values().iterator()).size());
    // test name filter
    ChangeRequest change = zone.applyChangeRequest(CHANGE_ADD_ZONE1);
    checkChangeComplete(ZONE1.name(), change.id());
    dnsRecordIterator = zone.listDnsRecords(Dns.DnsRecordListOption.dnsName(A_RECORD_ZONE1.name()))
        .iterateAll();
    counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertTrue(ImmutableList.of(A_RECORD_ZONE1.type(), AAAA_RECORD_ZONE1.type())
          .contains(record.type()));
      counter++;
    }
    assertEquals(2, counter);
    // test type filter
    checkChangeComplete(ZONE1.name(), change.id());
    dnsRecordIterator = zone.listDnsRecords(Dns.DnsRecordListOption.dnsName(A_RECORD_ZONE1.name()),
        Dns.DnsRecordListOption.type(A_RECORD_ZONE1.type()))
        .iterateAll();
    counter = 0;
    while (dnsRecordIterator.hasNext()) {
      DnsRecord record = dnsRecordIterator.next();
      assertEquals(A_RECORD_ZONE1, record);
      counter++;
    }
    assertEquals(1, counter);
    change = zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
    // check wrong arguments
    try {
      // name is not set
      zone.listDnsRecords(Dns.DnsRecordListOption.type(A_RECORD_ZONE1.type()));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test retry functionality when available
    }
    try {
      zone.listDnsRecords(Dns.DnsRecordListOption.pageSize(0));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test retry functionality when available
    }
    try {
      zone.listDnsRecords(Dns.DnsRecordListOption.pageSize(-1));
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      // todo(mderka) test retry functionality when available
    }
    checkChangeComplete(ZONE1.name(), change.id());
  }
}
