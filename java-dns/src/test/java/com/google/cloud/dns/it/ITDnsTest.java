/*
 * Copyright 2016 Google LLC
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
import static org.junit.Assume.assumeFalse;

import com.google.api.gax.paging.Page;
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
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITDnsTest {

  private static final String PREFIX = "gcldjvit-";
  private static final Dns DNS = DnsOptions.getDefaultInstance().getService();
  private static final String ZONE_NAME1 = (PREFIX + UUID.randomUUID()).substring(0, 32);
  private static final String ZONE_NAME_EMPTY_DESCRIPTION =
      (PREFIX + UUID.randomUUID()).substring(0, 32);
  private static final String ZONE_NAME_TOO_LONG = ZONE_NAME1 + UUID.randomUUID();
  private static final String ZONE_DESCRIPTION1 = "first zone";
  private static final String ZONE_DNS_NAME1 = ZONE_NAME1 + ".com.";
  private static final String ZONE_DNS_EMPTY_DESCRIPTION = ZONE_NAME_EMPTY_DESCRIPTION + ".com.";
  private static final String ZONE_DNS_NAME_NO_PERIOD = ZONE_NAME1 + ".com";
  private static final Map<String, String> LABELS =
      ImmutableMap.of("label1", "value1", "label2", "value2");

  private static final String ALGORITHM = "rsasha256";
  private static final String KEY_TYPE1 = "zoneSigning";
  private static final String KEY_TYPE2 = "keySigning";
  private static final String STATE = "on";
  private static final String NON_EXISTENCE = "nsec";
  private static final Long ZSK_KEY_LENGTH = 1024L;
  private static final Long KSK_KEY_LENGTH = 2048L;
  private static final ZoneInfo.KeySpec ZONE_SIGNING_KEY_SPEC =
      ZoneInfo.KeySpec.newBuilder()
          .setAlgorithm(ALGORITHM)
          .setKeyLength(ZSK_KEY_LENGTH)
          .setKeyType(KEY_TYPE1)
          .build();
  private static final ZoneInfo.KeySpec KEY_SIGNING_KEY_SPEC =
      ZoneInfo.KeySpec.newBuilder()
          .setAlgorithm(ALGORITHM)
          .setKeyLength(KSK_KEY_LENGTH)
          .setKeyType(KEY_TYPE2)
          .build();
  private static final List<ZoneInfo.KeySpec> DEFAULT_KEY_SPECS =
      ImmutableList.of(ZONE_SIGNING_KEY_SPEC, KEY_SIGNING_KEY_SPEC);
  private static final ZoneInfo.DnsSecConfig DNS_SEC_CONFIG =
      ZoneInfo.DnsSecConfig.newBuilder()
          .setDefaultKeySpecs(DEFAULT_KEY_SPECS)
          .setState(STATE)
          .setNonExistence(NON_EXISTENCE)
          .build();
  private static final ZoneInfo ZONE1 =
      ZoneInfo.newBuilder(ZONE_NAME1)
          .setDnsName(ZONE_DNS_EMPTY_DESCRIPTION)
          .setDescription(ZONE_DESCRIPTION1)
          .setDnsSecConfig(DNS_SEC_CONFIG)
          .setLabels(LABELS)
          .build();
  private static final ZoneInfo ZONE_DNSSEC =
      ZoneInfo.newBuilder(ZONE_NAME1)
          .setDnsName(ZONE_DNS_NAME1)
          .setDescription(ZONE_DESCRIPTION1)
          .setDnsSecConfig(DNS_SEC_CONFIG)
          .build();
  private static final ZoneInfo ZONE_EMPTY_DESCRIPTION =
      ZoneInfo.of(ZONE_NAME_EMPTY_DESCRIPTION, ZONE_DNS_NAME1, ZONE_DESCRIPTION1);
  private static final ZoneInfo ZONE_NAME_ERROR =
      ZoneInfo.of(ZONE_NAME_TOO_LONG, ZONE_DNS_NAME1, ZONE_DESCRIPTION1);
  private static final ZoneInfo ZONE_DNS_NO_PERIOD =
      ZoneInfo.of(ZONE_NAME1, ZONE_DNS_NAME_NO_PERIOD, ZONE_DESCRIPTION1);
  private static final RecordSet A_RECORD_ZONE1 =
      RecordSet.newBuilder("www." + ZONE1.getDnsName(), RecordSet.Type.A)
          .setRecords(ImmutableList.of("123.123.55.1"))
          .setTtl(25, TimeUnit.SECONDS)
          .build();
  private static final RecordSet AAAA_RECORD_ZONE1 =
      RecordSet.newBuilder("www." + ZONE1.getDnsName(), RecordSet.Type.AAAA)
          .setRecords(ImmutableList.of("ed:ed:12:aa:36:3:3:105"))
          .setTtl(25, TimeUnit.SECONDS)
          .build();
  private static final ChangeRequestInfo CHANGE_ADD_ZONE1 =
      ChangeRequest.newBuilder().add(A_RECORD_ZONE1).add(AAAA_RECORD_ZONE1).build();
  private static final ChangeRequestInfo CHANGE_DELETE_ZONE1 =
      ChangeRequest.newBuilder().delete(A_RECORD_ZONE1).delete(AAAA_RECORD_ZONE1).build();
  private static final List<String> ZONE_NAMES =
      ImmutableList.of(ZONE_NAME1, ZONE_NAME_EMPTY_DESCRIPTION);
  private static final boolean IS_VPC_TEST =
      System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC") != null
          && System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC").equalsIgnoreCase("true");

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  private static void clear() {
    for (String zoneName : ZONE_NAMES) {
      Zone zone = DNS.getZone(zoneName);
      if (zone != null) {
        /* We wait for all changes to complete before retrieving a list of DNS records to be
        deleted. Waiting is necessary as changes potentially might create more records between
        when the list has been retrieved and executing the subsequent delete operation. */
        Iterator<ChangeRequest> iterator = zone.listChangeRequests().iterateAll().iterator();
        while (iterator.hasNext()) {
          waitForChangeToComplete(zoneName, iterator.next().getGeneratedId());
        }
        Iterator<RecordSet> recordSetIterator = zone.listRecordSets().iterateAll().iterator();
        List<RecordSet> toDelete = new LinkedList<>();
        while (recordSetIterator.hasNext()) {
          RecordSet recordSet = recordSetIterator.next();
          if (!ImmutableList.of(RecordSet.Type.NS, RecordSet.Type.SOA)
              .contains(recordSet.getType())) {
            toDelete.add(recordSet);
          }
        }
        if (!toDelete.isEmpty()) {
          ChangeRequest deletion =
              zone.applyChangeRequest(ChangeRequest.newBuilder().setDeletions(toDelete).build());
          waitForChangeToComplete(zone.getName(), deletion.getGeneratedId());
        }
        zone.delete();
      }
    }
  }

  private static List<Zone> filter(Iterator<Zone> iterator) {
    List<Zone> result = new LinkedList<>();
    while (iterator.hasNext()) {
      Zone zone = iterator.next();
      if (ZONE_NAMES.contains(zone.getName())) {
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
    assertEquals(expected.getAdditions(), actual.getAdditions());
    assertEquals(expected.getDeletions(), actual.getDeletions());
    assertEquals(expected.getGeneratedId(), actual.getGeneratedId());
    assertEquals(expected.getStartTimeMillis(), actual.getStartTimeMillis());
  }

  private static void waitForChangeToComplete(String zoneName, String changeId) {
    ChangeRequest changeRequest =
        DNS.getChangeRequest(
            zoneName, changeId, Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
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
    assumeFalse(IS_VPC_TEST);
    try {
      Zone created = DNS.create(ZONE1);
      assertEquals(ZONE1.getDescription(), created.getDescription());
      assertEquals(ZONE1.getDnsName(), created.getDnsName());
      assertEquals(ZONE1.getName(), created.getName());
      assertEquals(ZONE1.getLabels(), created.getLabels());
      assertNotNull(created.getCreationTimeMillis());
      assertNotNull(created.getNameServers());
      assertNull(created.getNameServerSet());
      assertNotNull(created.getGeneratedId());
      Zone retrieved = DNS.getZone(ZONE1.getName());
      assertEquals(created, retrieved);
    } finally {
      DNS.delete(ZONE1.getName());
    }
  }

  @Test
  public void testCreateValidZoneEmptyDescription() {
    assumeFalse(IS_VPC_TEST);
    try {
      Zone created = DNS.create(ZONE_EMPTY_DESCRIPTION);
      assertEquals(ZONE_EMPTY_DESCRIPTION.getDescription(), created.getDescription());
      assertEquals(ZONE_EMPTY_DESCRIPTION.getDnsName(), created.getDnsName());
      assertEquals(ZONE_EMPTY_DESCRIPTION.getName(), created.getName());
      assertNotNull(created.getCreationTimeMillis());
      assertNotNull(created.getNameServers());
      assertNull(created.getNameServerSet());
      assertNotNull(created.getGeneratedId());
      Zone retrieved = DNS.getZone(ZONE_EMPTY_DESCRIPTION.getName());
      assertEquals(created, retrieved);
    } finally {
      DNS.delete(ZONE_EMPTY_DESCRIPTION.getName());
    }
  }

  @Test
  @Ignore
  public void testCreateZoneWithErrors() {
    try {
      try {
        DNS.create(ZONE_NAME_ERROR);
        fail("Zone name is too long. The service returns an error.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.isRetryable());
      }
      try {
        DNS.create(ZONE_DNS_NO_PERIOD);
        fail("Zone name is missing a period. The service returns an error.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.isRetryable());
      }
    } finally {
      DNS.delete(ZONE_NAME_ERROR.getName());
      DNS.delete(ZONE_DNS_NO_PERIOD.getName());
    }
  }

  @Test
  public void testCreateZoneWithOptions() {
    assumeFalse(IS_VPC_TEST);
    try {
      Zone created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.CREATION_TIME));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNotNull(created.getCreationTimeMillis());
      assertNull(created.getDescription());
      assertNull(created.getDnsName());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.DESCRIPTION));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertEquals(ZONE1.getDescription(), created.getDescription());
      assertNull(created.getDnsName());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.DNS_NAME));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertEquals(ZONE1.getDnsName(), created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME_SERVER_SET));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet()); // we did not set it
      assertNull(created.getGeneratedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME_SERVERS));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertFalse(created.getNameServers().isEmpty());
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.ZONE_ID));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertNotNull(created.getNameServers());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNotNull(created.getGeneratedId());
      created.delete();
      created = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.DNSSEC));
      assertEquals(ZONE_DNSSEC.getName(), created.getName());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getGeneratedId());
      assertNull(created.getNameServerSet());
      assertTrue(created.getNameServers().isEmpty());
      ZoneInfo.DnsSecConfig dnsSecConfig = created.getDnsSecConfig();
      assertEquals(2, dnsSecConfig.getDefaultKeySpecs().size());
      assertEquals(NON_EXISTENCE, dnsSecConfig.getNonExistence());
      assertEquals(STATE, dnsSecConfig.getState());
      created.delete();

      // combination of multiple things
      created =
          DNS.create(
              ZONE1,
              Dns.ZoneOption.fields(
                  ZoneField.ZONE_ID,
                  ZoneField.NAME_SERVERS,
                  ZoneField.NAME_SERVER_SET,
                  ZoneField.DESCRIPTION));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertEquals(ZONE1.getDescription(), created.getDescription());
      assertFalse(created.getNameServers().isEmpty());
      assertNull(created.getNameServerSet()); // we did not set it
      assertNotNull(created.getGeneratedId());
    } finally {
      DNS.delete(ZONE1.getName());
    }
  }

  @Test
  public void testZoneCreatedWithDnsSecConfig() {
    assumeFalse(IS_VPC_TEST);
    try {
      Zone created = DNS.create(ZONE_DNSSEC);
      assertEquals(ZONE_DNSSEC.getName(), created.getName());
      assertEquals(ZONE_DNSSEC.getDnsName(), created.getDnsName());
      assertEquals(ZONE_DNSSEC.getDescription(), created.getDescription());
      assertNotNull(created.getCreationTimeMillis());
      assertNotNull(created.getGeneratedId());
      assertNull(created.getNameServerSet());
      assertFalse(created.getNameServers().isEmpty());

      ZoneInfo.DnsSecConfig dnsSecConfig = created.getDnsSecConfig();
      assertEquals(2, dnsSecConfig.getDefaultKeySpecs().size());
      assertEquals(NON_EXISTENCE, dnsSecConfig.getNonExistence());
      assertEquals(STATE, dnsSecConfig.getState());

    } finally {
      DNS.delete(ZONE_DNSSEC.getName());
    }
  }

  @Test
  public void testNotAcceptableStateValue() {
    try {
      String notAcceptableState = "abc";
      ZoneInfo.DnsSecConfig dnsSecConfig =
          ZoneInfo.DnsSecConfig.newBuilder()
              .setDefaultKeySpecs(DEFAULT_KEY_SPECS)
              .setState(notAcceptableState)
              .setNonExistence(NON_EXISTENCE)
              .build();
      ZoneInfo zoneInfo =
          ZoneInfo.newBuilder(ZONE_NAME1)
              .setDnsName(ZONE_DNS_NAME1)
              .setDescription(ZONE_DESCRIPTION1)
              .setDnsSecConfig(dnsSecConfig)
              .build();
      DNS.create(zoneInfo);
      fail();
    } catch (IllegalArgumentException ex) {
      assertEquals(
          "Invalid value, Use one of the value from acceptable values [on, off, transfer]",
          ex.getMessage());
    }
  }

  @Test
  public void testNotAcceptableNonExistenceValue() {
    try {
      String notAcceptableNonExistence = "abc";
      ZoneInfo.DnsSecConfig dnsSecConfig =
          ZoneInfo.DnsSecConfig.newBuilder()
              .setDefaultKeySpecs(DEFAULT_KEY_SPECS)
              .setState(STATE)
              .setNonExistence(notAcceptableNonExistence)
              .build();
      ZoneInfo zoneInfo =
          ZoneInfo.newBuilder(ZONE_NAME1)
              .setDnsName(ZONE_DNS_NAME1)
              .setDescription(ZONE_DESCRIPTION1)
              .setDnsSecConfig(dnsSecConfig)
              .build();
      DNS.create(zoneInfo);
      fail();
    } catch (IllegalArgumentException ex) {
      assertEquals(
          "Invalid value, Use one of the value from acceptable values [nsec, nsec3]",
          ex.getMessage());
    }
  }

  @Test
  public void testGetZone() {
    assumeFalse(IS_VPC_TEST);
    try {
      DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      Zone created = DNS.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.CREATION_TIME));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNotNull(created.getCreationTimeMillis());
      assertNull(created.getDescription());
      assertNull(created.getDnsName());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created = DNS.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.DESCRIPTION));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertEquals(ZONE1.getDescription(), created.getDescription());
      assertNull(created.getDnsName());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created = DNS.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.DNS_NAME));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertEquals(ZONE1.getDnsName(), created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created = DNS.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.NAME));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created = DNS.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.NAME_SERVER_SET));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet()); // we did not set it
      assertNull(created.getGeneratedId());
      created = DNS.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.NAME_SERVERS));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertFalse(created.getNameServers().isEmpty());
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created = DNS.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.LABELS));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty());
      assertNull(created.getNameServerSet());
      assertEquals(LABELS, created.getLabels());
      assertNull(created.getGeneratedId());
      created = DNS.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.ZONE_ID));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertNotNull(created.getNameServers());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNotNull(created.getGeneratedId());
      created = DNS.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.DNSSEC));
      assertEquals(ZONE_DNSSEC.getName(), created.getName());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getGeneratedId());
      assertNull(created.getNameServerSet());
      assertTrue(created.getNameServers().isEmpty());
      ZoneInfo.DnsSecConfig dnsSecConfig = created.getDnsSecConfig();
      assertEquals(2, dnsSecConfig.getDefaultKeySpecs().size());
      assertEquals(NON_EXISTENCE, dnsSecConfig.getNonExistence());
      assertEquals(STATE, dnsSecConfig.getState());
      // combination of multiple things
      created =
          DNS.getZone(
              ZONE1.getName(),
              Dns.ZoneOption.fields(
                  ZoneField.ZONE_ID,
                  ZoneField.NAME_SERVERS,
                  ZoneField.NAME_SERVER_SET,
                  ZoneField.DESCRIPTION,
                  ZoneField.LABELS));
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertEquals(ZONE1.getDescription(), created.getDescription());
      assertFalse(created.getNameServers().isEmpty());
      assertNull(created.getNameServerSet()); // we did not set it
      assertNotNull(created.getGeneratedId());
      assertEquals(ZONE1.getLabels(), created.getLabels());
    } finally {
      DNS.delete(ZONE1.getName());
    }
  }

  @Test
  public void testListZones() {
    assumeFalse(IS_VPC_TEST);
    try {
      List<Zone> zones = filter(DNS.listZones().iterateAll().iterator());
      assertEquals(0, zones.size());
      // some zones exists
      Zone created = DNS.create(ZONE1);
      zones = filter(DNS.listZones().iterateAll().iterator());
      assertEquals(created, zones.get(0));
      assertEquals(1, zones.size());
      created = DNS.create(ZONE_EMPTY_DESCRIPTION);
      zones = filter(DNS.listZones().iterateAll().iterator());
      assertEquals(2, zones.size());
      assertTrue(zones.contains(created));
      // error in options
      try {
        DNS.listZones(Dns.ZoneListOption.pageSize(0));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      try {
        DNS.listZones(Dns.ZoneListOption.pageSize(-1));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      // ok size
      zones = filter(DNS.listZones(Dns.ZoneListOption.pageSize(1000)).iterateAll().iterator());
      assertEquals(2, zones.size()); // we still have only 2 zones
      // dns name problems
      try {
        DNS.listZones(Dns.ZoneListOption.dnsName("aaaaa"));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      // ok name
      zones =
          filter(
              DNS.listZones(Dns.ZoneListOption.dnsName(ZONE1.getDnsName()))
                  .iterateAll()
                  .iterator());
      assertEquals(1, zones.size());
      // field options
      Iterator<Zone> zoneIterator =
          DNS.listZones(
                  Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
                  Dns.ZoneListOption.fields(ZoneField.ZONE_ID))
              .iterateAll()
              .iterator();
      Zone zone = zoneIterator.next();
      assertNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNull(zone.getDnsName());
      assertNull(zone.getDescription());
      assertNull(zone.getNameServerSet());
      assertTrue(zone.getNameServers().isEmpty());
      assertNotNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator =
          DNS.listZones(
                  Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
                  Dns.ZoneListOption.fields(ZoneField.CREATION_TIME))
              .iterateAll()
              .iterator();
      zone = zoneIterator.next();
      assertNotNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNull(zone.getDnsName());
      assertNull(zone.getDescription());
      assertNull(zone.getNameServerSet());
      assertTrue(zone.getNameServers().isEmpty());
      assertNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator =
          DNS.listZones(
                  Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
                  Dns.ZoneListOption.fields(ZoneField.DNS_NAME))
              .iterateAll()
              .iterator();
      zone = zoneIterator.next();
      assertNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNotNull(zone.getDnsName());
      assertNull(zone.getDescription());
      assertNull(zone.getNameServerSet());
      assertTrue(zone.getNameServers().isEmpty());
      assertNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator =
          DNS.listZones(
                  Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
                  Dns.ZoneListOption.fields(ZoneField.DESCRIPTION))
              .iterateAll()
              .iterator();
      zone = zoneIterator.next();
      assertNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNull(zone.getDnsName());
      assertNotNull(zone.getDescription());
      assertNull(zone.getNameServerSet());
      assertTrue(zone.getNameServers().isEmpty());
      assertNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator =
          DNS.listZones(
                  Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
                  Dns.ZoneListOption.fields(ZoneField.NAME_SERVERS))
              .iterateAll()
              .iterator();
      zone = zoneIterator.next();
      assertNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNull(zone.getDnsName());
      assertNull(zone.getDescription());
      assertNull(zone.getNameServerSet());
      assertFalse(zone.getNameServers().isEmpty());
      assertNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator =
          DNS.listZones(
                  Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
                  Dns.ZoneListOption.fields(ZoneField.NAME_SERVER_SET))
              .iterateAll()
              .iterator();
      zone = zoneIterator.next();
      assertNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNull(zone.getDnsName());
      assertNull(zone.getDescription());
      assertNull(zone.getNameServerSet()); // we cannot set it using google-cloud
      assertTrue(zone.getNameServers().isEmpty());
      assertNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      // several combined
      zones =
          filter(
              DNS.listZones(
                      Dns.ZoneListOption.fields(ZoneField.ZONE_ID, ZoneField.DESCRIPTION),
                      Dns.ZoneListOption.pageSize(1))
                  .iterateAll()
                  .iterator());
      assertEquals(2, zones.size());
      for (Zone current : zones) {
        assertNull(current.getCreationTimeMillis());
        assertNotNull(current.getName());
        assertNull(current.getDnsName());
        assertNotNull(current.getDescription());
        assertNull(current.getNameServerSet());
        assertTrue(zone.getNameServers().isEmpty());
        assertNotNull(current.getGeneratedId());
      }
    } finally {
      DNS.delete(ZONE1.getName());
      DNS.delete(ZONE_EMPTY_DESCRIPTION.getName());
    }
  }

  @Test
  public void testDeleteZone() {
    assumeFalse(IS_VPC_TEST);
    try {
      Zone created = DNS.create(ZONE1);
      assertEquals(created, DNS.getZone(ZONE1.getName()));
      DNS.delete(ZONE1.getName());
      assertNull(DNS.getZone(ZONE1.getName()));
    } finally {
      DNS.delete(ZONE1.getName());
    }
  }

  @Test
  public void testCreateChange() {
    assumeFalse(IS_VPC_TEST);
    try {
      DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      ChangeRequest created = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_ADD_ZONE1);
      assertEquals(CHANGE_ADD_ZONE1.getAdditions(), created.getAdditions());
      assertNotNull(created.getStartTimeMillis());
      assertTrue(created.getDeletions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertTrue(
          ImmutableList.of(ChangeRequest.Status.PENDING, ChangeRequest.Status.DONE)
              .contains(created.status()));
      assertEqChangesIgnoreStatus(created, DNS.getChangeRequest(ZONE1.getName(), "1"));
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      // with options
      created =
          DNS.applyChangeRequest(
              ZONE1.getName(),
              CHANGE_ADD_ZONE1,
              Dns.ChangeRequestOption.fields(ChangeRequestField.ID));
      assertTrue(created.getAdditions().isEmpty());
      assertNull(created.getStartTimeMillis());
      assertTrue(created.getDeletions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      created =
          DNS.applyChangeRequest(
              ZONE1.getName(),
              CHANGE_ADD_ZONE1,
              Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
      assertTrue(created.getAdditions().isEmpty());
      assertNull(created.getStartTimeMillis());
      assertTrue(created.getDeletions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertNotNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      created =
          DNS.applyChangeRequest(
              ZONE1.getName(),
              CHANGE_ADD_ZONE1,
              Dns.ChangeRequestOption.fields(ChangeRequestField.START_TIME));
      assertTrue(created.getAdditions().isEmpty());
      assertNotNull(created.getStartTimeMillis());
      assertTrue(created.getDeletions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      created =
          DNS.applyChangeRequest(
              ZONE1.getName(),
              CHANGE_ADD_ZONE1,
              Dns.ChangeRequestOption.fields(ChangeRequestField.ADDITIONS));
      assertEquals(CHANGE_ADD_ZONE1.getAdditions(), created.getAdditions());
      assertNull(created.getStartTimeMillis());
      assertTrue(created.getDeletions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertNull(created.status());
      // finishes with delete otherwise we cannot delete the zone
      waitForChangeToComplete(created);
      created =
          DNS.applyChangeRequest(
              ZONE1.getName(),
              CHANGE_DELETE_ZONE1,
              Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      waitForChangeToComplete(created);
      assertEquals(CHANGE_DELETE_ZONE1.getDeletions(), created.getDeletions());
      assertNull(created.getStartTimeMillis());
      assertTrue(created.getAdditions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
    } finally {
      clear();
    }
  }

  @Test
  public void testInvalidChangeRequest() {
    assumeFalse(IS_VPC_TEST);
    Zone zone = DNS.create(ZONE1);
    RecordSet validA =
        RecordSet.newBuilder("subdomain." + zone.getDnsName(), RecordSet.Type.A)
            .setRecords(ImmutableList.of("0.255.1.5"))
            .build();
    boolean recordAdded = false;
    try {
      ChangeRequestInfo validChange = ChangeRequest.newBuilder().add(validA).build();
      zone.applyChangeRequest(validChange);
      recordAdded = true;
      try {
        zone.applyChangeRequest(validChange);
        fail("Created a record set which already exists.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.isRetryable());
        assertEquals(409, ex.getCode());
      }
      // delete with field mismatch
      RecordSet mismatch = validA.toBuilder().setTtl(20, TimeUnit.SECONDS).build();
      ChangeRequestInfo deletion = ChangeRequest.newBuilder().delete(mismatch).build();
      try {
        zone.applyChangeRequest(deletion);
        fail("Deleted a record set without a complete match.");
      } catch (DnsException ex) {
        // expected
        assertEquals(412, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      // delete and add SOA
      Iterator<RecordSet> recordSetIterator = zone.listRecordSets().iterateAll().iterator();
      LinkedList<RecordSet> deletions = new LinkedList<>();
      LinkedList<RecordSet> additions = new LinkedList<>();
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        if (recordSet.getType() == RecordSet.Type.SOA) {
          deletions.add(recordSet);
          // the subdomain is necessary to get 400 instead of 412
          RecordSet copy = recordSet.toBuilder().setName("x." + recordSet.getName()).build();
          additions.add(copy);
          break;
        }
      }
      deletion = deletion.toBuilder().setDeletions(deletions).build();
      ChangeRequestInfo addition = ChangeRequest.newBuilder().setAdditions(additions).build();
      try {
        zone.applyChangeRequest(deletion);
        fail("Deleted SOA.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.isRetryable());
        assertEquals(400, ex.getCode());
      }
      try {
        zone.applyChangeRequest(addition);
        fail("Added second SOA.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.isRetryable());
        assertEquals(400, ex.getCode());
      }
    } finally {
      if (recordAdded) {
        ChangeRequestInfo deletion = ChangeRequest.newBuilder().delete(validA).build();
        ChangeRequest request = zone.applyChangeRequest(deletion);
        waitForChangeToComplete(zone.getName(), request.getGeneratedId());
      }
      zone.delete();
    }
  }

  @Test
  public void testListChanges() {
    assumeFalse(IS_VPC_TEST);
    try {
      // no such zone exists
      try {
        DNS.listChangeRequests(ZONE1.getName());
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(404, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      // zone exists but has no changes
      DNS.create(ZONE1);
      ImmutableList<ChangeRequest> changes =
          ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.getName()).iterateAll());
      assertEquals(1, changes.size()); // default change creating SOA and NS
      // zone has changes
      ChangeRequest change = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.getName(), change.getGeneratedId());
      change = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.getName(), change.getGeneratedId());
      change = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.getName(), change.getGeneratedId());
      change = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.getName(), change.getGeneratedId());
      changes = ImmutableList.copyOf(DNS.listChangeRequests(ZONE1.getName()).iterateAll());
      assertEquals(5, changes.size());
      // error in options
      try {
        DNS.listChangeRequests(ZONE1.getName(), Dns.ChangeRequestListOption.pageSize(0));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      try {
        DNS.listChangeRequests(ZONE1.getName(), Dns.ChangeRequestListOption.pageSize(-1));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      // sorting order
      ImmutableList<ChangeRequest> ascending =
          ImmutableList.copyOf(
              DNS.listChangeRequests(
                      ZONE1.getName(),
                      Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING))
                  .iterateAll());
      ImmutableList<ChangeRequest> descending =
          ImmutableList.copyOf(
              DNS.listChangeRequests(
                      ZONE1.getName(),
                      Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.DESCENDING))
                  .iterateAll());
      int size = 5;
      assertEquals(size, descending.size());
      assertEquals(size, ascending.size());
      for (int i = 0; i < size; i++) {
        assertEquals(descending.get(i), ascending.get(size - i - 1));
      }
      // field options
      changes =
          ImmutableList.copyOf(
              DNS.listChangeRequests(
                      ZONE1.getName(),
                      Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
                      Dns.ChangeRequestListOption.fields(ChangeRequestField.ADDITIONS))
                  .iterateAll());
      change = changes.get(1);
      assertEquals(CHANGE_ADD_ZONE1.getAdditions(), change.getAdditions());
      assertTrue(change.getDeletions().isEmpty());
      assertNotNull(change.getGeneratedId());
      assertNull(change.getStartTimeMillis());
      assertNull(change.status());
      changes =
          ImmutableList.copyOf(
              DNS.listChangeRequests(
                      ZONE1.getName(),
                      Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
                      Dns.ChangeRequestListOption.fields(ChangeRequestField.DELETIONS))
                  .iterateAll());
      change = changes.get(2);
      assertTrue(change.getAdditions().isEmpty());
      assertNotNull(change.getDeletions());
      assertNotNull(change.getGeneratedId());
      assertNull(change.getStartTimeMillis());
      assertNull(change.status());
      changes =
          ImmutableList.copyOf(
              DNS.listChangeRequests(
                      ZONE1.getName(),
                      Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
                      Dns.ChangeRequestListOption.fields(ChangeRequestField.ID))
                  .iterateAll());
      change = changes.get(1);
      assertTrue(change.getAdditions().isEmpty());
      assertTrue(change.getDeletions().isEmpty());
      assertNotNull(change.getGeneratedId());
      assertNull(change.getStartTimeMillis());
      assertNull(change.status());
      changes =
          ImmutableList.copyOf(
              DNS.listChangeRequests(
                      ZONE1.getName(),
                      Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
                      Dns.ChangeRequestListOption.fields(ChangeRequestField.START_TIME))
                  .iterateAll());
      change = changes.get(1);
      assertTrue(change.getAdditions().isEmpty());
      assertTrue(change.getDeletions().isEmpty());
      assertNotNull(change.getGeneratedId());
      assertNotNull(change.getStartTimeMillis());
      assertNull(change.status());
      changes =
          ImmutableList.copyOf(
              DNS.listChangeRequests(
                      ZONE1.getName(),
                      Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
                      Dns.ChangeRequestListOption.fields(ChangeRequestField.STATUS))
                  .iterateAll());
      change = changes.get(1);
      assertTrue(change.getAdditions().isEmpty());
      assertTrue(change.getDeletions().isEmpty());
      assertNotNull(change.getGeneratedId());
      assertNull(change.getStartTimeMillis());
      assertEquals(ChangeRequest.Status.DONE, change.status());
    } finally {
      clear();
    }
  }

  @Test
  public void testGetChange() {
    assumeFalse(IS_VPC_TEST);
    try {
      Zone zone = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      ChangeRequest created = zone.applyChangeRequest(CHANGE_ADD_ZONE1);
      ChangeRequest retrieved = DNS.getChangeRequest(zone.getName(), created.getGeneratedId());
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.getName(), created.getGeneratedId());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      // with options
      created =
          zone.applyChangeRequest(
              CHANGE_ADD_ZONE1, Dns.ChangeRequestOption.fields(ChangeRequestField.ID));
      retrieved =
          DNS.getChangeRequest(
              zone.getName(),
              created.getGeneratedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.ID));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.getName(), created.getGeneratedId());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      created =
          zone.applyChangeRequest(
              CHANGE_ADD_ZONE1, Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
      retrieved =
          DNS.getChangeRequest(
              zone.getName(),
              created.getGeneratedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.getName(), created.getGeneratedId());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      created =
          zone.applyChangeRequest(
              CHANGE_ADD_ZONE1, Dns.ChangeRequestOption.fields(ChangeRequestField.START_TIME));
      retrieved =
          DNS.getChangeRequest(
              zone.getName(),
              created.getGeneratedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.START_TIME));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.getName(), created.getGeneratedId());
      zone.applyChangeRequest(CHANGE_DELETE_ZONE1);
      created =
          zone.applyChangeRequest(
              CHANGE_ADD_ZONE1, Dns.ChangeRequestOption.fields(ChangeRequestField.ADDITIONS));
      retrieved =
          DNS.getChangeRequest(
              zone.getName(),
              created.getGeneratedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.ADDITIONS));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.getName(), created.getGeneratedId());
      // finishes with delete otherwise we cannot delete the zone
      created =
          zone.applyChangeRequest(
              CHANGE_DELETE_ZONE1, Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      retrieved =
          DNS.getChangeRequest(
              zone.getName(),
              created.getGeneratedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      assertEqChangesIgnoreStatus(created, retrieved);
      waitForChangeToComplete(zone.getName(), created.getGeneratedId());
    } finally {
      clear();
    }
  }

  @Test
  public void testGetProject() {
    // fetches all fields
    ProjectInfo project = DNS.getProject();
    assertNotNull(project.getQuota());
    // options
    project = DNS.getProject(Dns.ProjectOption.fields(ProjectField.QUOTA));
    assertNotNull(project.getQuota());
    project = DNS.getProject(Dns.ProjectOption.fields(ProjectField.PROJECT_ID));
    assertNull(project.getQuota());
    project = DNS.getProject(Dns.ProjectOption.fields(ProjectField.PROJECT_NUMBER));
    assertNull(project.getQuota());
    project =
        DNS.getProject(
            Dns.ProjectOption.fields(
                ProjectField.PROJECT_NUMBER, ProjectField.QUOTA, ProjectField.PROJECT_ID));
    assertNotNull(project.getQuota());
  }

  @Test
  public void testListDnsRecords() {
    assumeFalse(IS_VPC_TEST);
    try {
      Zone zone = DNS.create(ZONE1);
      ImmutableList<RecordSet> recordSets =
          ImmutableList.copyOf(DNS.listRecordSets(zone.getName()).iterateAll());
      assertEquals(2, recordSets.size());
      ImmutableList<RecordSet.Type> defaultRecords =
          ImmutableList.of(RecordSet.Type.NS, RecordSet.Type.SOA);
      for (RecordSet recordSet : recordSets) {
        assertTrue(defaultRecords.contains(recordSet.getType()));
      }
      // field options
      Iterator<RecordSet> recordSetIterator =
          DNS.listRecordSets(zone.getName(), Dns.RecordSetListOption.fields(RecordSetField.TTL))
              .iterateAll()
              .iterator();
      int counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).getTtl(), recordSet.getTtl());
        assertEquals(recordSets.get(counter).getName(), recordSet.getName());
        assertEquals(recordSets.get(counter).getType(), recordSet.getType());
        assertTrue(recordSet.getRecords().isEmpty());
        counter++;
      }
      assertEquals(2, counter);
      recordSetIterator =
          DNS.listRecordSets(zone.getName(), Dns.RecordSetListOption.fields(RecordSetField.NAME))
              .iterateAll()
              .iterator();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).getName(), recordSet.getName());
        assertEquals(recordSets.get(counter).getType(), recordSet.getType());
        assertTrue(recordSet.getRecords().isEmpty());
        assertNull(recordSet.getTtl());
        counter++;
      }
      assertEquals(2, counter);
      recordSetIterator =
          DNS.listRecordSets(
                  zone.getName(), Dns.RecordSetListOption.fields(RecordSetField.DNS_RECORDS))
              .iterateAll()
              .iterator();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).getRecords(), recordSet.getRecords());
        assertEquals(recordSets.get(counter).getName(), recordSet.getName());
        assertEquals(recordSets.get(counter).getType(), recordSet.getType());
        assertNull(recordSet.getTtl());
        counter++;
      }
      assertEquals(2, counter);
      recordSetIterator =
          DNS.listRecordSets(
                  zone.getName(),
                  Dns.RecordSetListOption.fields(RecordSetField.TYPE),
                  Dns.RecordSetListOption.pageSize(1))
              .iterateAll()
              .iterator(); // also test paging
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).getType(), recordSet.getType());
        assertEquals(recordSets.get(counter).getName(), recordSet.getName());
        assertTrue(recordSet.getRecords().isEmpty());
        assertNull(recordSet.getTtl());
        counter++;
      }
      assertEquals(2, counter);
      // test page size
      Page<RecordSet> recordSetPage =
          DNS.listRecordSets(
              zone.getName(),
              Dns.RecordSetListOption.fields(RecordSetField.TYPE),
              Dns.RecordSetListOption.pageSize(1));
      assertEquals(1, ImmutableList.copyOf(recordSetPage.getValues().iterator()).size());
      // test name filter
      ChangeRequest change = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.getName(), change.getGeneratedId());
      recordSetIterator =
          DNS.listRecordSets(
                  ZONE1.getName(), Dns.RecordSetListOption.dnsName(A_RECORD_ZONE1.getName()))
              .iterateAll()
              .iterator();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertTrue(
            ImmutableList.of(A_RECORD_ZONE1.getType(), AAAA_RECORD_ZONE1.getType())
                .contains(recordSet.getType()));
        counter++;
      }
      assertEquals(2, counter);
      // test type filter
      waitForChangeToComplete(ZONE1.getName(), change.getGeneratedId());
      recordSetIterator =
          DNS.listRecordSets(
                  ZONE1.getName(),
                  Dns.RecordSetListOption.dnsName(A_RECORD_ZONE1.getName()),
                  Dns.RecordSetListOption.type(A_RECORD_ZONE1.getType()))
              .iterateAll()
              .iterator();
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
        DNS.listRecordSets(ZONE1.getName(), Dns.RecordSetListOption.type(A_RECORD_ZONE1.getType()));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      try {
        DNS.listRecordSets(ZONE1.getName(), Dns.RecordSetListOption.pageSize(0));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      try {
        DNS.listRecordSets(ZONE1.getName(), Dns.RecordSetListOption.pageSize(-1));
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      waitForChangeToComplete(ZONE1.getName(), change.getGeneratedId());
    } finally {
      clear();
    }
  }

  @Test
  @Ignore
  public void testListZonesBatch() {
    assumeFalse(IS_VPC_TEST);
    try {
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Page<Zone>> result = batch.listZones();
      batch.submit();
      List<Zone> zones = filter(result.get().iterateAll().iterator());
      assertEquals(0, zones.size());
      // some zones exists
      Zone firstZone = DNS.create(ZONE1);
      batch = DNS.batch();
      result = batch.listZones();
      batch.submit();
      zones = filter(result.get().iterateAll().iterator());
      assertEquals(1, zones.size());
      assertEquals(firstZone, zones.get(0));
      Zone created = DNS.create(ZONE_EMPTY_DESCRIPTION);
      batch = DNS.batch();
      result = batch.listZones();
      DnsBatchResult<Page<Zone>> zeroSizeError = batch.listZones(Dns.ZoneListOption.pageSize(0));
      DnsBatchResult<Page<Zone>> negativeSizeError =
          batch.listZones(Dns.ZoneListOption.pageSize(-1));
      DnsBatchResult<Page<Zone>> okSize = batch.listZones(Dns.ZoneListOption.pageSize(1));
      DnsBatchResult<Page<Zone>> nameError = batch.listZones(Dns.ZoneListOption.dnsName("aaaaa"));
      DnsBatchResult<Page<Zone>> okName =
          batch.listZones(Dns.ZoneListOption.dnsName(ZONE1.getDnsName()));
      DnsBatchResult<Page<Zone>> idResult =
          batch.listZones(
              Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
              Dns.ZoneListOption.fields(ZoneField.ZONE_ID));
      DnsBatchResult<Page<Zone>> timeResult =
          batch.listZones(
              Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
              Dns.ZoneListOption.fields(ZoneField.CREATION_TIME));
      DnsBatchResult<Page<Zone>> dnsNameResult =
          batch.listZones(
              Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
              Dns.ZoneListOption.fields(ZoneField.DNS_NAME));
      DnsBatchResult<Page<Zone>> descriptionResult =
          batch.listZones(
              Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
              Dns.ZoneListOption.fields(ZoneField.DESCRIPTION));
      DnsBatchResult<Page<Zone>> nameServersResult =
          batch.listZones(
              Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
              Dns.ZoneListOption.fields(ZoneField.NAME_SERVERS));
      DnsBatchResult<Page<Zone>> nameServerSetResult =
          batch.listZones(
              Dns.ZoneListOption.dnsName(ZONE1.getDnsName()),
              Dns.ZoneListOption.fields(ZoneField.NAME_SERVER_SET));
      DnsBatchResult<Page<Zone>> combinationResult =
          batch.listZones(
              Dns.ZoneListOption.fields(ZoneField.ZONE_ID, ZoneField.DESCRIPTION),
              Dns.ZoneListOption.pageSize(1));
      batch.submit();
      zones = filter(result.get().iterateAll().iterator());
      assertEquals(2, zones.size());
      assertTrue(zones.contains(firstZone));
      assertTrue(zones.contains(created));
      // error in options
      try {
        zeroSizeError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      try {
        negativeSizeError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      // ok size
      assertEquals(1, Iterables.size(okSize.get().getValues()));
      // dns name problems
      try {
        nameError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      // ok name
      zones = filter(okName.get().iterateAll().iterator());
      assertEquals(1, zones.size());
      // field options
      Iterator<Zone> zoneIterator = idResult.get().iterateAll().iterator();
      Zone zone = zoneIterator.next();
      assertNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNull(zone.getDnsName());
      assertNull(zone.getDescription());
      assertNull(zone.getNameServerSet());
      assertTrue(zone.getNameServers().isEmpty());
      assertNotNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = timeResult.get().iterateAll().iterator();
      zone = zoneIterator.next();
      assertNotNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNull(zone.getDnsName());
      assertNull(zone.getDescription());
      assertNull(zone.getNameServerSet());
      assertTrue(zone.getNameServers().isEmpty());
      assertNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = dnsNameResult.get().iterateAll().iterator();
      zone = zoneIterator.next();
      assertNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNotNull(zone.getDnsName());
      assertNull(zone.getDescription());
      assertNull(zone.getNameServerSet());
      assertTrue(zone.getNameServers().isEmpty());
      assertNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = descriptionResult.get().iterateAll().iterator();
      zone = zoneIterator.next();
      assertNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNull(zone.getDnsName());
      assertNotNull(zone.getDescription());
      assertNull(zone.getNameServerSet());
      assertTrue(zone.getNameServers().isEmpty());
      assertNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = nameServersResult.get().iterateAll().iterator();
      zone = zoneIterator.next();
      assertNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNull(zone.getDnsName());
      assertNull(zone.getDescription());
      assertNull(zone.getNameServerSet());
      assertFalse(zone.getNameServers().isEmpty());
      assertNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      zoneIterator = nameServerSetResult.get().iterateAll().iterator();
      zone = zoneIterator.next();
      assertNull(zone.getCreationTimeMillis());
      assertNotNull(zone.getName());
      assertNull(zone.getDnsName());
      assertNull(zone.getDescription());
      assertNull(zone.getNameServerSet()); // we cannot set it using google-cloud
      assertTrue(zone.getNameServers().isEmpty());
      assertNull(zone.getGeneratedId());
      assertFalse(zoneIterator.hasNext());
      // several combined
      zones = filter(combinationResult.get().iterateAll().iterator());
      assertEquals(2, zones.size());
      for (Zone current : zones) {
        assertNull(current.getCreationTimeMillis());
        assertNotNull(current.getName());
        assertNull(current.getDnsName());
        assertNotNull(current.getDescription());
        assertNull(current.getNameServerSet());
        assertTrue(zone.getNameServers().isEmpty());
        assertNotNull(current.getGeneratedId());
      }
    } finally {
      DNS.delete(ZONE1.getName());
      DNS.delete(ZONE_EMPTY_DESCRIPTION.getName());
    }
  }

  @Test
  @Ignore
  public void testCreateValidZoneBatch() {
    assumeFalse(IS_VPC_TEST);
    try {
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Zone> completeZoneResult = batch.createZone(ZONE1);
      DnsBatchResult<Zone> partialZoneResult = batch.createZone(ZONE_EMPTY_DESCRIPTION);
      batch.submit();
      Zone created = completeZoneResult.get();
      assertEquals(ZONE1.getDescription(), created.getDescription());
      assertEquals(ZONE1.getDnsName(), created.getDnsName());
      assertEquals(ZONE1.getName(), created.getName());
      assertNotNull(created.getCreationTimeMillis());
      assertNotNull(created.getNameServers());
      assertNull(created.getNameServerSet());
      assertNotNull(created.getGeneratedId());
      Zone retrieved = DNS.getZone(ZONE1.getName());
      assertEquals(created, retrieved);
      created = partialZoneResult.get();
      assertEquals(ZONE_EMPTY_DESCRIPTION.getDescription(), created.getDescription());
      assertEquals(ZONE_EMPTY_DESCRIPTION.getDnsName(), created.getDnsName());
      assertEquals(ZONE_EMPTY_DESCRIPTION.getName(), created.getName());
      assertNotNull(created.getCreationTimeMillis());
      assertNotNull(created.getNameServers());
      assertNull(created.getNameServerSet());
      assertNotNull(created.getGeneratedId());
      retrieved = DNS.getZone(ZONE_EMPTY_DESCRIPTION.getName());
      assertEquals(created, retrieved);
    } finally {
      DNS.delete(ZONE1.getName());
      DNS.delete(ZONE_EMPTY_DESCRIPTION.getName());
    }
  }

  @Test
  @Ignore
  public void testCreateZoneWithErrorsBatch() {
    try {
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Zone> nameErrorResult = batch.createZone(ZONE_NAME_ERROR);
      DnsBatchResult<Zone> noPeriodResult = batch.createZone(ZONE_DNS_NO_PERIOD);
      batch.submit();
      try {
        nameErrorResult.get();
        fail("Zone name is too long. The service returns an error.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.isRetryable());
      }
      try {
        noPeriodResult.get();
        fail("Zone name is missing a period. The service returns an error.");
      } catch (DnsException ex) {
        // expected
        assertFalse(ex.isRetryable());
      }
    } finally {
      DNS.delete(ZONE_NAME_ERROR.getName());
      DNS.delete(ZONE_DNS_NO_PERIOD.getName());
    }
  }

  @Test
  @Ignore
  public void testCreateZoneWithOptionsBatch() {
    assumeFalse(IS_VPC_TEST);
    try {
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Zone> batchResult =
          batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.CREATION_TIME));
      batch.submit();
      Zone created = batchResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNotNull(created.getCreationTimeMillis());
      assertNull(created.getDescription());
      assertNull(created.getDnsName());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.DESCRIPTION));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertEquals(ZONE1.getDescription(), created.getDescription());
      assertNull(created.getDnsName());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.DNS_NAME));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertEquals(ZONE1.getDnsName(), created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME_SERVER_SET));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet()); // we did not set it
      assertNull(created.getGeneratedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME_SERVERS));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertFalse(created.getNameServers().isEmpty());
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created.delete();
      batch = DNS.batch();
      batchResult = batch.createZone(ZONE1, Dns.ZoneOption.fields(ZoneField.ZONE_ID));
      batch.submit();
      created = batchResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertNotNull(created.getNameServers());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNotNull(created.getGeneratedId());
      created.delete();
      batch = DNS.batch();
      batchResult =
          batch.createZone(
              ZONE1,
              Dns.ZoneOption.fields(
                  ZoneField.ZONE_ID,
                  ZoneField.NAME_SERVERS,
                  ZoneField.NAME_SERVER_SET,
                  ZoneField.DESCRIPTION));
      batch.submit();
      // combination of multiple things
      created = batchResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertEquals(ZONE1.getDescription(), created.getDescription());
      assertFalse(created.getNameServers().isEmpty());
      assertNull(created.getNameServerSet()); // we did not set it
      assertNotNull(created.getGeneratedId());
    } finally {
      DNS.delete(ZONE1.getName());
    }
  }

  @Test
  @Ignore
  public void testGetZoneBatch() {
    assumeFalse(IS_VPC_TEST);
    try {
      DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Zone> timeResult =
          batch.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.CREATION_TIME));
      DnsBatchResult<Zone> descriptionResult =
          batch.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.DESCRIPTION));
      DnsBatchResult<Zone> dnsNameResult =
          batch.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.DNS_NAME));
      DnsBatchResult<Zone> nameResult =
          batch.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.NAME));
      DnsBatchResult<Zone> nameServerSetResult =
          batch.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.NAME_SERVER_SET));
      DnsBatchResult<Zone> nameServersResult =
          batch.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.NAME_SERVERS));
      DnsBatchResult<Zone> idResult =
          batch.getZone(ZONE1.getName(), Dns.ZoneOption.fields(ZoneField.ZONE_ID));
      DnsBatchResult<Zone> combinationResult =
          batch.getZone(
              ZONE1.getName(),
              Dns.ZoneOption.fields(
                  ZoneField.ZONE_ID,
                  ZoneField.NAME_SERVERS,
                  ZoneField.NAME_SERVER_SET,
                  ZoneField.DESCRIPTION));
      batch.submit();
      Zone created = timeResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNotNull(created.getCreationTimeMillis());
      assertNull(created.getDescription());
      assertNull(created.getDnsName());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created = descriptionResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertEquals(ZONE1.getDescription(), created.getDescription());
      assertNull(created.getDnsName());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created = dnsNameResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertEquals(ZONE1.getDnsName(), created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created = nameResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created = nameServerSetResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNull(created.getNameServerSet()); // we did not set it
      assertNull(created.getGeneratedId());
      created = nameServersResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertFalse(created.getNameServers().isEmpty());
      assertNull(created.getNameServerSet());
      assertNull(created.getGeneratedId());
      created = idResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertNull(created.getDescription());
      assertNotNull(created.getNameServers());
      assertTrue(created.getNameServers().isEmpty()); // never returns null
      assertNotNull(created.getGeneratedId());
      // combination of multiple things
      created = combinationResult.get();
      assertEquals(ZONE1.getName(), created.getName()); // always returned
      assertNull(created.getCreationTimeMillis());
      assertNull(created.getDnsName());
      assertEquals(ZONE1.getDescription(), created.getDescription());
      assertFalse(created.getNameServers().isEmpty());
      assertNull(created.getNameServerSet()); // we did not set it
      assertNotNull(created.getGeneratedId());
    } finally {
      DNS.delete(ZONE1.getName());
    }
  }

  @Test
  @Ignore
  public void testDeleteZoneBatch() {
    assumeFalse(IS_VPC_TEST);
    try {
      Zone created = DNS.create(ZONE1);
      assertEquals(created, DNS.getZone(ZONE1.getName()));
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Boolean> result = batch.deleteZone(ZONE1.getName());
      batch.submit();
      assertNull(DNS.getZone(ZONE1.getName()));
      assertTrue(result.get());
    } finally {
      DNS.delete(ZONE1.getName());
    }
  }

  @Test
  @Ignore
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
        batch.getProject(
            Dns.ProjectOption.fields(
                ProjectField.PROJECT_NUMBER, ProjectField.QUOTA, ProjectField.PROJECT_ID));
    batch.submit();
    assertNotNull(result.get().getQuota());
    assertNotNull(resultQuota.get().getQuota());
    assertNull(resultId.get().getQuota());
    assertNull(resultNumber.get().getQuota());
    assertNotNull(resultCombination.get().getQuota());
  }

  @Test
  @Ignore
  public void testCreateChangeBatch() {
    assumeFalse(IS_VPC_TEST);
    try {
      DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      DnsBatch batch = DNS.batch();
      DnsBatchResult<ChangeRequest> result =
          batch.applyChangeRequest(ZONE1.getName(), CHANGE_ADD_ZONE1);
      batch.submit();
      ChangeRequest created = result.get();
      assertEquals(CHANGE_ADD_ZONE1.getAdditions(), created.getAdditions());
      assertNotNull(created.getStartTimeMillis());
      assertTrue(created.getDeletions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertTrue(
          ImmutableList.of(ChangeRequest.Status.PENDING, ChangeRequest.Status.DONE)
              .contains(created.status()));
      assertEqChangesIgnoreStatus(created, DNS.getChangeRequest(ZONE1.getName(), "1"));
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      // with options
      batch = DNS.batch();
      result =
          batch.applyChangeRequest(
              ZONE1.getName(),
              CHANGE_ADD_ZONE1,
              Dns.ChangeRequestOption.fields(ChangeRequestField.ID));
      batch.submit();
      created = result.get();
      assertTrue(created.getAdditions().isEmpty());
      assertNull(created.getStartTimeMillis());
      assertTrue(created.getDeletions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      batch = DNS.batch();
      result =
          batch.applyChangeRequest(
              ZONE1.getName(),
              CHANGE_ADD_ZONE1,
              Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
      batch.submit();
      created = result.get();
      assertTrue(created.getAdditions().isEmpty());
      assertNull(created.getStartTimeMillis());
      assertTrue(created.getDeletions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertNotNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      batch = DNS.batch();
      result =
          batch.applyChangeRequest(
              ZONE1.getName(),
              CHANGE_ADD_ZONE1,
              Dns.ChangeRequestOption.fields(ChangeRequestField.START_TIME));
      batch.submit();
      created = result.get();
      assertTrue(created.getAdditions().isEmpty());
      assertNotNull(created.getStartTimeMillis());
      assertTrue(created.getDeletions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
      created = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(created);
      batch = DNS.batch();
      result =
          batch.applyChangeRequest(
              ZONE1.getName(),
              CHANGE_ADD_ZONE1,
              Dns.ChangeRequestOption.fields(ChangeRequestField.ADDITIONS));
      batch.submit();
      created = result.get();
      assertEquals(CHANGE_ADD_ZONE1.getAdditions(), created.getAdditions());
      assertNull(created.getStartTimeMillis());
      assertTrue(created.getDeletions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertNull(created.status());
      // finishes with delete otherwise we cannot delete the zone
      waitForChangeToComplete(created);
      batch = DNS.batch();
      result =
          batch.applyChangeRequest(
              ZONE1.getName(),
              CHANGE_DELETE_ZONE1,
              Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      batch.submit();
      created = result.get();
      waitForChangeToComplete(created);
      assertEquals(CHANGE_DELETE_ZONE1.getDeletions(), created.getDeletions());
      assertNull(created.getStartTimeMillis());
      assertTrue(created.getAdditions().isEmpty());
      assertNotNull(created.getGeneratedId());
      assertNull(created.status());
      waitForChangeToComplete(created);
    } finally {
      clear();
    }
  }

  @Test
  @Ignore
  public void testGetChangeBatch() {
    assumeFalse(IS_VPC_TEST);
    try {
      Zone zone = DNS.create(ZONE1, Dns.ZoneOption.fields(ZoneField.NAME));
      ChangeRequest created = zone.applyChangeRequest(CHANGE_ADD_ZONE1);
      waitForChangeToComplete(zone.getName(), created.getGeneratedId());
      DnsBatch batch = DNS.batch();
      DnsBatchResult<ChangeRequest> completeResult =
          batch.getChangeRequest(zone.getName(), created.getGeneratedId());
      DnsBatchResult<ChangeRequest> idResult =
          batch.getChangeRequest(
              zone.getName(),
              created.getGeneratedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.ID));
      DnsBatchResult<ChangeRequest> statusResult =
          batch.getChangeRequest(
              zone.getName(),
              created.getGeneratedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.STATUS));
      DnsBatchResult<ChangeRequest> timeResult =
          batch.getChangeRequest(
              zone.getName(),
              created.getGeneratedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.START_TIME));
      DnsBatchResult<ChangeRequest> additionsResult =
          batch.getChangeRequest(
              zone.getName(),
              created.getGeneratedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.ADDITIONS));
      batch.submit();
      assertEqChangesIgnoreStatus(created, completeResult.get());
      // with options
      ChangeRequest retrieved = idResult.get();
      assertEquals(created.getGeneratedId(), retrieved.getGeneratedId());
      assertEquals(0, retrieved.getAdditions().size());
      assertEquals(0, retrieved.getDeletions().size());
      assertNull(retrieved.getStartTimeMillis());
      assertNull(retrieved.status());
      retrieved = statusResult.get();
      assertEquals(created.getGeneratedId(), retrieved.getGeneratedId());
      assertEquals(0, retrieved.getAdditions().size());
      assertEquals(0, retrieved.getDeletions().size());
      assertNull(retrieved.getStartTimeMillis());
      assertEquals(ChangeRequestInfo.Status.DONE, retrieved.status());
      retrieved = timeResult.get();
      assertEquals(created.getGeneratedId(), retrieved.getGeneratedId());
      assertEquals(0, retrieved.getAdditions().size());
      assertEquals(0, retrieved.getDeletions().size());
      assertEquals(created.getStartTimeMillis(), retrieved.getStartTimeMillis());
      assertNull(retrieved.status());
      retrieved = additionsResult.get();
      assertEquals(created.getGeneratedId(), retrieved.getGeneratedId());
      assertEquals(2, retrieved.getAdditions().size());
      assertTrue(retrieved.getAdditions().contains(A_RECORD_ZONE1));
      assertTrue(retrieved.getAdditions().contains(AAAA_RECORD_ZONE1));
      assertEquals(0, retrieved.getDeletions().size());
      assertNull(retrieved.getStartTimeMillis());
      assertNull(retrieved.status());
      // finishes with delete otherwise we cannot delete the zone
      created =
          zone.applyChangeRequest(
              CHANGE_DELETE_ZONE1, Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      batch = DNS.batch();
      DnsBatchResult<ChangeRequest> deletionsResult =
          batch.getChangeRequest(
              zone.getName(),
              created.getGeneratedId(),
              Dns.ChangeRequestOption.fields(ChangeRequestField.DELETIONS));
      batch.submit();
      retrieved = deletionsResult.get();
      assertEquals(created.getGeneratedId(), retrieved.getGeneratedId());
      assertEquals(0, retrieved.getAdditions().size());
      assertEquals(2, retrieved.getDeletions().size());
      assertTrue(retrieved.getDeletions().contains(AAAA_RECORD_ZONE1));
      assertTrue(retrieved.getDeletions().contains(A_RECORD_ZONE1));
      assertNull(retrieved.getStartTimeMillis());
      assertNull(retrieved.status());
      waitForChangeToComplete(zone.getName(), created.getGeneratedId());
    } finally {
      clear();
    }
  }

  @Test
  @Ignore
  public void testListChangesBatch() {
    assumeFalse(IS_VPC_TEST);
    try {
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Page<ChangeRequest>> result = batch.listChangeRequests(ZONE1.getName());
      batch.submit();
      try {
        result.get();
        fail("Zone does not exist yet");
      } catch (DnsException ex) {
        // expected
        assertEquals(404, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      // zone exists but has no changes
      DNS.create(ZONE1);
      batch = DNS.batch();
      result = batch.listChangeRequests(ZONE1.getName());
      batch.submit();
      // default change creating SOA and NS
      assertEquals(1, Iterables.size(result.get().getValues()));
      // zone has changes
      ChangeRequest change = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.getName(), change.getGeneratedId());
      change = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_DELETE_ZONE1);
      waitForChangeToComplete(ZONE1.getName(), change.getGeneratedId());
      batch = DNS.batch();
      result = batch.listChangeRequests(ZONE1.getName());
      DnsBatchResult<Page<ChangeRequest>> errorPageSize =
          batch.listChangeRequests(ZONE1.getName(), Dns.ChangeRequestListOption.pageSize(0));
      DnsBatchResult<Page<ChangeRequest>> errorPageNegative =
          batch.listChangeRequests(ZONE1.getName(), Dns.ChangeRequestListOption.pageSize(-1));
      DnsBatchResult<Page<ChangeRequest>> resultAscending =
          batch.listChangeRequests(
              ZONE1.getName(), Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING));
      DnsBatchResult<Page<ChangeRequest>> resultDescending =
          batch.listChangeRequests(
              ZONE1.getName(), Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.DESCENDING));
      DnsBatchResult<Page<ChangeRequest>> resultAdditions =
          batch.listChangeRequests(
              ZONE1.getName(),
              Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
              Dns.ChangeRequestListOption.fields(ChangeRequestField.ADDITIONS));
      DnsBatchResult<Page<ChangeRequest>> resultDeletions =
          batch.listChangeRequests(
              ZONE1.getName(),
              Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
              Dns.ChangeRequestListOption.fields(ChangeRequestField.DELETIONS));
      DnsBatchResult<Page<ChangeRequest>> resultId =
          batch.listChangeRequests(
              ZONE1.getName(),
              Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
              Dns.ChangeRequestListOption.fields(ChangeRequestField.ID));
      DnsBatchResult<Page<ChangeRequest>> resultTime =
          batch.listChangeRequests(
              ZONE1.getName(),
              Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
              Dns.ChangeRequestListOption.fields(ChangeRequestField.START_TIME));
      DnsBatchResult<Page<ChangeRequest>> resultStatus =
          batch.listChangeRequests(
              ZONE1.getName(),
              Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING),
              Dns.ChangeRequestListOption.fields(ChangeRequestField.STATUS));
      batch.submit();
      assertEquals(3, Iterables.size(result.get().getValues()));
      // error in options
      try {
        errorPageSize.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      try {
        errorPageNegative.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
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
      change = Iterables.get(resultAdditions.get().getValues(), 1);
      assertEquals(CHANGE_ADD_ZONE1.getAdditions(), change.getAdditions());
      assertTrue(change.getDeletions().isEmpty());
      assertNotNull(change.getGeneratedId());
      assertNull(change.getStartTimeMillis());
      assertNull(change.status());
      change = Iterables.get(resultDeletions.get().getValues(), 2);
      assertTrue(change.getAdditions().isEmpty());
      assertNotNull(change.getDeletions());
      assertNotNull(change.getGeneratedId());
      assertNull(change.getStartTimeMillis());
      assertNull(change.status());
      change = Iterables.get(resultId.get().getValues(), 1);
      assertTrue(change.getAdditions().isEmpty());
      assertTrue(change.getDeletions().isEmpty());
      assertNotNull(change.getGeneratedId());
      assertNull(change.getStartTimeMillis());
      assertNull(change.status());
      change = Iterables.get(resultTime.get().getValues(), 1);
      assertTrue(change.getAdditions().isEmpty());
      assertTrue(change.getDeletions().isEmpty());
      assertNotNull(change.getGeneratedId());
      assertNotNull(change.getStartTimeMillis());
      assertNull(change.status());
      change = Iterables.get(resultStatus.get().getValues(), 1);
      assertTrue(change.getAdditions().isEmpty());
      assertTrue(change.getDeletions().isEmpty());
      assertNotNull(change.getGeneratedId());
      assertNull(change.getStartTimeMillis());
      assertEquals(ChangeRequest.Status.DONE, change.status());
    } finally {
      clear();
    }
  }

  @Test
  @Ignore
  public void testListDnsRecordSetsBatch() {
    assumeFalse(IS_VPC_TEST);
    try {
      Zone zone = DNS.create(ZONE1);
      DnsBatch batch = DNS.batch();
      DnsBatchResult<Page<RecordSet>> result = batch.listRecordSets(zone.getName());
      batch.submit();
      ImmutableList<RecordSet> recordSets = ImmutableList.copyOf(result.get().iterateAll());
      assertEquals(2, recordSets.size());
      ImmutableList<RecordSet.Type> defaultRecords =
          ImmutableList.of(RecordSet.Type.NS, RecordSet.Type.SOA);
      for (RecordSet recordSet : recordSets) {
        assertTrue(defaultRecords.contains(recordSet.getType()));
      }
      // field options
      batch = DNS.batch();
      DnsBatchResult<Page<RecordSet>> ttlResult =
          batch.listRecordSets(zone.getName(), Dns.RecordSetListOption.fields(RecordSetField.TTL));
      DnsBatchResult<Page<RecordSet>> nameResult =
          batch.listRecordSets(zone.getName(), Dns.RecordSetListOption.fields(RecordSetField.NAME));
      DnsBatchResult<Page<RecordSet>> recordsResult =
          batch.listRecordSets(
              zone.getName(), Dns.RecordSetListOption.fields(RecordSetField.DNS_RECORDS));
      DnsBatchResult<Page<RecordSet>> pageSizeResult =
          batch.listRecordSets(
              zone.getName(),
              Dns.RecordSetListOption.fields(RecordSetField.TYPE),
              Dns.RecordSetListOption.pageSize(1));
      batch.submit();
      Iterator<RecordSet> recordSetIterator = ttlResult.get().iterateAll().iterator();
      int counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).getTtl(), recordSet.getTtl());
        assertEquals(recordSets.get(counter).getName(), recordSet.getName());
        assertEquals(recordSets.get(counter).getType(), recordSet.getType());
        assertTrue(recordSet.getRecords().isEmpty());
        counter++;
      }
      assertEquals(2, counter);
      recordSetIterator = nameResult.get().iterateAll().iterator();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).getName(), recordSet.getName());
        assertEquals(recordSets.get(counter).getType(), recordSet.getType());
        assertTrue(recordSet.getRecords().isEmpty());
        assertNull(recordSet.getTtl());
        counter++;
      }
      assertEquals(2, counter);
      recordSetIterator = recordsResult.get().iterateAll().iterator();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).getRecords(), recordSet.getRecords());
        assertEquals(recordSets.get(counter).getName(), recordSet.getName());
        assertEquals(recordSets.get(counter).getType(), recordSet.getType());
        assertNull(recordSet.getTtl());
        counter++;
      }
      assertEquals(2, counter);
      recordSetIterator = pageSizeResult.get().iterateAll().iterator(); // also test paging
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(recordSets.get(counter).getType(), recordSet.getType());
        assertEquals(recordSets.get(counter).getName(), recordSet.getName());
        assertTrue(recordSet.getRecords().isEmpty());
        assertNull(recordSet.getTtl());
        counter++;
      }
      assertEquals(2, counter);
      // test page size
      Page<RecordSet> recordSetPage = pageSizeResult.get();
      assertEquals(1, ImmutableList.copyOf(recordSetPage.getValues().iterator()).size());
      // test name filter
      ChangeRequest change = DNS.applyChangeRequest(ZONE1.getName(), CHANGE_ADD_ZONE1);
      waitForChangeToComplete(ZONE1.getName(), change.getGeneratedId());
      batch = DNS.batch();
      result =
          batch.listRecordSets(
              ZONE1.getName(), Dns.RecordSetListOption.dnsName(A_RECORD_ZONE1.getName()));
      batch.submit();
      recordSetIterator = result.get().iterateAll().iterator();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertTrue(
            ImmutableList.of(A_RECORD_ZONE1.getType(), AAAA_RECORD_ZONE1.getType())
                .contains(recordSet.getType()));
        counter++;
      }
      assertEquals(2, counter);
      // test type filter
      batch = DNS.batch();
      result =
          batch.listRecordSets(
              ZONE1.getName(),
              Dns.RecordSetListOption.dnsName(A_RECORD_ZONE1.getName()),
              Dns.RecordSetListOption.type(A_RECORD_ZONE1.getType()));
      batch.submit();
      recordSetIterator = result.get().iterateAll().iterator();
      counter = 0;
      while (recordSetIterator.hasNext()) {
        RecordSet recordSet = recordSetIterator.next();
        assertEquals(A_RECORD_ZONE1, recordSet);
        counter++;
      }
      assertEquals(1, counter);
      batch = DNS.batch();
      DnsBatchResult<Page<RecordSet>> noNameError =
          batch.listRecordSets(
              ZONE1.getName(), Dns.RecordSetListOption.type(A_RECORD_ZONE1.getType()));
      DnsBatchResult<Page<RecordSet>> zeroSizeError =
          batch.listRecordSets(ZONE1.getName(), Dns.RecordSetListOption.pageSize(0));
      DnsBatchResult<Page<RecordSet>> negativeSizeError =
          batch.listRecordSets(ZONE1.getName(), Dns.RecordSetListOption.pageSize(-1));
      batch.submit();
      // check wrong arguments
      try {
        // name is not set
        noNameError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      try {
        zeroSizeError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      try {
        negativeSizeError.get();
        fail();
      } catch (DnsException ex) {
        // expected
        assertEquals(400, ex.getCode());
        assertFalse(ex.isRetryable());
      }
      waitForChangeToComplete(ZONE1.getName(), change.getGeneratedId());
    } finally {
      clear();
    }
  }

  @Test
  @Ignore
  public void testBatchCombined() {
    assumeFalse(IS_VPC_TEST);
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
      assertNotNull(zoneResult.get().getCreationTimeMillis());
      assertEquals(ZONE1.getDnsName(), zoneResult.get().getDnsName());
      assertEquals(ZONE1.getDescription(), zoneResult.get().getDescription());
      assertFalse(zoneResult.get().getNameServers().isEmpty());
      assertNull(zoneResult.get().getNameServerSet()); // we did not set it
      assertNotNull(zoneResult.get().getGeneratedId());
      assertNotNull(projectResult.get().getQuota());
      assertEquals(2, Iterables.size(pageResult.get().getValues()));
      assertNotNull(changeRequestResult.get());
    } finally {
      DNS.delete(ZONE1.getName());
    }
  }

  @Test
  public void testCAARecord() {
    assumeFalse(IS_VPC_TEST);
    try {
      Zone zone = DNS.create(ZONE1);
      String caa = "0 issue \"ca.example.net\"";
      RecordSet toCreate =
          RecordSet.newBuilder("www." + zone.getDnsName(), RecordSet.Type.CAA)
              .setTtl(5, TimeUnit.MINUTES)
              .addRecord(caa)
              .build();
      ChangeRequestInfo changeRequest = ChangeRequestInfo.newBuilder().add(toCreate).build();
      ChangeRequest addRequest = zone.applyChangeRequest(changeRequest);
      assertEquals(1, addRequest.getAdditions().size());
      assertEquals(0, addRequest.getDeletions().size());
      assertNotNull(addRequest.getGeneratedId());
      ChangeRequestInfo.Builder deleteRequest = ChangeRequestInfo.newBuilder();
      for (RecordSet recordSet : zone.listRecordSets().iterateAll()) {
        if (toCreate.getName().equals(recordSet.getName())) {
          deleteRequest.delete(recordSet);
        }
      }
      ChangeRequest deleteRequest1 = zone.applyChangeRequest(deleteRequest.build());
      assertEquals(0, deleteRequest1.getAdditions().size());
      assertEquals(1, deleteRequest1.getDeletions().size());
      assertNotNull(deleteRequest1.getGeneratedId());
    } finally {
      DNS.delete(ZONE1.getName());
    }
  }
}
