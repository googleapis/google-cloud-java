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

package com.google.cloud.dns.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.Page;
import com.google.cloud.dns.ChangeRequest;
import com.google.cloud.dns.ChangeRequestInfo;
import com.google.cloud.dns.Dns;
import com.google.cloud.dns.Dns.ChangeRequestField;
import com.google.cloud.dns.Dns.ProjectField;
import com.google.cloud.dns.Dns.RecordSetField;
import com.google.cloud.dns.Dns.ZoneField;
import com.google.cloud.dns.DnsBatch;
import com.google.cloud.dns.DnsBatchResult;
import com.google.cloud.dns.DnsException;
import com.google.cloud.dns.DnsOptions;
import com.google.cloud.dns.ProjectInfo;
import com.google.cloud.dns.RecordSet;
import com.google.cloud.dns.Zone;
import com.google.cloud.dns.ZoneInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

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
  private static final ChangeRequestInfo CHANGE_ADD_ZONE1 = ChangeRequest.builder()
      .add(A_RECORD_ZONE1)
      .add(AAAA_RECORD_ZONE1)
      .build();
  private static final ChangeRequestInfo CHANGE_DELETE_ZONE1 = ChangeRequest.builder()
      .delete(A_RECORD_ZONE1)
      .delete(AAAA_RECORD_ZONE1)
      .build();
  private static final List<String> ZONE_NAMES = ImmutableList.of(ZONE_NAME1,
      ZONE_NAME_EMPTY_DESCRIPTION);

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  private static void clear() {
    for (String zoneName : ZONE_NAMES) {
      Zone zone = DNS.getZone(zoneName);
      if (zone != null) {
        /* We wait for all changes to complete before retrieving a list of DNS records to be
        deleted. Waiting is necessary as changes potentially might create more records between
        when the list has been retrieved and executing the subsequent delete operation. */
        Iterator<ChangeRequest> iterator = zone.listChangeRequests().iterateAll();
        while (iterator.hasNext()) {
          waitForChangeToComplete(zoneName, iterator.next().generatedId());
        }
        Iterator<RecordSet> recordSetIterator = zone.listRecordSets().iterateAll();
        List<RecordSet> toDelete = new LinkedList<>();
        while (recordSetIterator.hasNext()) {
          RecordSet recordSet = recordSetIterator.next();
          if (!ImmutableList.of(RecordSet.Type.NS, RecordSet.Type.SOA).contains(recordSet.type())) {
            toDelete.add(recordSet);
          }
        }
        if (!toDelete.isEmpty()) {
          ChangeRequest deletion =
              zone.applyChangeRequest(ChangeRequest.builder().deletions(toDelete).build());
          waitForChangeToComplete(zone.name(), deletion.generatedId());
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
    assertEquals(expected.generatedId(), actual.generatedId());
    assertEquals(expected.startTimeMillis(), actual.startTimeMillis());
  }

  private static void waitForChangeToComplete(String zoneName, String changeId) {
    ChangeRequest changeRequest = DNS.getChangeRequest(zoneName, changeId,
        Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
    waitForChangeToComplete(changeRequest);
  }

  private static void waitForChangeToComplete(ChangeRequest changeRequest) {
    while (!changeRequest.isDone()) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        fail("Thread was interrupted while waiting for change processing.");
      }
    }
  }

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
      assertNotNull(created.generatedId());
      Zone retrieved = DNS.getZone(ZONE1.name());
      assertEquals(created, retrieved);
      created = DNS.create(ZONE_EMPTY_DESCRIPTION);
      assertEquals(ZONE_EMPTY_DESCRIPTION.description(), created.description());
      assertEquals(ZONE_EMPTY_DESCRIPTION.dnsName(), created.dnsName());
      assertEquals(ZONE_EMPTY_DESCRIPTION.name(), created.name());
      assertNotNull(created.creationTimeMillis());
      assertNotNull(created.nameServers());
      assertNull(created.nameServerSet());
      assertNotNull(created.generatedId());
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
      Zone created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.CREATION_TIME));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNotNull(created.creationTimeMillis());
      assertNull(created.description());
      assertNull(created.dnsName());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.DESCRIPTION));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertEquals(ZONE1.description(), created.description());
      assertNull(created.dnsName());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.DNS_NAME));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertEquals(ZONE1.dnsName(), created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME_SERVER_SET));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet()); // we did not set it
      assertNull(created.generatedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME_SERVERS));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertFalse(created.nameServers().isEmpty());
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.ZONE_ID));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertNotNull(created.nameServers());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNotNull(created.generatedId());
      created.delete();
      // combination of multiple things
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.ZONE_ID,
          ZoneField.NAME_SERVERS, ZoneField.NAME_SERVER_SET, ZoneField.DESCRIPTION));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertEquals(ZONE1.description(), created.description());
      assertFalse(created.nameServers().isEmpty());
      assertNull(created.nameServerSet()); // we did not set it
      assertNotNull(created.generatedId());
    } finally {
      DNS.delete(ZONE1.name());
    }
  }

  @Test
  public void testGetZone() {
    try {
      DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      Zone created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.CREATION_TIME));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNotNull(created.creationTimeMillis());
      assertNull(created.description());
      assertNull(created.dnsName());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.DESCRIPTION));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertEquals(ZONE1.description(), created.description());
      assertNull(created.dnsName());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.DNS_NAME));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertEquals(ZONE1.dnsName(), created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.NAME));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.NAME_SERVER_SET));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet()); // we did not set it
      assertNull(created.generatedId());
      created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.NAME_SERVERS));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertFalse(created.nameServers().isEmpty());
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.ZONE_ID));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertNotNull(created.nameServers());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNotNull(created.generatedId());
      // combination of multiple things
      created = DNS.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.ZONE_ID,
          ZoneField.NAME_SERVERS, ZoneField.NAME_SERVER_SET, ZoneField.DESCRIPTION));
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertEquals(ZONE1.description(), created.description());
      assertFalse(created.nameServers().isEmpty());
      assertNull(created.nameServerSet()); // we did not set it
      assertNotNull(created.generatedId());
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
          Dns.ZoneListOption.fields(ZoneField.ZONE_ID)).iterateAll();
      Zone zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNotNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
          Dns.ZoneListOption.fields(ZoneField.CREATION_TIME)).iterateAll();
      zone = zoneIterator.next();
      assertNotNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
          Dns.ZoneListOption.fields(ZoneField.DNS_NAME)).iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNotNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
          Dns.ZoneListOption.fields(ZoneField.DESCRIPTION)).iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNotNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
          Dns.ZoneListOption.fields(ZoneField.NAME_SERVERS)).iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertFalse(zone.nameServers().isEmpty());
      assertNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
          Dns.ZoneListOption.fields(ZoneField.NAME_SERVER_SET)).iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet()); // we cannot set it using gcloud java
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      // several combined
      zones = filter(DNS.listZones(Dns.ZoneListOption.fields(ZoneField.ZONE_ID,
          ZoneField.DESCRIPTION),
          Dns.ZoneListOption.pageSize(1)).iterateAll());
      assertEquals(2, zones.size());
      for (Zone current : zones) {
        assertNull(current.creationTimeMillis());
        assertNotNull(current.name());
        assertNull(current.dnsName());
        assertNotNull(current.description());
        assertNull(current.nameServerSet());
        assertTrue(zone.nameServers().isEmpty());
        assertNotNull(current.generatedId());
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
      DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      ChangeRequest created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
      assertEquals(CHANGE_ADD_ZONE1.additions(), created.additions());
      assertNotNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertNotNull(created.generatedId());
      assertTrue(ImmutableList.of(ChangeRequest.Status.PENDING, ChangeRequest.Status.DONE)
          .contains(created.status()));
      assertEqChangesIgnoreStatus(created, DNS.getChangeRequest(ZONE1.name(), "1"));
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      // with options
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.ID));
      assertTrue(created.additions().isEmpty());
      assertNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertNotNull(created.generatedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
      assertTrue(created.additions().isEmpty());
      assertNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertNotNull(created.generatedId());
      assertNotNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.START_TIME));
      assertTrue(created.additions().isEmpty());
      assertNotNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertNotNull(created.generatedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.ADDITIONS));
      assertEquals(CHANGE_ADD_ZONE1.additions(), created.additions());
      assertNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertNotNull(created.generatedId());
      assertNull(created.status());
      // finishes with delete otherwise we cannot delete the zone
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      waitForChangeToComplete(created);
      assertEquals(CHANGE_DELETE_ZONE1.deletions(), created.deletions());
      assertNull(created.startTimeMillis());
      assertTrue(created.additions().isEmpty());
      assertNotNull(created.generatedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
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
    boolean recordAdded = false;
    try {
      ChangeRequestInfo validChange = ChangeRequest.builder().add(validA).build();
      zone.applyChangeRequest(validChange);
      recordAdded = true;
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
      ChangeRequestInfo deletion = ChangeRequest.builder().delete(mismatch).build();
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
      ChangeRequestInfo addition = ChangeRequest.builder().additions(additions).build();
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
      if (recordAdded) {
        ChangeRequestInfo deletion = ChangeRequest.builder().delete(validA).build();
        ChangeRequest request = zone.applyChangeRequest(deletion);
        waitForChangeToComplete(zone.name(), request.generatedId());
      }
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
      waitForChangeToComplete(ZONE1.name(), change.generatedId());
      change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.generatedId());
      change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.generatedId());
      change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.generatedId());
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
          Dns.ChangeRequestListOption.fields(ChangeRequestField.ADDITIONS)).iterateAll());
      change = changes.get(1);
      assertEquals(CHANGE_ADD_ZONE1.additions(), change.additions());
      assertTrue(change.deletions().isEmpty());
      assertNotNull(change.generatedId());
      assertNull(change.startTimeMillis());
      assertNull(change.status());
      changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
          Dns.ChangeRequestListOption.fields(ChangeRequestField.DELETIONS)).iterateAll());
      change = changes.get(2);
      assertTrue(change.additions().isEmpty());
      assertNotNull(change.deletions());
      assertNotNull(change.generatedId());
      assertNull(change.startTimeMillis());
      assertNull(change.status());
      changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
          Dns.ChangeRequestListOption.fields(ChangeRequestField.ID)).iterateAll());
      change = changes.get(1);
      assertTrue(change.additions().isEmpty());
      assertTrue(change.deletions().isEmpty());
      assertNotNull(change.generatedId());
      assertNull(change.startTimeMillis());
      assertNull(change.status());
      changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
          Dns.ChangeRequestListOption.fields(ChangeRequestField.START_TIME)).iterateAll());
      change = changes.get(1);
      assertTrue(change.additions().isEmpty());
      assertTrue(change.deletions().isEmpty());
      assertNotNull(change.generatedId());
      assertNotNull(change.startTimeMillis());
      assertNull(change.status());
      changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
          Dns.ChangeRequestListOption.fields(ChangeRequestField.STATUS)).iterateAll());
      change = changes.get(1);
      assertTrue(change.additions().isEmpty());
      assertTrue(change.deletions().isEmpty());
      assertNotNull(change.generatedId());
      assertNull(change.startTimeMillis());
      assertEquals(ChangeRequest.Status.DONE, change.status());
    } finally {
      clear();
    }
  }

  @Test
  public void testGetChange() {
    try {
      Zone zone = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      ChangeRequest created = zone.applyChangeRequest(CHANGE_ADD_ZONE1);
      ChangeRequest retrieved = DNS.getChangeRequest(zone.name(), created.generatedId());
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.generatedId());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      // with options
      created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.ID));
      retrieved = DNS.getChangeRequest(zone.name(), created.generatedId(),
          Dns.ChangeRequestOption.fields(ChangeRequestField.ID));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.generatedId());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
      retrieved = DNS.getChangeRequest(zone.name(), created.generatedId(),
          Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.generatedId());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.START_TIME));
      retrieved = DNS.getChangeRequest(zone.name(), created.generatedId(),
          Dns.ChangeRequestOption.fields(ChangeRequestField.START_TIME));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.generatedId());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      created = zone.applyChangeRequest(CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.ADDITIONS));
      retrieved = DNS.getChangeRequest(zone.name(), created.generatedId(),
          Dns.ChangeRequestOption.fields(ChangeRequestField.ADDITIONS));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.generatedId());
      // finishes with delete otherwise we cannot delete the zone
      created = zone.applyChangeRequest(CHANGE_DELETE_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      retrieved = DNS.getChangeRequest(zone.name(), created.generatedId(),
          Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.name(), created.generatedId());
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
    project = DNS.getProject(Dns.ProjectOption.fields(ProjectField.QUOTA));
    assertNotNull(project.quota());
    project = DNS.getProject(Dns.ProjectOption.fields(ProjectField.PROJECT_ID));
    assertNull(project.quota());
    project = DNS.getProject(Dns.ProjectOption.fields(ProjectField.PROJECT_NUMBER));
    assertNull(project.quota());
    project = DNS.getProject(Dns.ProjectOption.fields(ProjectField.PROJECT_NUMBER,
        ProjectField.QUOTA, ProjectField.PROJECT_ID));
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
          Dns.RecordSetListOption.fields(RecordSetField.TTL)).iterateAll();
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
          Dns.RecordSetListOption.fields(RecordSetField.NAME)).iterateAll();
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
          Dns.RecordSetListOption.fields(RecordSetField.DNS_RECORDS))
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
          Dns.RecordSetListOption.fields(RecordSetField.TYPE),
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
          Dns.RecordSetListOption.fields(RecordSetField.TYPE),
          Dns.RecordSetListOption.pageSize(1));
      assertEquals(1, ImmutableList.copyOf(recordSetPage.values().iterator()).size());
      // test name filter
      ChangeRequest change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.generatedId());
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
      waitForChangeToComplete(ZONE1.name(), change.generatedId());
      recordSetIterator = DNS.listRecordSets(ZONE1.name(),
          Dns.RecordSetListOption.dnsName(A_RECORD_ZONE1.name()),
          Dns.RecordSetListOption.type(A_RECORD_ZONE1.type())).iterateAll();
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
      waitForChangeToComplete(ZONE1.name(), change.generatedId());
    } finally {
      clear();
    }
  }

  @Test
  public void testListZonesBatch() {
    try {
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Page<Zone>> result = batch.listZones();
      batch.submit();
      List<Zone> zones = filter(result.get().iterateAll());
      assertEquals(0, zones.size());
      // some zones exists
      Zone firstZone = DNS.create(ZONE1);
      batch = DNS.batch();
      result = batch.listZones();
      batch.submit();
      zones = filter(result.get().iterateAll());
      assertEquals(1, zones.size());
      assertEquals(firstZone, zones.get(0));
      Zone created = DNS.create(ZONE_EMPTY_DESCRIPTION);
      batch = DNS.batch();
      result = batch.listZones();
      DnsBatchResult<Page<Zone>> zeroSizeError =
          batch.listZones(Dns.ZoneListOption.pageSize(0));
      DnsBatchResult<Page<Zone>> negativeSizeError =
          batch.listZones(Dns.ZoneListOption.pageSize(-1));
      DnsBatchResult<Page<Zone>> okSize = batch.listZones(Dns.ZoneListOption.pageSize(1));
      DnsBatchResult<Page<Zone>> nameError = batch.listZones(Dns.ZoneListOption.dnsName("aaaaa"));
      DnsBatchResult<Page<Zone>> okName =
          batch.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()));
      DnsBatchResult<Page<Zone>> idResult =
          batch.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
              Dns.ZoneListOption.fields(ZoneField.ZONE_ID));
      DnsBatchResult<Page<Zone>> timeResult =
          batch.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
              Dns.ZoneListOption.fields(ZoneField.CREATION_TIME));
      DnsBatchResult<Page<Zone>> dnsNameResult =
          batch.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
              Dns.ZoneListOption.fields(ZoneField.DNS_NAME));
      DnsBatchResult<Page<Zone>> descriptionResult =
          batch.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
              Dns.ZoneListOption.fields(ZoneField.DESCRIPTION));
      DnsBatchResult<Page<Zone>> nameServersResult =
          batch.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
              Dns.ZoneListOption.fields(ZoneField.NAME_SERVERS));
      DnsBatchResult<Page<Zone>> nameServerSetResult =
          batch.listZones(Dns.ZoneListOption.dnsName(ZONE1.dnsName()),
              Dns.ZoneListOption.fields(ZoneField.NAME_SERVER_SET));
      DnsBatchResult<Page<Zone>> combinationResult =
          batch.listZones(Dns.ZoneListOption.fields(ZoneField.ZONE_ID, ZoneField.DESCRIPTION),
              Dns.ZoneListOption.pageSize(1));
      batch.submit();
      zones = filter(result.get().iterateAll());
      assertEquals(2, zones.size());
      assertTrue(zones.contains(firstZone));
      assertTrue(zones.contains(created));
      // error in options
      try {
        zeroSizeError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      try {
        negativeSizeError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      // ok size
      assertEquals(1, Iterables.size(okSize.get().values()));
      // dns name problems
      try {
        nameError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      // ok name
      zones = filter(okName.get().iterateAll());
      assertEquals(1, zones.size());
      // field options
      Iterator<Zone> zoneIterator = idResult.get().iterateAll();
      Zone zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNotNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = timeResult.get().iterateAll();
      zone = zoneIterator.next();
      assertNotNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = dnsNameResult.get().iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNotNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = descriptionResult.get().iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNotNull(zone.description());
      assertNull(zone.nameServerSet());
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = nameServersResult.get().iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet());
      assertFalse(zone.nameServers().isEmpty());
      assertNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = nameServerSetResult.get().iterateAll();
      zone = zoneIterator.next();
      assertNull(zone.creationTimeMillis());
      assertNotNull(zone.name());
      assertNull(zone.dnsName());
      assertNull(zone.description());
      assertNull(zone.nameServerSet()); // we cannot set it using gcloud java
      assertTrue(zone.nameServers().isEmpty());
      assertNull(zone.generatedId());
      assertFalse(zoneIterator.hasNext());
      // several combined
      zones = filter(combinationResult.get().iterateAll());
      assertEquals(2, zones.size());
      for (Zone current : zones) {
        assertNull(current.creationTimeMillis());
        assertNotNull(current.name());
        assertNull(current.dnsName());
        assertNotNull(current.description());
        assertNull(current.nameServerSet());
        assertTrue(zone.nameServers().isEmpty());
        assertNotNull(current.generatedId());
      }
    } finally {
      DNS.delete(ZONE1.name());
      DNS.delete(ZONE_EMPTY_DESCRIPTION.name());
    }
  }

  @Test
  public void testCreateValidZoneBatch() {
    try {
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Zone> completeZoneResult = batch.createZone(ZONE1);
      DnsBatchResult<Zone> partialZoneResult = batch.createZone(ZONE_EMPTY_DESCRIPTION);
      batch.submit();
      Zone created = completeZoneResult.get();
      assertEquals(ZONE1.description(), created.description());
      assertEquals(ZONE1.dnsName(), created.dnsName());
      assertEquals(ZONE1.name(), created.name());
      assertNotNull(created.creationTimeMillis());
      assertNotNull(created.nameServers());
      assertNull(created.nameServerSet());
      assertNotNull(created.generatedId());
      Zone retrieved = DNS.getZone(ZONE1.name());
      assertEquals(created, retrieved);
      created = partialZoneResult.get();
      assertEquals(ZONE_EMPTY_DESCRIPTION.description(), created.description());
      assertEquals(ZONE_EMPTY_DESCRIPTION.dnsName(), created.dnsName());
      assertEquals(ZONE_EMPTY_DESCRIPTION.name(), created.name());
      assertNotNull(created.creationTimeMillis());
      assertNotNull(created.nameServers());
      assertNull(created.nameServerSet());
      assertNotNull(created.generatedId());
      retrieved = DNS.getZone(ZONE_EMPTY_DESCRIPTION.name());
      assertEquals(created, retrieved);
    } finally {
      DNS.delete(ZONE1.name());
      DNS.delete(ZONE_EMPTY_DESCRIPTION.name());
    }
  }

  @Test
  public void testCreateZoneWithErrorsBatch() {
    try {
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Zone> nameErrorResult = batch.createZone(ZONE_NAME_ERROR);
      DnsBatchResult<Zone> noPeriodResult = batch.createZone(ZONE_DNS_NO_PERIOD);
      batch.submit();
      try {
        nameErrorResult.get();
        fail("Zone name is missing a period. The service returns an error.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.retryable());
      }
      try {
        noPeriodResult.get();
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
  public void testCreateZoneWithOptionsBatch() {
    try {
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Zone> batchResult =
          batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.CREATION_TIME));
      batch.submit();
      Zone created = batchResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNotNull(created.creationTimeMillis());
      assertNull(created.description());
      assertNull(created.dnsName());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.DESCRIPTION));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertEquals(ZONE1.description(), created.description());
      assertNull(created.dnsName());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.DNS_NAME));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertEquals(ZONE1.dnsName(), created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME_SERVER_SET));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet()); // we did not set it
      assertNull(created.generatedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME_SERVERS));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertFalse(created.nameServers().isEmpty());
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.ZONE_ID));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertNotNull(created.nameServers());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNotNull(created.generatedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.ZONE_ID,
          ZoneField.NAME_SERVERS, ZoneField.NAME_SERVER_SET, ZoneField.DESCRIPTION));
      batch.submit();
      // combination of multiple things
      created = batchResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertEquals(ZONE1.description(), created.description());
      assertFalse(created.nameServers().isEmpty());
      assertNull(created.nameServerSet()); // we did not set it
      assertNotNull(created.generatedId());
    } finally {
      DNS.delete(ZONE1.name());
    }
  }

  @Test
  public void testGetZoneBatch() {
    try {
      DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Zone> timeResult =
          batch.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.CREATION_TIME));
      DnsBatchResult<Zone> descriptionResult =
          batch.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.DESCRIPTION));
      DnsBatchResult<Zone> dnsNameResult =
          batch.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.DNS_NAME));
      DnsBatchResult<Zone> nameResult =
          batch.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.NAME));
      DnsBatchResult<Zone> nameServerSetResult =
          batch.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.NAME_SERVER_SET));
      DnsBatchResult<Zone> nameServersResult =
          batch.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.NAME_SERVERS));
      DnsBatchResult<Zone> idResult =
          batch.getZone(ZONE1.name(), Dns.ZoneOption.fields(ZoneField.ZONE_ID));
      DnsBatchResult<Zone> combinationResult = batch.getZone(ZONE1.name(),
          Dns.ZoneOption.fields(ZoneField.ZONE_ID, ZoneField.NAME_SERVERS,
              ZoneField.NAME_SERVER_SET, ZoneField.DESCRIPTION));
      batch.submit();
      Zone created = timeResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNotNull(created.creationTimeMillis());
      assertNull(created.description());
      assertNull(created.dnsName());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created = descriptionResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertEquals(ZONE1.description(), created.description());
      assertNull(created.dnsName());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created = dnsNameResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertEquals(ZONE1.dnsName(), created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created = nameResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created = nameServerSetResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNull(created.nameServerSet()); // we did not set it
      assertNull(created.generatedId());
      created = nameServersResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertFalse(created.nameServers().isEmpty());
      assertNull(created.nameServerSet());
      assertNull(created.generatedId());
      created = idResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertNull(created.description());
      assertNotNull(created.nameServers());
      assertTrue(created.nameServers().isEmpty()); // never returns null
      assertNotNull(created.generatedId());
      // combination of multiple things
      created = combinationResult.get();
      assertEquals(ZONE1.name(), created.name()); // always returned
      assertNull(created.creationTimeMillis());
      assertNull(created.dnsName());
      assertEquals(ZONE1.description(), created.description());
      assertFalse(created.nameServers().isEmpty());
      assertNull(created.nameServerSet()); // we did not set it
      assertNotNull(created.generatedId());
    } finally {
      DNS.delete(ZONE1.name());
    }
  }

  @Test
  public void testDeleteZoneBatch() {
    try {
      Zone created = DNS.create(ZONE1);
      assertEquals(created, DNS.getZone(ZONE1.name()));
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Boolean> result = batch.deleteZone(ZONE1.name());
      batch.submit();
      assertNull(DNS.getZone(ZONE1.name()));
      assertTrue(result.get());
    } finally {
      DNS.delete(ZONE1.name());
    }
  }

  @Test
  public void testGetProjectBatch() {
    // fetches all fields
    DnsBatch batch = DNS.batch();
    DnsBatchResult<ProjectInfo> result = batch.getProject();
    DnsBatchResult<ProjectInfo> resultQuota =
        batch.getProject(Dns.ProjectOption.fields(ProjectField.QUOTA));
    DnsBatchResult<ProjectInfo> resultId =
        batch.getProject(Dns.ProjectOption.fields(ProjectField.PROJECT_ID));
    DnsBatchResult<ProjectInfo> resultNumber =
        batch.getProject(Dns.ProjectOption.fields(ProjectField.PROJECT_NUMBER));
    DnsBatchResult<ProjectInfo> resultCombination =
        batch.getProject(Dns.ProjectOption.fields(ProjectField.PROJECT_NUMBER,
            ProjectField.QUOTA, ProjectField.PROJECT_ID));
    batch.submit();
    assertNotNull(result.get().quota());
    assertNotNull(resultQuota.get().quota());
    assertNull(resultId.get().quota());
    assertNull(resultNumber.get().quota());
    assertNotNull(resultCombination.get().quota());
  }

  @Test
  public void testCreateChangeBatch() {
    try {
      DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      DnsBatch batch = DNS.batch();
      DnsBatchResult<ChangeRequest> result =
          batch.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
      batch.submit();
      ChangeRequest created = result.get();
      assertEquals(CHANGE_ADD_ZONE1.additions(), created.additions());
      assertNotNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertNotNull(created.generatedId());
      assertTrue(ImmutableList.of(ChangeRequest.Status.PENDING, ChangeRequest.Status.DONE)
          .contains(created.status()));
      assertEqChangesIgnoreStatus(created, DNS.getChangeRequest(ZONE1.name(), "1"));
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      // with options
      batch = DNS.batch();
      result = batch.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.ID));
      batch.submit();
      created = result.get();
      assertTrue(created.additions().isEmpty());
      assertNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertNotNull(created.generatedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      batch = DNS.batch();
      result = batch.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
      batch.submit();
      created = result.get();
      assertTrue(created.additions().isEmpty());
      assertNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertNotNull(created.generatedId());
      assertNotNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      batch = DNS.batch();
      result = batch.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.START_TIME));
      batch.submit();
      created = result.get();
      assertTrue(created.additions().isEmpty());
      assertNotNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertNotNull(created.generatedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      batch = DNS.batch();
      result = batch.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.ADDITIONS));
      batch.submit();
      created = result.get();
      assertEquals(CHANGE_ADD_ZONE1.additions(), created.additions());
      assertNull(created.startTimeMillis());
      assertTrue(created.deletions().isEmpty());
      assertNotNull(created.generatedId());
      assertNull(created.status());
      // finishes with delete otherwise we cannot delete the zone
      waitForChangeToComplete(created);
      batch = DNS.batch();
      result = batch.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      batch.submit();
      created = result.get();
      waitForChangeToComplete(created);
      assertEquals(CHANGE_DELETE_ZONE1.deletions(), created.deletions());
      assertNull(created.startTimeMillis());
      assertTrue(created.additions().isEmpty());
      assertNotNull(created.generatedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
    } finally {
      clear();
    }
  }

  @Test
  public void testGetChangeBatch() {
    try {
      Zone zone = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      ChangeRequest created = zone.applyChangeRequest(CHANGE_ADD_ZONE1);
      waitForChangeToComplete(zone.name(), created.generatedId());
      DnsBatch batch = DNS.batch();
      DnsBatchResult<ChangeRequest> completeResult =
          batch.getChangeRequest(zone.name(), created.generatedId());
      DnsBatchResult<ChangeRequest> idResult =
          batch.getChangeRequest(zone.name(), created.generatedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.ID));
      DnsBatchResult<ChangeRequest> statusResult =
          batch.getChangeRequest(zone.name(), created.generatedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
      DnsBatchResult<ChangeRequest> timeResult =
          batch.getChangeRequest(zone.name(), created.generatedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.START_TIME));
      DnsBatchResult<ChangeRequest> additionsResult =
          batch.getChangeRequest(zone.name(), created.generatedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.ADDITIONS));
      batch.submit();
      assertEqChangesIgnoreStatus(created, completeResult.get());
      // with options
      ChangeRequest retrieved = idResult.get();
      assertEquals(created.generatedId(), retrieved.generatedId());
      assertEquals(0, retrieved.additions().size());
      assertEquals(0, retrieved.deletions().size());
      assertNull(retrieved.startTimeMillis());
      assertNull(retrieved.status());
      retrieved = statusResult.get();
      assertEquals(created.generatedId(), retrieved.generatedId());
      assertEquals(0, retrieved.additions().size());
      assertEquals(0, retrieved.deletions().size());
      assertNull(retrieved.startTimeMillis());
      assertEquals(ChangeRequestInfo.Status.DONE, retrieved.status());
      retrieved = timeResult.get();
      assertEquals(created.generatedId(), retrieved.generatedId());
      assertEquals(0, retrieved.additions().size());
      assertEquals(0, retrieved.deletions().size());
      assertEquals(created.startTimeMillis(), retrieved.startTimeMillis());
      assertNull(retrieved.status());
      retrieved = additionsResult.get();
      assertEquals(created.generatedId(), retrieved.generatedId());
      assertEquals(2, retrieved.additions().size());
      assertTrue(retrieved.additions().contains(A_RECORD_ZONE1));
      assertTrue(retrieved.additions().contains(AAAA_RECORD_ZONE1));
      assertEquals(0, retrieved.deletions().size());
      assertNull(retrieved.startTimeMillis());
      assertNull(retrieved.status());
      // finishes with delete otherwise we cannot delete the zone
      created = zone.applyChangeRequest(CHANGE_DELETE_ZONE1,
          Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      batch = DNS.batch();
      DnsBatchResult<ChangeRequest> deletionsResult =
          batch.getChangeRequest(zone.name(), created.generatedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      batch.submit();
      retrieved = deletionsResult.get();
      assertEquals(created.generatedId(), retrieved.generatedId());
      assertEquals(0, retrieved.additions().size());
      assertEquals(2, retrieved.deletions().size());
      assertTrue(retrieved.deletions().contains(AAAA_RECORD_ZONE1));
      assertTrue(retrieved.deletions().contains(A_RECORD_ZONE1));
      assertNull(retrieved.startTimeMillis());
      assertNull(retrieved.status());
      waitForChangeToComplete(zone.name(), created.generatedId());
    } finally {
      clear();
    }
  }

  @Test
  public void testListChangesBatch() {
    try {
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Page<ChangeRequest>> result = batch.listChangeRequests(ZONE1.name());
      batch.submit();
      try {
        result.get();
        fail("Zone does not exist yet");
      } catch (DnsException ex) {
        // expected
        assertEquals(404, ex.code());
        assertFalse(ex.retryable());
      }
      // zone exists but has no changes
      DNS.create(ZONE1);
      batch = DNS.batch();
      result = batch.listChangeRequests(ZONE1.name());
      batch.submit();
      assertEquals(1, Iterables.size(result.get().values())); // default change creating SOA and NS
      // zone has changes
      ChangeRequest change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.generatedId());
      change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.generatedId());
      batch = DNS.batch();
      result = batch.listChangeRequests(ZONE1.name());
      DnsBatchResult<Page<ChangeRequest>> errorPageSize = batch.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.pageSize(0));
      DnsBatchResult<Page<ChangeRequest>> errorPageNegative = batch.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.pageSize(-1));
      DnsBatchResult<Page<ChangeRequest>> resultAscending = batch.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING));
      DnsBatchResult<Page<ChangeRequest>> resultDescending = batch.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.DESCENDING));
      DnsBatchResult<Page<ChangeRequest>> resultAdditions = batch.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
          Dns.ChangeRequestListOption.fields(ChangeRequestField.ADDITIONS));
      DnsBatchResult<Page<ChangeRequest>> resultDeletions = batch.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
          Dns.ChangeRequestListOption.fields(ChangeRequestField.DELETIONS));
      DnsBatchResult<Page<ChangeRequest>> resultId = batch.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
          Dns.ChangeRequestListOption.fields(ChangeRequestField.ID));
      DnsBatchResult<Page<ChangeRequest>> resultTime = batch.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
          Dns.ChangeRequestListOption.fields(ChangeRequestField.START_TIME));
      DnsBatchResult<Page<ChangeRequest>> resultStatus = batch.listChangeRequests(ZONE1.name(),
          Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
          Dns.ChangeRequestListOption.fields(ChangeRequestField.STATUS));
      batch.submit();
      assertEquals(3, Iterables.size(result.get().values()));
      // error in options
      try {
        errorPageSize.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      try {
        errorPageNegative.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      // sorting order
      ImmutableList<ChangeRequest> ascending =
          ImmutableList.copyOf(resultAscending.get().iterateAll());
      ImmutableList<ChangeRequest> descending =
          ImmutableList.copyOf(resultDescending.get().iterateAll());
      int size = 3;
      assertEquals(size, descending.size());
      assertEquals(size, ascending.size());
      for (int i = 0; i < size; i++) {
        assertEquals(descending.get(i), ascending.get(size - i - 1));
      }
      // field options
      change = Iterables.get(resultAdditions.get().values(), 1);
      assertEquals(CHANGE_ADD_ZONE1.additions(), change.additions());
      assertTrue(change.deletions().isEmpty());
      assertNotNull(change.generatedId());
      assertNull(change.startTimeMillis());
      assertNull(change.status());
      change = Iterables.get(resultDeletions.get().values(), 2);
      assertTrue(change.additions().isEmpty());
      assertNotNull(change.deletions());
      assertNotNull(change.generatedId());
      assertNull(change.startTimeMillis());
      assertNull(change.status());
      change = Iterables.get(resultId.get().values(), 1);
      assertTrue(change.additions().isEmpty());
      assertTrue(change.deletions().isEmpty());
      assertNotNull(change.generatedId());
      assertNull(change.startTimeMillis());
      assertNull(change.status());
      change = Iterables.get(resultTime.get().values(), 1);
      assertTrue(change.additions().isEmpty());
      assertTrue(change.deletions().isEmpty());
      assertNotNull(change.generatedId());
      assertNotNull(change.startTimeMillis());
      assertNull(change.status());
      change = Iterables.get(resultStatus.get().values(), 1);
      assertTrue(change.additions().isEmpty());
      assertTrue(change.deletions().isEmpty());
      assertNotNull(change.generatedId());
      assertNull(change.startTimeMillis());
      assertEquals(ChangeRequest.Status.DONE, change.status());
    } finally {
      clear();
    }
  }

  @Test
  public void testListDnsRecordSetsBatch() {
    try {
      Zone zone = DNS.create(ZONE1);
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Page<RecordSet>> result = batch.listRecordSets(zone.name());
      batch.submit();
      ImmutableList<RecordSet> recordSets = ImmutableList.copyOf(result.get().iterateAll());
      assertEquals(2, recordSets.size());
      ImmutableList<RecordSet.Type> defaultRecords =
          ImmutableList.of(RecordSet.Type.NS, RecordSet.Type.SOA);
      for (RecordSet recordSet : recordSets) {
        assertTrue(defaultRecords.contains(recordSet.type()));
      }
      // field options
      batch = DNS.batch();
      DnsBatchResult<Page<RecordSet>> ttlResult = batch.listRecordSets(zone.name(),
          Dns.RecordSetListOption.fields(RecordSetField.TTL));
      DnsBatchResult<Page<RecordSet>> nameResult = batch.listRecordSets(zone.name(),
          Dns.RecordSetListOption.fields(RecordSetField.NAME));
      DnsBatchResult<Page<RecordSet>> recordsResult = batch.listRecordSets(zone.name(),
          Dns.RecordSetListOption.fields(RecordSetField.DNS_RECORDS));
      DnsBatchResult<Page<RecordSet>> pageSizeResult = batch.listRecordSets(zone.name(),
          Dns.RecordSetListOption.fields(RecordSetField.TYPE),
          Dns.RecordSetListOption.pageSize(1));
      batch.submit();
      Iterator<RecordSet> recordSetIterator = ttlResult.get().iterateAll();
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
      recordSetIterator = nameResult.get().iterateAll();
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
      recordSetIterator = recordsResult.get().iterateAll();
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
      recordSetIterator = pageSizeResult.get().iterateAll(); // also test paging
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
      Page<RecordSet> recordSetPage = pageSizeResult.get();
      assertEquals(1, ImmutableList.copyOf(recordSetPage.values().iterator()).size());
      // test name filter
      ChangeRequest change = DNS.applyChangeRequest(ZONE1.name(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.name(), change.generatedId());
      batch = DNS.batch();
      result = batch.listRecordSets(ZONE1.name(),
          Dns.RecordSetListOption.dnsName(A_RECORD_ZONE1.name()));
      batch.submit();
      recordSetIterator = result.get().iterateAll();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertTrue(ImmutableList.of(A_RECORD_ZONE1.type(), AAAA_RECORD_ZONE1.type())
            .contains(recordSet.type()));
        counter++;
      }
      assertEquals(2, counter);
      // test type filter
      batch = DNS.batch();
      result = batch.listRecordSets(ZONE1.name(),
          Dns.RecordSetListOption.dnsName(A_RECORD_ZONE1.name()),
          Dns.RecordSetListOption.type(A_RECORD_ZONE1.type()));
      batch.submit();
      recordSetIterator = result.get().iterateAll();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(A_RECORD_ZONE1, recordSet);
        counter++;
      }
      assertEquals(1, counter);
      batch = DNS.batch();
      DnsBatchResult<Page<RecordSet>> noNameError = batch.listRecordSets(ZONE1.name(),
          Dns.RecordSetListOption.type(A_RECORD_ZONE1.type()));
      DnsBatchResult<Page<RecordSet>> zeroSizeError =
          batch.listRecordSets(ZONE1.name(), Dns.RecordSetListOption.pageSize(0));
      DnsBatchResult<Page<RecordSet>> negativeSizeError =
          batch.listRecordSets(ZONE1.name(), Dns.RecordSetListOption.pageSize(-1));
      batch.submit();
      // check wrong arguments
      try {
        // name is not set
        noNameError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      try {
        zeroSizeError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      try {
        negativeSizeError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.code());
        assertFalse(ex.retryable());
      }
      waitForChangeToComplete(ZONE1.name(), change.generatedId());
    } finally {
      clear();
    }
  }

  @Test
  public void testBatchCombined() {
    // only testing that the combination is possible
    // the results are validated in the other test methods
    try {
      DNS.create(ZONE1);
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Zone> zoneResult = batch.getZone(ZONE_NAME1);
      DnsBatchResult<ChangeRequest> changeRequestResult = batch.getChangeRequest(ZONE_NAME1, "0");
      DnsBatchResult<Page<RecordSet>> pageResult = batch.listRecordSets(ZONE_NAME1);
      DnsBatchResult<ProjectInfo> projectResult = batch.getProject();
      assertFalse(zoneResult.completed());
      try {
        zoneResult.get();
        fail("this should be submitted first");
      } catch (IllegalStateException ex) {
        // expected
      }
      batch.submit();
      assertNotNull(zoneResult.get().creationTimeMillis());
      assertEquals(ZONE1.dnsName(), zoneResult.get().dnsName());
      assertEquals(ZONE1.description(), zoneResult.get().description());
      assertFalse(zoneResult.get().nameServers().isEmpty());
      assertNull(zoneResult.get().nameServerSet()); // we did not set it
      assertNotNull(zoneResult.get().generatedId());
      assertNotNull(projectResult.get().quota());
      assertEquals(2, Iterables.size(pageResult.get().values()));
      assertNotNull(changeRequestResult.get());
    } finally {
      DNS.delete(ZONE1.name());
    }
  }
}
