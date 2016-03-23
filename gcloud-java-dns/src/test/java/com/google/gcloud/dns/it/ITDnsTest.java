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

package com.google.gcloud.dns.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.Page;
import com.google.gcloud.dns.ChangeRequest;
import com.google.gcloud.dns.Dns;
import com.google.gcloud.dns.DnsException;
import com.google.gcloud.dns.DnsOptions;
import com.google.gcloud.dns.ProjectInfo;
import com.google.gcloud.dns.RecordSet;
import com.google.gcloud.dns.Zone;
import com.google.gcloud.dns.ZoneInfo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ITDnsTest {

  private static final String PREFIX = "gcldjvit-";
  private static final Dns DNS = DnsOptions.defaultInstance().service();
  private static final String ZONE_NAME1 = (PREFIX + UUID.randomUUID()).substring(0, 32);
  private static final String ZONE_NAME_EMPTY_DESCRIPTION =
      (PREFIX + UUID.randomUUID()).substring(0, 32);
  private static final String ZONE_NAME_TOO_LONG = PREFIX + UUID.randomUUID();
  private static final String ZONE_DESCRIPTION1 = "first zone";
  private static final String ZONE_DNS_NAME1 = ZONE_NAME1 + ".com.";
  private static final String ZONE_DNS_EMPTY_DESCRIPTION = ZONE_NAME_EMPTY_DESCRIPTION + ".com.";
  private static final String ZONE_DNS_NAME_NO_PERIOD = ZONE_NAME1 + ".com";
  private static final ZoneInfo ZONE1 =
      ZoneInfo.of(ZONE_NAME1, ZONE_DNS_EMPTY_DESCRIPTION, ZONE_DESCRIPTION1);
  private static final ZoneInfo ZONE_EMPTY_DESCRIPTION =
      ZoneInfo.of(ZONE_NAME_EMPTY_DESCRIPTION, ZONE_DNS_NAME1, ZONE_DESCRIPTION1);
  private static final ZoneInfo ZONE_NAME_ERROR =
      ZoneInfo.of(ZONE_NAME_TOO_LONG, ZONE_DNS_NAME1, ZONE_DESCRIPTION1);
  private static final ZoneInfo ZONE_DNS_NO_PERIOD =
      ZoneInfo.of(ZONE_NAME1, ZONE_DNS_NAME_NO_PERIOD, ZONE_DESCRIPTION1);
  private static final RecordSet A_RECORD_ZONE1 =
      RecordSet.builder("www." + ZONE1.dnsName(), RecordSet.Type.A)
          .records(ImmutableList.of("123.123.55.1"))
          .ttl(25, TimeUnit.SECONDS)
          .build();
  private static final RecordSet AAAA_RECORD_ZONE1 =
      RecordSet.builder("www." + ZONE1.dnsName(), RecordSet.Type.AAAA)
          .records(ImmutableList.of("ed:ed:12:aa:36:3:3:105"))
          .ttl(25, TimeUnit.SECONDS)
          .build();
  private static final ChangeRequest CHANGE_ADD_ZONE1 = ChangeRequest.builder()
      .add(A_RECORD_ZONE1)
      .add(AAAA_RECORD_ZONE1)
      .build();
  private static final ChangeRequest CHANGE_DELETE_ZONE1 = ChangeRequest.builder()
      .delete(A_RECORD_ZONE1)
      .delete(AAAA_RECORD_ZONE1)
      .build();
  private static final List<String> ZONE_NAMES = ImmutableList.of(ZONE_NAME1,
      ZONE_NAME_EMPTY_DESCRIPTION);

  private static void clear() {
    for (String zoneName : ZONE_NAMES) {
      Zone zone = DNS.getZone(zoneName);
      if (zone != null) {
        /* We wait for all changes to complete before retrieving a list of DNS records to be
        deleted. Waiting is necessary as changes potentially might create more records between
        when the list has been retrieved and executing the subsequent delete operation. */
        Iterator<ChangeRequest> iterator = zone.listChangeRequests().iterateAll();
        while (iterator.hasNext()) {
          waitForChangeToComplete(zoneName, iterator.next().id());
        }
        Iterator<RecordSet> recordSetIterator = zone.listRecordSets().iterateAll();
        List<RecordSet> toDelete = new LinkedList<>();
        while (recordSetIterator.hasNext()) {
          RecordSet recordSet = recordSetIterator.next();
          if (!ImmutableList.of(RecordSet.Type.NS, RecordSet.Type.SOA)
              .contains(recordSet.type())) {
            toDelete.add(recordSet);
          }
        }
        if (!toDelete.isEmpty()) {
          ChangeRequest deletion =
              zone.applyChangeRequest(ChangeRequest.builder().deletions(toDelete).build());
          waitForChangeToComplete(zone.name(), deletion.id());
        }
        zone.delete();
      }
    }
  }

  private static List<Zone> filter(Iterator<Zone> iterator) {
    List<Zone> result = new LinkedList<>();
    while (iterator.hasNext()) {
      Zone zone = iterator.next();
      if (ZONE_NAMES.contains(zone.name())) {
        result.add(zone);
      }
    }
    return result;
  }

  @BeforeClass
  public static void before() {
    clear();
  }

  @AfterClass
  public static void after() {
    clear();
  }

  private static void assertEqChangesIgnoreStatus(ChangeRequest expected, ChangeRequest actual) {
    assertEquals(expected.additions(), actual.additions());
    assertEquals(expected.deletions(), actual.deletions());
    assertEquals(expected.id(), actual.id());
    assertEquals(expected.startTimeMillis(), actual.startTimeMillis());
  }

  private static void waitForChangeToComplete(String zoneName, String changeId) {
    while (true) {
      ChangeRequest changeRequest = DNS.getChangeRequest(zoneName, changeId,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS));
      if (ChangeRequest.Status.DONE.equals(changeRequest.status())) {
        return;
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        fail("Thread was interrupted while waiting for change processing.");
      }
    }
  }

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @Test
  public void testCreateValidZone() {
    try {
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
    } finally {
      DNS.delete(ZONE1.name());
      DNS.delete(ZONE_EMPTY_DESCRIPTION.name());
    }
  }

  @Test
  public void testCreateZoneWithErrors() {
    try {
      try {
        DNS.create(ZONE_NAME_ERROR);
        fail("Zone name is missing a period. The service returns an error.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.retryable());
      }
      try {
        DNS.create(ZONE_DNS_NO_PERIOD);
        fail("Zone name is missing a period. The service returns an error.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.retryable());
      }
    } finally {
      DNS.delete(ZONE_NAME_ERROR.name());
      DNS.delete(ZONE_DNS_NO_PERIOD.name());
    }
  }

  @Test
  public void testCreateZoneWithOptions() {
    try {
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
    } finally {
      DNS.delete(ZONE1.name());
    }
  }

  @Test
  public void testGetZone() {
    try {
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
    } finally {
      DNS.delete(ZONE1.name());
    }
  }

  @Test
  public void testListZones() {
    try {
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
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      try {
        DNS.listZones(Dns.ZoneListOption.pageSize(-1));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      // ok size
      zones = filter(DNS.listZones(Dns.ZoneListOption.pageSize(1000)).iterateAll());
      assertEquals(2, zones.size()); // we still have only 2 zones
      // dns name problems
      try {
        DNS.listZones(Dns.ZoneListOption.dnsName("aaaaa"));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      // ok name
      zones = filter(DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName())).iterateAll());
      assertEquals(1, zones.size());
      // field options
      Iterator<Zone> zoneIterator = DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
          Dns.ZoneListOption.fields(Dns.ZoneField.ZONE_ID)).iterateAll();
      Zone zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNotNull(zone.id());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
          Dns.ZoneListOption.fields(Dns.ZoneField.CREATION_TIME)).iterateAll();
      zone = zoneIterator.next();
      assertNotNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.id());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
          Dns.ZoneListOption.fields(Dns.ZoneField.DNS_NAME)).iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNotNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.id());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
          Dns.ZoneListOption.fields(Dns.ZoneField.DESCRIPTION)).iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNotNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.id());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
          Dns.ZoneListOption.fields(Dns.ZoneField.NAME_SERVERS)).iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(!zone.nameServers().isEmpty());
      assertNull(zone.id());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
          Dns.ZoneListOption.fields(Dns.ZoneField.NAME_SERVER_SET)).iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet()); // we cannot set it using gcloud java
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.id());
      assertFalse(zoneIterator.hasNext());
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
    } finally {
      DNS.delete(ZONE1.name());
      DNS.delete(ZONE_EMPTY_DESCRIPTION.name());
    }
  }

  @Test
  public void testDeleteZone() {
    try {
      Zone created = DNS.create(ZONE1);
      assertEquals(created, DNS.getZone(ZONE1.name()));
      DNS.delete(ZONE1.name());
      assertNull(DNS.getZone(ZONE1.name()));
    } finally {
      DNS.delete(ZONE1.name());
    }
  }

  @Test
  public void testCreateChange() {
    try {
      DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.NAME));
      ChangeRequest created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
      assertEquals(CHANGE_ADD_ZONE1.additions(), created.additions());
      assertNotNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertEquals("1", created.id());
      assertTrue(ImmutableList.of(ChangeRequest.Status.PENDING, ChangeRequest.Status.DONE)
          .contains(created.status()));
      assertEqChangesIgnoreStatus(created, DNS.getChangeRequest(ZONE1.name(), "1"));
      waitForChangeToComplete(ZONE1.name(), "1");
      DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.name(), "2");
      // with options
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ID));
      assertTrue(created.additions().isEmpty());
      assertNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertEquals("3", created.id());
      assertNull(created.status());
      waitForChangeToComplete(ZONE1.name(), "3");
      DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.name(), "4");
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS));
      assertTrue(created.additions().isEmpty());
      assertNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertEquals("5", created.id());
      assertNotNull(created.status());
      waitForChangeToComplete(ZONE1.name(), "5");
      DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.name(), "6");
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME));
      assertTrue(created.additions().isEmpty());
      assertNotNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertEquals("7", created.id());
      assertNull(created.status());
      waitForChangeToComplete(ZONE1.name(), "7");
      DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.name(), "8");
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ADDITIONS));
      assertEquals(CHANGE_ADD_ZONE1.additions(), created.additions());
      assertNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertEquals("9", created.id());
      assertNull(created.status());
      // finishes with delete otherwise we cannot delete the zone
      waitForChangeToComplete(ZONE1.name(), "9");
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.DELETIONS));
      waitForChangeToComplete(ZONE1.name(), "10");
      assertEquals(CHANGE_DELETE_ZONE1.deletions(), created.deletions());
      assertNull(created.startTimeMillis());
      assertTrue(created.additions().isEmpty());
      assertEquals("10", created.id());
      assertNull(created.status());
      waitForChangeToComplete(ZONE1.name(), "10");
    } finally {
      clear();
    }
  }

  @Test
  public void testInvalidChangeRequest() {
    Zone zone = DNS.create(ZONE1);
    RecordSet validA =
        RecordSet.builder("subdomain." + zone.dnsName(), RecordSet.Type.A)
            .records(ImmutableList.of("0.255.1.5"))
            .build();
    try {
      ChangeRequest validChange = ChangeRequest.builder().add(validA).build();
      zone.applyChangeRequest(validChange);
      try {
        zone.applyChangeRequest(validChange);
        fail("Created a record set which already exists.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.retryable());
        assertEquals(409, ex.code());
      }
      // delete with field mismatch
      RecordSet mismatch = validA.toBuilder().ttl(20, TimeUnit.SECONDS).build();
      ChangeRequest deletion = ChangeRequest.builder().delete(mismatch).build();
      try {
        zone.applyChangeRequest(deletion);
        fail("Deleted a record set without a complete match.");
      } catch (DnsException ex) {
        // expected
        assertEquals(412, ex.code());
        assertFalse(ex.retryable());
      }
      // delete and add SOA
      Iterator<RecordSet> recordSetIterator = zone.listRecordSets().iterateAll();
      LinkedList<RecordSet> deletions = new LinkedList<>();
      LinkedList<RecordSet> additions = new LinkedList<>();
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        if (recordSet.type() == RecordSet.Type.SOA) {
          deletions.add(recordSet);
          // the subdomain is necessary to get 400 instead of 412
          RecordSet copy = recordSet.toBuilder().name("x." + recordSet.name()).build();
          additions.add(copy);
          break;
        }
      }
      deletion = deletion.toBuilder().deletions(deletions).build();
      ChangeRequest addition = ChangeRequest.builder().additions(additions).build();
      try {
        zone.applyChangeRequest(deletion);
        fail("Deleted SOA.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.retryable());
        assertEquals(400, ex.code());
      }
      try {
        zone.applyChangeRequest(addition);
        fail("Added second SOA.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.retryable());
        assertEquals(400, ex.code());
      }
    } finally {
      ChangeRequest deletion = ChangeRequest.builder().delete(validA).build();
      ChangeRequest request = zone.applyChangeRequest(deletion);
      waitForChangeToComplete(zone.name(), request.id());
      zone.delete();
    }
  }

  @Test
  public void testListChanges() {
    try {
      // no such zone exists
      try {
        DNS.listChangeRequests(ZONE1.name());
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(404, ex.code());
        assertFalse(ex.retryable());
      }
      // zone exists but has no changes
      DNS.create(ZONE1);
      ImmutableList<ChangeRequest> changes = ImmutableList.copyOf(
          DNS.listChangeRequests(ZONE1.name()).iterateAll());
      assertEquals(1, changes.size()); // default change creating SOA and NS
      // zone has changes
      ChangeRequest change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.id());
      change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.id());
      change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.id());
      change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.id());
      changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.name()).iterateAll());
      assertEquals(5, changes.size());
      // error in options
      try {
        DNS.listChangeRequests(ZONE1.name(), Dns.ChangeRequestListOption.pageSize(0));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      try {
        DNS.listChangeRequests(ZONE1.name(), Dns.ChangeRequestListOption.pageSize(-1));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
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
    } finally {
      clear();
    }
  }

  @Test
  public void testGetChange() {
    try {
      Zone zone = DNS.create(ZONE1, Dns.ZoneOption.fields(Dns.ZoneField.NAME));
      ChangeRequest created = zone.applyChangeRequest(CHANGE_ADD_ZONE1);
      ChangeRequest retrieved = DNS.getChangeRequest(zone.name(), created.id());
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.id());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      // with options
      created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ID));
      retrieved = DNS.getChangeRequest(zone.name(), created.id(),
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ID));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.id());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS));
      retrieved = DNS.getChangeRequest(zone.name(), created.id(),
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.id());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME));
      retrieved = DNS.getChangeRequest(zone.name(), created.id(),
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.id());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ADDITIONS));
      retrieved = DNS.getChangeRequest(zone.name(), created.id(),
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.ADDITIONS));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.id());
      // finishes with delete otherwise we cannot delete the zone
      created = zone.applyChangeRequest(CHANGE_DELETE_ZONE1,
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.DELETIONS));
      retrieved = DNS.getChangeRequest(zone.name(), created.id(),
          Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.DELETIONS));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.id());
    } finally {
      clear();
    }
  }

  @Test
  public void testGetProject() {
    // fetches all fields
    ProjectInfo project = DNS.getProject();
    assertNotNull(project.quota());
    // options
    project = DNS.getProject(Dns.ProjectOption.fields(Dns.ProjectField.QUOTA));
    assertNotNull(project.quota());
    project = DNS.getProject(Dns.ProjectOption.fields(Dns.ProjectField.PROJECT_ID));
    assertNull(project.quota());
    project = DNS.getProject(Dns.ProjectOption.fields(Dns.ProjectField.PROJECT_NUMBER));
    assertNull(project.quota());
    project = DNS.getProject(Dns.ProjectOption.fields(Dns.ProjectField.PROJECT_NUMBER,
        Dns.ProjectField.QUOTA, Dns.ProjectField.PROJECT_ID));
    assertNotNull(project.quota());
  }

  @Test
  public void testListDnsRecords() {
    try {
      Zone zone = DNS.create(ZONE1);
      ImmutableList<RecordSet> recordSets = ImmutableList.copyOf(
          DNS.listRecordSets(zone.name()).iterateAll());
      assertEquals(2, recordSets.size());
      ImmutableList<RecordSet.Type> defaultRecords =
          ImmutableList.of(RecordSet.Type.NS, RecordSet.Type.SOA);
      for (RecordSet recordSet : recordSets) {
        assertTrue(defaultRecords.contains(recordSet.type()));
      }
      // field options
      Iterator<RecordSet> recordSetIterator = DNS.listRecordSets(zone.name(),
          Dns.RecordSetListOption.fields(Dns.RecordSetField.TTL)).iterateAll();
      int counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).ttl(), recordSet.ttl());
        assertEquals(recordSets.get(counter).name(), recordSet.name());
        assertEquals(recordSets.get(counter).type(), recordSet.type());
        assertTrue(recordSet.records().isEmpty());
        counter++;
      }
      assertEquals(2, counter);
      recordSetIterator = DNS.listRecordSets(zone.name(),
          Dns.RecordSetListOption.fields(Dns.RecordSetField.NAME)).iterateAll();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).name(), recordSet.name());
        assertEquals(recordSets.get(counter).type(), recordSet.type());
        assertTrue(recordSet.records().isEmpty());
        assertNull(recordSet.ttl());
        counter++;
      }
      assertEquals(2, counter);
      recordSetIterator = DNS.listRecordSets(zone.name(),
          Dns.RecordSetListOption.fields(Dns.RecordSetField.DNS_RECORDS))
          .iterateAll();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).records(), recordSet.records());
        assertEquals(recordSets.get(counter).name(), recordSet.name());
        assertEquals(recordSets.get(counter).type(), recordSet.type());
        assertNull(recordSet.ttl());
        counter++;
      }
      assertEquals(2, counter);
      recordSetIterator = DNS.listRecordSets(zone.name(),
          Dns.RecordSetListOption.fields(Dns.RecordSetField.TYPE),
          Dns.RecordSetListOption.pageSize(1)).iterateAll(); // also test paging
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).type(), recordSet.type());
        assertEquals(recordSets.get(counter).name(), recordSet.name());
        assertTrue(recordSet.records().isEmpty());
        assertNull(recordSet.ttl());
        counter++;
      }
      assertEquals(2, counter);
      // test page size
      Page<RecordSet> recordSetPage = DNS.listRecordSets(zone.name(),
          Dns.RecordSetListOption.fields(Dns.RecordSetField.TYPE),
          Dns.RecordSetListOption.pageSize(1));
      assertEquals(1, ImmutableList.copyOf(recordSetPage.values().iterator()).size());
      // test name filter
      ChangeRequest change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.id());
      recordSetIterator = DNS.listRecordSets(ZONE1.name(),
          Dns.RecordSetListOption.dnsName(A_RECORD_ZONE1.name())).iterateAll();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertTrue(ImmutableList.of(A_RECORD_ZONE1.type(), AAAA_RECORD_ZONE1.type())
            .contains(recordSet.type()));
        counter++;
      }
      assertEquals(2, counter);
      // test type filter
      waitForChangeToComplete(ZONE1.name(), change.id());
      recordSetIterator = DNS.listRecordSets(ZONE1.name(),
          Dns.RecordSetListOption.dnsName(A_RECORD_ZONE1.name()),
          Dns.RecordSetListOption.type(A_RECORD_ZONE1.type()))
          .iterateAll();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(A_RECORD_ZONE1, recordSet);
        counter++;
      }
      assertEquals(1, counter);
      change = zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      // check wrong arguments
      try {
        // name is not set
        DNS.listRecordSets(ZONE1.name(),
            Dns.RecordSetListOption.type(A_RECORD_ZONE1.type()));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      try {
        DNS.listRecordSets(ZONE1.name(), Dns.RecordSetListOption.pageSize(0));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      try {
        DNS.listRecordSets(ZONE1.name(), Dns.RecordSetListOption.pageSize(-1));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      waitForChangeToComplete(ZONE1.name(), change.id());
    } finally {
      clear();
    }
  }
}
