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
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.gcloud.Page;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class ZoneTest {

  private static final String ZONE_NAME = "dns-zone-name";
  private static final BigInteger ZONE_ID = new BigInteger("123");
  private static final ZoneInfo ZONE_INFO = ZoneInfo.builder(ZONE_NAME, ZONE_ID)
      .dnsName("example.com")
      .creationTimeMillis(123478946464L)
      .build();
  private static final ZoneInfo NO_ID_INFO = ZoneInfo.builder(ZONE_NAME)
      .dnsName("anoter-example.com")
      .creationTimeMillis(893123464L)
      .build();
  private static final ZoneInfo NO_NAME_INFO = ZoneInfo.builder(ZONE_ID)
      .dnsName("one-more-example.com")
      .creationTimeMillis(875221546464L)
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

  private Dns dns;
  private Zone zone;
  private Zone zoneNoName;
  private Zone zoneNoId;

  @Before
  public void setUp() throws Exception {
    dns = createStrictMock(Dns.class);
    zone = new Zone(dns, ZONE_INFO);
    zoneNoId = new Zone(dns, NO_ID_INFO);
    zoneNoName = new Zone(dns, NO_NAME_INFO);
  }

  @After
  public void tearDown() throws Exception {
    verify(dns);
  }

  @Test
  public void testConstructor() {
    replay(dns);
    assertNotNull(zone.info());
    assertEquals(ZONE_INFO, zone.info());
    assertNotNull(zone.dns());
    assertEquals(dns, zone.dns());
  }

  @Test
  public void testGetById() {
    expect(dns.getZone(ZONE_ID)).andReturn(ZONE_INFO);
    expect(dns.getZone(ZONE_ID, ZONE_FIELD_OPTIONS)).andReturn(ZONE_INFO); // for options
    replay(dns);
    Zone retrieved = Zone.get(dns, ZONE_ID);
    assertSame(dns, retrieved.dns());
    assertEquals(ZONE_INFO, retrieved.info());
    BigInteger id = null;
    try {
      Zone.get(dns, id);
      fail("Cannot get null zone.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      Zone.get(null, id);
      fail("Cannot get null zone.");
    } catch (NullPointerException e) {
      // expected
    }
    // test passing options
    Zone.get(dns, ZONE_ID, ZONE_FIELD_OPTIONS);
  }

  @Test
  public void testGetByName() {
    expect(dns.getZone(ZONE_NAME)).andReturn(ZONE_INFO);
    expect(dns.getZone(ZONE_ID, ZONE_FIELD_OPTIONS)).andReturn(ZONE_INFO); // for options
    replay(dns);
    Zone retrieved = Zone.get(dns, ZONE_NAME);
    assertSame(dns, retrieved.dns());
    assertEquals(ZONE_INFO, retrieved.info());
    String name = null;
    try {
      Zone.get(dns, name);
      fail("Cannot get null zone.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      Zone.get(null, name);
      fail("Cannot get null zone.");
    } catch (NullPointerException e) {
      // expected
    }
    // test passing options
    Zone.get(dns, ZONE_ID, ZONE_FIELD_OPTIONS);
  }

  @Test
  public void deleteByIdAndFound() {
    expect(dns.delete(ZONE_ID)).andReturn(true);
    replay(dns);
    boolean result = zone.delete();
    assertTrue(result);
  }

  @Test
  public void deleteByIdAndNotFoundAndNameSetAndFound() {
    expect(dns.delete(ZONE_ID)).andReturn(false);
    expect(dns.delete(ZONE_NAME)).andReturn(true);
    replay(dns);
    boolean result = zone.delete();
    assertTrue(result);
  }

  @Test
  public void deleteByIdAndNotFoundAndNameSetAndNotFound() {
    expect(dns.delete(ZONE_ID)).andReturn(false);
    expect(dns.delete(ZONE_NAME)).andReturn(false);
    replay(dns);
    boolean result = zone.delete();
    assertFalse(result);
  }

  @Test
  public void deleteByIdAndNotFoundAndNameNotSet() {
    expect(dns.delete(ZONE_ID)).andReturn(false);
    replay(dns);
    boolean result = zoneNoName.delete();
    assertFalse(result);
  }

  @Test
  public void deleteByNameAndFound() {
    expect(dns.delete(ZONE_NAME)).andReturn(true);
    replay(dns);
    boolean result = zoneNoId.delete();
    assertTrue(result);
  }

  @Test
  public void deleteByNameAndNotFound() {
    expect(dns.delete(ZONE_NAME)).andReturn(true);
    replay(dns);
    boolean result = zoneNoId.delete();
    assertTrue(result);
  }

  @Test
  public void listDnsRecordsByIdAndFound() {
    Page<DnsRecord> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dns.listDnsRecords(ZONE_ID)).andReturn(pageMock);
    // again for options
    expect(dns.listDnsRecords(ZONE_ID, DNS_RECORD_OPTIONS)).andReturn(pageMock);
    replay(dns);
    Page<DnsRecord> result = zone.listDnsRecords();
    assertSame(pageMock, result);
    verify(pageMock);
    // verify options
    zone.listDnsRecords(DNS_RECORD_OPTIONS);
  }

  @Test
  public void listDnsRecordsByIdAndNotFoundAndNameSetAndFound() {
    Page<DnsRecord> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dns.listDnsRecords(ZONE_ID)).andReturn(null);
    expect(dns.listDnsRecords(ZONE_NAME)).andReturn(pageMock);
    // again for options
    expect(dns.listDnsRecords(ZONE_ID, DNS_RECORD_OPTIONS)).andReturn(null);
    expect(dns.listDnsRecords(ZONE_NAME, DNS_RECORD_OPTIONS)).andReturn(pageMock);
    replay(dns);
    Page<DnsRecord> result = zone.listDnsRecords();
    assertSame(pageMock, result);
    verify(pageMock);
    // verify options
    zone.listDnsRecords(DNS_RECORD_OPTIONS);
  }

  @Test
  public void listDnsRecordsByIdAndNotFoundAndNameSetAndNotFound() {
    expect(dns.listDnsRecords(ZONE_ID)).andReturn(null);
    expect(dns.listDnsRecords(ZONE_NAME)).andReturn(null);
    // again for options
    expect(dns.listDnsRecords(ZONE_ID, DNS_RECORD_OPTIONS)).andReturn(null);
    expect(dns.listDnsRecords(ZONE_NAME, DNS_RECORD_OPTIONS)).andReturn(null);
    replay(dns);
    Page<DnsRecord> result = zone.listDnsRecords();
    assertNull(result);
    // check options
    zone.listDnsRecords(DNS_RECORD_OPTIONS);
  }

  @Test
  public void listDnsRecordsByIdAndNotFoundAndNameNotSet() {
    expect(dns.listDnsRecords(ZONE_ID)).andReturn(null);
    expect(dns.listDnsRecords(ZONE_ID, DNS_RECORD_OPTIONS)).andReturn(null); // for options
    replay(dns);
    Page<DnsRecord> result = zoneNoName.listDnsRecords();
    assertNull(result);
    zoneNoName.listDnsRecords(DNS_RECORD_OPTIONS); // check options
  }

  @Test
  public void listDnsRecordsByNameAndFound() {
    Page<DnsRecord> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dns.listDnsRecords(ZONE_NAME)).andReturn(pageMock);
    // again for options
    expect(dns.listDnsRecords(ZONE_NAME, DNS_RECORD_OPTIONS)).andReturn(pageMock);
    replay(dns);
    Page<DnsRecord> result = zoneNoId.listDnsRecords();
    assertSame(pageMock, result);
    verify(pageMock);
    zoneNoId.listDnsRecords(DNS_RECORD_OPTIONS); // check options
  }

  @Test
  public void listDnsRecordsByNameAndNotFound() {
    expect(dns.listDnsRecords(ZONE_NAME)).andReturn(null);
    // again for options
    expect(dns.listDnsRecords(ZONE_NAME, DNS_RECORD_OPTIONS)).andReturn(null);
    replay(dns);
    Page<DnsRecord> result = zoneNoId.listDnsRecords();
    assertNull(result);
    zoneNoId.listDnsRecords(DNS_RECORD_OPTIONS); // check options
  }

  @Test
  public void reloadByIdAndFound() {
    expect(dns.getZone(ZONE_ID)).andReturn(zone.info());
    expect(dns.getZone(ZONE_ID, ZONE_FIELD_OPTIONS)).andReturn(zone.info()); // for options
    replay(dns);
    Zone result = zone.reload();
    assertSame(zone.dns(), result.dns());
    assertEquals(zone.info(), result.info());
    zone.reload(ZONE_FIELD_OPTIONS); // for options
  }

  @Test
  public void reloadByIdAndNotFoundAndNameSetAndFound() {
    expect(dns.getZone(ZONE_ID)).andReturn(null);
    expect(dns.getZone(ZONE_NAME)).andReturn(zone.info());
    // again for options
    expect(dns.getZone(ZONE_ID, ZONE_FIELD_OPTIONS)).andReturn(null);
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(zone.info());
    replay(dns);
    Zone result = zone.reload();
    assertSame(zone.dns(), result.dns());
    assertEquals(zone.info(), result.info());
    zone.reload(ZONE_FIELD_OPTIONS); // for options
  }

  @Test
  public void reloadByIdAndNotFoundAndNameSetAndNotFound() {
    expect(dns.getZone(ZONE_ID)).andReturn(null);
    expect(dns.getZone(ZONE_NAME)).andReturn(null);
    // again with options
    expect(dns.getZone(ZONE_ID, ZONE_FIELD_OPTIONS)).andReturn(null);
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(null);
    replay(dns);
    Zone result = zone.reload();
    assertNull(result);
    // again for options
    zone.reload(ZONE_FIELD_OPTIONS);
  }

  @Test
  public void reloadByIdAndNotFoundAndNameNotSet() {
    expect(dns.getZone(ZONE_ID)).andReturn(null);
    expect(dns.getZone(ZONE_ID, ZONE_FIELD_OPTIONS)).andReturn(null); // for options
    replay(dns);
    Zone result = zoneNoName.reload();
    assertNull(result);
    zoneNoName.reload(ZONE_FIELD_OPTIONS); // for options
  }

  @Test
  public void reloadByNameAndFound() {
    expect(dns.getZone(ZONE_NAME)).andReturn(zoneNoId.info());
    // again for options
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(zoneNoId.info());
    replay(dns);
    Zone result = zoneNoId.reload();
    assertSame(zoneNoId.dns(), result.dns());
    assertEquals(zoneNoId.info(), result.info());
    zoneNoId.reload(ZONE_FIELD_OPTIONS); // check options
  }

  @Test
  public void reloadByNameAndNotFound() {
    expect(dns.getZone(ZONE_NAME)).andReturn(null);
    // again for options
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(null);
    replay(dns);
    Zone result = zoneNoId.reload();
    assertNull(result);
    zoneNoId.reload(ZONE_FIELD_OPTIONS); // for options
  }

  @Test
  public void applyChangeByIdAndFound() {
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_ID)).andReturn(CHANGE_REQUEST_AFTER);
    // again for options
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_ID, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(CHANGE_REQUEST_AFTER);
    replay(dns);
    ChangeRequest result = zone.applyChangeRequest(CHANGE_REQUEST);
    assertNotEquals(CHANGE_REQUEST, result);
    assertEquals(CHANGE_REQUEST_AFTER, result);
    // for options
    result = zone.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertNotEquals(CHANGE_REQUEST, result);
    assertEquals(CHANGE_REQUEST_AFTER, result);
  }

  @Test
  public void applyChangeByIdAndNotFoundAndNameSetAndFound() {
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_ID)).andReturn(null);
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_NAME))
        .andReturn(CHANGE_REQUEST_AFTER);
    // again for options
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_ID, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null);
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_NAME, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(CHANGE_REQUEST_AFTER);
    replay(dns);
    ChangeRequest result = zone.applyChangeRequest(CHANGE_REQUEST);
    assertNotEquals(CHANGE_REQUEST, result);
    assertEquals(CHANGE_REQUEST_AFTER, result);
    // for options
    result = zone.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertNotEquals(CHANGE_REQUEST, result);
    assertEquals(CHANGE_REQUEST_AFTER, result);
  }

  @Test
  public void applyChangeIdAndNotFoundAndNameSetAndNotFound() {
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_ID)).andReturn(null);
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_NAME)).andReturn(null);
    // again with options
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_ID, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null);
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_NAME, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null);
    replay(dns);
    ChangeRequest result = zone.applyChangeRequest(CHANGE_REQUEST);
    assertNull(result);
    // again for options
    result = zone.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertNull(result);
  }

  @Test
  public void applyChangeRequestByIdAndNotFoundAndNameNotSet() {
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_ID)).andReturn(null);
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_ID, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null); // for options
    replay(dns);
    ChangeRequest result = zoneNoName.applyChangeRequest(CHANGE_REQUEST);
    assertNull(result);
    // again for options
    result = zoneNoName.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertNull(result);
  }

  @Test
  public void applyChangeByNameAndFound() {
    // ID is not set
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_NAME))
        .andReturn(CHANGE_REQUEST_AFTER);
    // again for options
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_NAME, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(CHANGE_REQUEST_AFTER);
    replay(dns);
    ChangeRequest result = zoneNoId.applyChangeRequest(CHANGE_REQUEST);
    assertEquals(CHANGE_REQUEST_AFTER, result);
    // check options
    result = zoneNoId.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertEquals(CHANGE_REQUEST_AFTER, result);
  }

  @Test
  public void applyChangeByNameAndNotFound() {
    // ID is not set
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_NAME)).andReturn(null);
    // again for options
    expect(dns.applyChangeRequest(CHANGE_REQUEST, ZONE_NAME, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null);
    replay(dns);
    ChangeRequest result = zoneNoId.applyChangeRequest(CHANGE_REQUEST);
    assertNull(result);
    // check options
    result = zoneNoId.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertNull(result);
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
    try {
      zoneNoName.applyChangeRequest(null);
      fail("Cannot apply null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoName.applyChangeRequest(null, CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot apply null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
  }

  @Test
  public void getChangeByIdAndFound() {
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_ID)).andReturn(CHANGE_REQUEST_AFTER);
    // again for options
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_ID, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(CHANGE_REQUEST_AFTER);
    replay(dns);
    ChangeRequest result = zone.getChangeRequest(CHANGE_REQUEST);
    assertNotEquals(CHANGE_REQUEST, result);
    assertEquals(CHANGE_REQUEST_AFTER, result);
    // for options
    result = zone.getChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertNotEquals(CHANGE_REQUEST, result);
    assertEquals(CHANGE_REQUEST_AFTER, result);
    // test no id
  }

  @Test
  public void getChangeByIdAndNotFoundAndNameSetAndFound() {
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_ID)).andReturn(null);
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_NAME))
        .andReturn(CHANGE_REQUEST_AFTER);
    // again for options
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_ID, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null);
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_NAME, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(CHANGE_REQUEST_AFTER);
    replay(dns);
    ChangeRequest result = zone.getChangeRequest(CHANGE_REQUEST);
    assertNotEquals(CHANGE_REQUEST, result);
    assertEquals(CHANGE_REQUEST_AFTER, result);
    // for options
    result = zone.getChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertNotEquals(CHANGE_REQUEST, result);
    assertEquals(CHANGE_REQUEST_AFTER, result);
  }

  @Test
  public void getChangeIdAndNotFoundAndNameSetAndNotFound() {
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_ID)).andReturn(null);
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_NAME)).andReturn(null);
    // again with options
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_ID, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null);
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_NAME, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null);
    replay(dns);
    ChangeRequest result = zone.getChangeRequest(CHANGE_REQUEST);
    assertNull(result);
    // again for options
    result = zone.getChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertNull(result);
  }

  @Test
  public void getChangeRequestByIdAndNotFoundAndNameNotSet() {
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_ID)).andReturn(null);
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_ID, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null); // for options
    replay(dns);
    ChangeRequest result = zoneNoName.getChangeRequest(CHANGE_REQUEST);
    assertNull(result);
    // again for options
    result = zoneNoName.getChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertNull(result);
  }

  @Test
  public void getChangeByNameAndFound() {
    // ID is not set
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_NAME))
        .andReturn(CHANGE_REQUEST_AFTER);
    // again for options
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_NAME, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(CHANGE_REQUEST_AFTER);
    replay(dns);
    ChangeRequest result = zoneNoId.getChangeRequest(CHANGE_REQUEST);
    assertEquals(CHANGE_REQUEST_AFTER, result);
    // check options
    result = zoneNoId.getChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertEquals(CHANGE_REQUEST_AFTER, result);
  }

  @Test
  public void getChangeByNameAndNotFound() {
    // ID is not set
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_NAME)).andReturn(null);
    // again for options
    expect(dns.getChangeRequest(CHANGE_REQUEST, ZONE_NAME, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null);
    replay(dns);
    ChangeRequest result = zoneNoId.getChangeRequest(CHANGE_REQUEST);
    assertNull(result);
    // check options
    result = zoneNoId.getChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertNull(result);
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
    try {
      zoneNoName.getChangeRequest(null);
      fail("Cannot get null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoName.getChangeRequest(null, CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot get null ChangeRequest.");
    } catch (NullPointerException e) {
      // expected
    }
  }

  @Test
  public void getChangeRequestWithNoId() {
    replay(dns); // no calls expected
    try {
      zone.getChangeRequest(CHANGE_REQUEST_NO_ID);
      fail("Cannot get ChangeRequest with no id.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zone.getChangeRequest(CHANGE_REQUEST_NO_ID, CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot get ChangeRequest with no id.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoId.getChangeRequest(CHANGE_REQUEST_NO_ID);
      fail("Cannot get ChangeRequest with no id.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoId.getChangeRequest(CHANGE_REQUEST_NO_ID, CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot get ChangeRequest with no id.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoName.getChangeRequest(CHANGE_REQUEST_NO_ID);
      fail("Cannot get ChangeRequest with no id.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoName.getChangeRequest(CHANGE_REQUEST_NO_ID, CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot get ChangeRequest with no id.");
    } catch (NullPointerException e) {
      // expected
    }
  }

  @Test
  public void listChangeRequestsByIdAndFound() {
    Page<ChangeRequest> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dns.listChangeRequests(ZONE_ID)).andReturn(pageMock);
    // again for options
    expect(dns.listChangeRequests(ZONE_ID, CHANGE_REQUEST_LIST_OPTIONS)).andReturn(pageMock);
    replay(dns);
    Page<ChangeRequest> result = zone.listChangeRequests();
    assertSame(pageMock, result);
    verify(pageMock);
    // verify options
    zone.listChangeRequests(CHANGE_REQUEST_LIST_OPTIONS);
  }

  @Test
  public void listChangeRequestsByIdAndNotFoundAndNameSetAndFound() {
    Page<ChangeRequest> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dns.listChangeRequests(ZONE_ID)).andReturn(null);
    expect(dns.listChangeRequests(ZONE_NAME)).andReturn(pageMock);
    // again for options
    expect(dns.listChangeRequests(ZONE_ID, CHANGE_REQUEST_LIST_OPTIONS)).andReturn(null);
    expect(dns.listChangeRequests(ZONE_NAME, CHANGE_REQUEST_LIST_OPTIONS))
        .andReturn(pageMock);
    replay(dns);
    Page<ChangeRequest> result = zone.listChangeRequests();
    assertSame(pageMock, result);
    verify(pageMock);
    // verify options
    zone.listChangeRequests(CHANGE_REQUEST_LIST_OPTIONS);
  }

  @Test
  public void listChangeRequestsByIdAndNotFoundAndNameSetAndNotFound() {
    expect(dns.listChangeRequests(ZONE_ID)).andReturn(null);
    expect(dns.listChangeRequests(ZONE_NAME)).andReturn(null);
    // again for options
    expect(dns.listChangeRequests(ZONE_ID, CHANGE_REQUEST_LIST_OPTIONS)).andReturn(null);
    expect(dns.listChangeRequests(ZONE_NAME, CHANGE_REQUEST_LIST_OPTIONS)).andReturn(null);
    replay(dns);
    Page<ChangeRequest> result = zone.listChangeRequests();
    assertNull(result);
    // check options
    zone.listChangeRequests(CHANGE_REQUEST_LIST_OPTIONS);
  }

  @Test
  public void listChangeRequestsByIdAndNotFoundAndNameNotSet() {
    expect(dns.listChangeRequests(ZONE_ID)).andReturn(null);
    // again for options
    expect(dns.listChangeRequests(ZONE_ID, CHANGE_REQUEST_LIST_OPTIONS)).andReturn(null);
    replay(dns);
    Page<ChangeRequest> result = zoneNoName.listChangeRequests();
    assertNull(result);
    zoneNoName.listChangeRequests(CHANGE_REQUEST_LIST_OPTIONS); // check options
  }

  @Test
  public void listChangeRequestsByNameAndFound() {
    Page<ChangeRequest> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dns.listChangeRequests(ZONE_NAME)).andReturn(pageMock);
    // again for options
    expect(dns.listChangeRequests(ZONE_NAME, CHANGE_REQUEST_LIST_OPTIONS))
        .andReturn(pageMock);
    replay(dns);
    Page<ChangeRequest> result = zoneNoId.listChangeRequests();
    assertSame(pageMock, result);
    verify(pageMock);
    zoneNoId.listChangeRequests(CHANGE_REQUEST_LIST_OPTIONS); // check options
  }

  @Test
  public void listChangeRequestsByNameAndNotFound() {
    expect(dns.listChangeRequests(ZONE_NAME)).andReturn(null);
    // again for options
    expect(dns.listChangeRequests(ZONE_NAME, CHANGE_REQUEST_LIST_OPTIONS)).andReturn(null);
    replay(dns);
    Page<ChangeRequest> result = zoneNoId.listChangeRequests();
    assertNull(result);
    zoneNoId.listChangeRequests(CHANGE_REQUEST_LIST_OPTIONS); // check options
  }
}
