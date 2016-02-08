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

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.Page;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class ZoneTest {

  private static final String ZONE_NAME = "dns-zone-name";
  private static final String ZONE_ID = "123";
  private static final ZoneInfo ZONE_INFO = Zone.builder(ZONE_NAME)
      .id(ZONE_ID)
      .dnsName("example.com")
      .creationTimeMillis(123478946464L)
      .build();
  private static final ZoneInfo NO_ID_INFO = ZoneInfo.builder(ZONE_NAME)
      .dnsName("another-example.com")
      .creationTimeMillis(893123464L)
      .build();
  private static final Dns.ZoneOption ZONE_FIELD_OPTIONS =
      Dns.ZoneOption.fields(Dns.ZoneField.CREATION_TIME);
  private static final Dns.DnsRecordListOption DNS_RECORD_OPTIONS =
      Dns.DnsRecordListOption.dnsName("some-dns");
  private static final Dns.ChangeRequestOption CHANGE_REQUEST_FIELD_OPTIONS =
      Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME);
  private static final Dns.ChangeRequestListOption CHANGE_REQUEST_LIST_OPTIONS =
      Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.START_TIME);
  private static final ChangeRequest CHANGE_REQUEST = ChangeRequest.builder().id("someid").build();
  private static final ChangeRequest CHANGE_REQUEST_AFTER = CHANGE_REQUEST.toBuilder()
      .startTimeMillis(123465L).build();
  private static final ChangeRequest CHANGE_REQUEST_NO_ID = ChangeRequest.builder().build();
  private static final DnsException EXCEPTION = createStrictMock(DnsException.class);
  private static final DnsOptions OPTIONS = createStrictMock(DnsOptions.class);

  private Dns dns;
  private Zone zone;
  private Zone zoneNoId;


  @Before
  public void setUp() throws Exception {
    dns = createStrictMock(Dns.class);
    expect(dns.options()).andReturn(OPTIONS);
    expect(dns.options()).andReturn(OPTIONS);
    replay(dns);
    zone = new Zone(dns, ZONE_INFO);
    zoneNoId = new Zone(dns, NO_ID_INFO);
    reset(dns);
  }

  @After
  public void tearDown() throws Exception {
    verify(dns);
  }

  @Test
  public void testConstructor() {
    replay(dns);
    assertEquals(ZONE_INFO.toPb(), zone.toPb());
    assertNotNull(zone.dns());
    assertEquals(dns, zone.dns());
  }

  @Test
  public void testGetByName() {
    expect(dns.getZone(ZONE_NAME)).andReturn(zone);
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(zone); // for options
    replay(dns);
    Zone retrieved = Zone.get(dns, ZONE_NAME);
    assertSame(dns, retrieved.dns());
    assertEquals(zone, retrieved);
    // test passing options
    Zone.get(dns, ZONE_NAME, ZONE_FIELD_OPTIONS);
    try {
      Zone.get(dns, null);
      fail("Cannot get by null name.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      Zone.get(null, "Not null");
      fail("Cannot get anything from null service.");
    } catch (NullPointerException e) {
      // expected
    }
  }

  @Test
  public void deleteByNameAndFound() {
    expect(dns.delete(ZONE_NAME)).andReturn(true);
    expect(dns.delete(ZONE_NAME)).andReturn(true);
    replay(dns);
    boolean result = zone.delete();
    assertTrue(result);
    result = zoneNoId.delete();
    assertTrue(result);
  }

  @Test
  public void deleteByNameAndNotFound() {
    expect(dns.delete(ZONE_NAME)).andReturn(false);
    expect(dns.delete(ZONE_NAME)).andReturn(false);
    replay(dns);
    boolean result = zoneNoId.delete();
    assertFalse(result);
    result = zone.delete();
    assertFalse(result);
  }

  @Test
  public void listDnsRecordsByNameAndFound() {
    @SuppressWarnings("unchecked")
    Page<DnsRecord> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dns.listDnsRecords(ZONE_NAME)).andReturn(pageMock);
    expect(dns.listDnsRecords(ZONE_NAME)).andReturn(pageMock);
    // again for options
    expect(dns.listDnsRecords(ZONE_NAME, DNS_RECORD_OPTIONS)).andReturn(pageMock);
    expect(dns.listDnsRecords(ZONE_NAME, DNS_RECORD_OPTIONS)).andReturn(pageMock);
    replay(dns);
    Page<DnsRecord> result = zone.listDnsRecords();
    assertSame(pageMock, result);
    result = zoneNoId.listDnsRecords();
    assertSame(pageMock, result);
    verify(pageMock);
    zone.listDnsRecords(DNS_RECORD_OPTIONS); // check options
    zoneNoId.listDnsRecords(DNS_RECORD_OPTIONS); // check options
  }

  @Test
  public void listDnsRecordsByNameAndNotFound() {
    expect(dns.listDnsRecords(ZONE_NAME)).andThrow(EXCEPTION);
    expect(dns.listDnsRecords(ZONE_NAME)).andThrow(EXCEPTION);
    // again for options
    expect(dns.listDnsRecords(ZONE_NAME, DNS_RECORD_OPTIONS)).andThrow(EXCEPTION);
    expect(dns.listDnsRecords(ZONE_NAME, DNS_RECORD_OPTIONS)).andThrow(EXCEPTION);
    replay(dns);
    try {
      zoneNoId.listDnsRecords();
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.listDnsRecords();
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zoneNoId.listDnsRecords(DNS_RECORD_OPTIONS); // check options
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.listDnsRecords(DNS_RECORD_OPTIONS); // check options
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
  }

  @Test
  public void reloadByNameAndFound() {
    expect(dns.getZone(ZONE_NAME)).andReturn(zone);
    expect(dns.getZone(ZONE_NAME)).andReturn(zone);
    // again for options
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(zoneNoId);
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(zone);
    replay(dns);
    Zone result = zoneNoId.reload();
    assertSame(zone.dns(), result.dns());
    assertEquals(zone, result);
    result = zone.reload();
    assertSame(zone.dns(), result.dns());
    assertEquals(zone, result);
    zoneNoId.reload(ZONE_FIELD_OPTIONS); // check options
    zone.reload(ZONE_FIELD_OPTIONS); // check options
  }

  @Test
  public void reloadByNameAndNotFound() {
    expect(dns.getZone(ZONE_NAME)).andReturn(null);
    expect(dns.getZone(ZONE_NAME)).andReturn(null);
    // again for options
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(null);
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(null);
    replay(dns);
    Zone result = zoneNoId.reload();
    assertNull(result);
    result = zone.reload();
    assertNull(result);
    zoneNoId.reload(ZONE_FIELD_OPTIONS); // for options
    zone.reload(ZONE_FIELD_OPTIONS); // for options
  }

  @Test
  public void applyChangeByNameAndFound() {
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST))
        .andReturn(CHANGE_REQUEST_AFTER);
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST))
        .andReturn(CHANGE_REQUEST_AFTER);
    // again for options
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(CHANGE_REQUEST_AFTER);
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(CHANGE_REQUEST_AFTER);
    replay(dns);
    ChangeRequest result = zoneNoId.applyChangeRequest(CHANGE_REQUEST);
    assertEquals(CHANGE_REQUEST_AFTER, result);
    result = zone.applyChangeRequest(CHANGE_REQUEST);
    assertEquals(CHANGE_REQUEST_AFTER, result);
    // check options
    result = zoneNoId.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertEquals(CHANGE_REQUEST_AFTER, result);
    result = zone.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertEquals(CHANGE_REQUEST_AFTER, result);
  }

  @Test
  public void applyChangeByNameAndNotFound() {
    // ID is not set
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST)).andThrow(EXCEPTION);
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST)).andThrow(EXCEPTION);
    // again for options
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS))
        .andThrow(EXCEPTION);
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS))
        .andThrow(EXCEPTION);
    replay(dns);
    try {
      zoneNoId.applyChangeRequest(CHANGE_REQUEST);
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.applyChangeRequest(CHANGE_REQUEST);
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    // check options
    try {
      zoneNoId.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
  }

  @Test
  public void applyNullChangeRequest() {
    replay(dns); // no calls expected
    try {
      zone.applyChangeRequest(null);
      fail("Cannot apply null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zone.applyChangeRequest(null, CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot apply null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoId.applyChangeRequest(null);
      fail("Cannot apply null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoId.applyChangeRequest(null, CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot apply null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
  }

  @Test
  public void getChangeAndZoneFoundByName() {
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id()))
        .andReturn(CHANGE_REQUEST_AFTER);
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id()))
        .andReturn(CHANGE_REQUEST_AFTER);
    // again for options
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(CHANGE_REQUEST_AFTER);
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(CHANGE_REQUEST_AFTER);
    replay(dns);
    ChangeRequest result = zoneNoId.getChangeRequest(CHANGE_REQUEST.id());
    assertEquals(CHANGE_REQUEST_AFTER, result);
    result = zone.getChangeRequest(CHANGE_REQUEST.id());
    assertEquals(CHANGE_REQUEST_AFTER, result);
    // check options
    result = zoneNoId.getChangeRequest(CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS);
    assertEquals(CHANGE_REQUEST_AFTER, result);
    result = zone.getChangeRequest(CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS);
    assertEquals(CHANGE_REQUEST_AFTER, result);
  }

  @Test
  public void getChangeAndZoneNotFoundByName() {
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id())).andThrow(EXCEPTION);
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id())).andThrow(EXCEPTION);
    // again for options
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS))
        .andThrow(EXCEPTION);
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS))
        .andThrow(EXCEPTION);
    replay(dns);
    try {
      zoneNoId.getChangeRequest(CHANGE_REQUEST.id());
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.getChangeRequest(CHANGE_REQUEST.id());
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    // check options
    try {
      zoneNoId.getChangeRequest(CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.getChangeRequest(CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
  }

  @Test
  public void getChangedWhichDoesNotExistZoneFound() {
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id())).andReturn(null);
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id())).andReturn(null);
    // again for options
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null);
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null);
    replay(dns);
    assertNull(zoneNoId.getChangeRequest(CHANGE_REQUEST.id()));
    assertNull(zone.getChangeRequest(CHANGE_REQUEST.id()));
    assertNull(zoneNoId.getChangeRequest(CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS));
    assertNull(zone.getChangeRequest(CHANGE_REQUEST.id(), CHANGE_REQUEST_FIELD_OPTIONS));
  }

  @Test
  public void getNullChangeRequest() {
    replay(dns); // no calls expected
    try {
      zone.getChangeRequest(null);
      fail("Cannot get null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zone.getChangeRequest(null, CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot get null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoId.getChangeRequest(null);
      fail("Cannot get null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoId.getChangeRequest(null, CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot get null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
  }

  @Test
  public void getChangeRequestWithNoId() {
    replay(dns); // no calls expected
    try {
      zone.getChangeRequest(CHANGE_REQUEST_NO_ID.id());
      fail("Cannot get ChangeRequest by null id.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zone.getChangeRequest(CHANGE_REQUEST_NO_ID.id(), CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot get ChangeRequest by null id.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoId.getChangeRequest(CHANGE_REQUEST_NO_ID.id());
      fail("Cannot get ChangeRequest by null id.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoId.getChangeRequest(CHANGE_REQUEST_NO_ID.id(), CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot get ChangeRequest by null id.");
    } catch (NullPointerException e) {
      // expected
    }
  }

  @Test
  public void listChangeRequestsAndZoneFound() {
    @SuppressWarnings("unchecked")
    Page<ChangeRequest> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dns.listChangeRequests(ZONE_NAME)).andReturn(pageMock);
    expect(dns.listChangeRequests(ZONE_NAME)).andReturn(pageMock);
    // again for options
    expect(dns.listChangeRequests(ZONE_NAME, CHANGE_REQUEST_LIST_OPTIONS))
        .andReturn(pageMock);
    expect(dns.listChangeRequests(ZONE_NAME, CHANGE_REQUEST_LIST_OPTIONS))
        .andReturn(pageMock);
    replay(dns);
    Page<ChangeRequest> result = zoneNoId.listChangeRequests();
    assertSame(pageMock, result);
    result = zone.listChangeRequests();
    assertSame(pageMock, result);
    verify(pageMock);
    zoneNoId.listChangeRequests(CHANGE_REQUEST_LIST_OPTIONS); // check options
    zone.listChangeRequests(CHANGE_REQUEST_LIST_OPTIONS); // check options
  }

  @Test
  public void listChangeRequestsAndZoneNotFound() {
    expect(dns.listChangeRequests(ZONE_NAME)).andThrow(EXCEPTION);
    expect(dns.listChangeRequests(ZONE_NAME)).andThrow(EXCEPTION);
    // again for options
    expect(dns.listChangeRequests(ZONE_NAME, CHANGE_REQUEST_LIST_OPTIONS)).andThrow(EXCEPTION);
    expect(dns.listChangeRequests(ZONE_NAME, CHANGE_REQUEST_LIST_OPTIONS)).andThrow(EXCEPTION);
    replay(dns);
    try {
      zoneNoId.listChangeRequests();
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.listChangeRequests();
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zoneNoId.listChangeRequests(CHANGE_REQUEST_LIST_OPTIONS); // check options
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.listChangeRequests(CHANGE_REQUEST_LIST_OPTIONS); // check options
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
  }

  @Test
  public void testFromPb() {
    expect(dns.options()).andReturn(OPTIONS);
    replay(dns);
    assertEquals(Zone.fromPb(dns, zone.toPb()), zone);
  }

  @Test
  public void testEqualsAndToBuilder() {
    expect(dns.options()).andReturn(OPTIONS);
    expect(dns.options()).andReturn(OPTIONS);
    replay(dns);
    assertEquals(zone, zone.toBuilder().build());
    assertEquals(zone.hashCode(), zone.toBuilder().build().hashCode());
  }

  @Test
  public void testBuilder() {
    // one for each build() call because it invokes a constructor
    expect(dns.options()).andReturn(OPTIONS);
    expect(dns.options()).andReturn(OPTIONS);
    expect(dns.options()).andReturn(OPTIONS);
    expect(dns.options()).andReturn(OPTIONS);
    expect(dns.options()).andReturn(OPTIONS);
    expect(dns.options()).andReturn(OPTIONS);
    expect(dns.options()).andReturn(OPTIONS);
    expect(dns.options()).andReturn(OPTIONS);
    replay(dns);
    assertNotEquals(zone, zone.toBuilder()
        .id((new BigInteger(zone.id())).add(BigInteger.ONE).toString())
        .build());
    assertNotEquals(zone, zone.toBuilder().dnsName(zone.name() + "aaaa").build());
    assertNotEquals(zone, zone.toBuilder().nameServerSet(zone.nameServerSet() + "aaaa").build());
    assertNotEquals(zone, zone.toBuilder().nameServers(ImmutableList.of("nameserverpppp")).build());
    assertNotEquals(zone, zone.toBuilder().dnsName(zone.dnsName() + "aaaa").build());
    assertNotEquals(zone, zone.toBuilder().creationTimeMillis(zone.creationTimeMillis() + 1)
        .build());
    Zone.Builder builder = zone.toBuilder();
    builder.id(ZONE_ID)
        .dnsName("example.com")
        .creationTimeMillis(123478946464L)
        .build();
    assertEquals(zone, builder.build());
  }
}
