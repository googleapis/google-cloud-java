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

package com.google.cloud.dns;

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

import com.google.api.gax.paging.Page;
import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ZoneTest {

  private static final String ZONE_NAME = "dns-zone-name";
  private static final String ZONE_ID = "123";
  private static final ZoneInfo ZONE_INFO =
      Zone.of(ZONE_NAME, "example.com", "description")
          .toBuilder()
          .setGeneratedId(ZONE_ID)
          .setCreationTimeMillis(123478946464L)
          .build();
  private static final ZoneInfo NO_ID_INFO =
      ZoneInfo.of(ZONE_NAME, "another-example.com", "description")
          .toBuilder()
          .setCreationTimeMillis(893123464L)
          .build();
  private static final Dns.ZoneOption ZONE_FIELD_OPTIONS =
      Dns.ZoneOption.fields(Dns.ZoneField.CREATION_TIME);
  private static final Dns.RecordSetListOption DNS_RECORD_OPTIONS =
      Dns.RecordSetListOption.dnsName("some-dns");
  private static final Dns.ChangeRequestOption CHANGE_REQUEST_FIELD_OPTIONS =
      Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME);
  private static final Dns.ChangeRequestListOption CHANGE_REQUEST_LIST_OPTIONS =
      Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.START_TIME);
  private static final ChangeRequestInfo CHANGE_REQUEST =
      ChangeRequestInfo.newBuilder().setGeneratedId("someid").build();
  private static final ChangeRequestInfo CHANGE_REQUEST_NO_ID =
      ChangeRequestInfo.newBuilder().build();
  private static final DnsException EXCEPTION = new DnsException(-1, "message", null);
  private static final DnsOptions OPTIONS = createStrictMock(DnsOptions.class);

  private Dns dns;
  private Zone zone;
  private Zone zoneNoId;
  private ChangeRequest changeRequestAfter;

  @Before
  public void setUp() throws Exception {
    dns = createStrictMock(Dns.class);
    expect(dns.getOptions()).andReturn(OPTIONS).times(3);
    replay(dns);
    zone = new Zone(dns, new ZoneInfo.BuilderImpl(ZONE_INFO));
    zoneNoId = new Zone(dns, new ZoneInfo.BuilderImpl(NO_ID_INFO));
    changeRequestAfter =
        new ChangeRequest(
            dns,
            ZONE_NAME,
            new ChangeRequestInfo.BuilderImpl(
                CHANGE_REQUEST.toBuilder().setStartTime(123465L).build()));
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
    assertNotNull(zone.getDns());
    assertEquals(dns, zone.getDns());
  }

  @Test
  public void deleteByNameAndFound() {
    expect(dns.delete(ZONE_NAME)).andReturn(true).times(2);
    replay(dns);
    boolean result = zone.delete();
    assertTrue(result);
    result = zoneNoId.delete();
    assertTrue(result);
  }

  @Test
  public void deleteByNameAndNotFound() {
    expect(dns.delete(ZONE_NAME)).andReturn(false).times(2);
    replay(dns);
    boolean result = zoneNoId.delete();
    assertFalse(result);
    result = zone.delete();
    assertFalse(result);
  }

  @Test
  public void listDnsRecordsByNameAndFound() {
    @SuppressWarnings("unchecked")
    Page<RecordSet> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dns.listRecordSets(ZONE_NAME)).andReturn(pageMock).times(2);
    // again for options
    expect(dns.listRecordSets(ZONE_NAME, DNS_RECORD_OPTIONS)).andReturn(pageMock).times(2);
    replay(dns);
    Page<RecordSet> result = zone.listRecordSets();
    assertSame(pageMock, result);
    result = zoneNoId.listRecordSets();
    assertSame(pageMock, result);
    verify(pageMock);
    zone.listRecordSets(DNS_RECORD_OPTIONS); // check options
    zoneNoId.listRecordSets(DNS_RECORD_OPTIONS); // check options
  }

  @Test
  public void listDnsRecordsByNameAndNotFound() {
    expect(dns.listRecordSets(ZONE_NAME)).andThrow(EXCEPTION).times(2);
    // again for options
    expect(dns.listRecordSets(ZONE_NAME, DNS_RECORD_OPTIONS)).andThrow(EXCEPTION).times(2);
    replay(dns);
    try {
      zoneNoId.listRecordSets();
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.listRecordSets();
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zoneNoId.listRecordSets(DNS_RECORD_OPTIONS); // check options
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.listRecordSets(DNS_RECORD_OPTIONS); // check options
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
  }

  @Test
  public void reloadByNameAndFound() {
    expect(dns.getZone(ZONE_NAME)).andReturn(zone).times(2);
    // again for options
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(zoneNoId);
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(zone);
    replay(dns);
    Zone result = zoneNoId.reload();
    assertSame(zone.getDns(), result.getDns());
    assertEquals(zone, result);
    result = zone.reload();
    assertSame(zone.getDns(), result.getDns());
    assertEquals(zone, result);
    zoneNoId.reload(ZONE_FIELD_OPTIONS); // check options
    zone.reload(ZONE_FIELD_OPTIONS); // check options
  }

  @Test
  public void reloadByNameAndNotFound() {
    expect(dns.getZone(ZONE_NAME)).andReturn(null).times(2);
    // again for options
    expect(dns.getZone(ZONE_NAME, ZONE_FIELD_OPTIONS)).andReturn(null).times(2);
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
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST)).andReturn(changeRequestAfter);
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST)).andReturn(changeRequestAfter);
    // again for options
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(changeRequestAfter);
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(changeRequestAfter);
    replay(dns);
    ChangeRequest result = zoneNoId.applyChangeRequest(CHANGE_REQUEST);
    assertEquals(changeRequestAfter, result);
    result = zone.applyChangeRequest(CHANGE_REQUEST);
    assertEquals(changeRequestAfter, result);
    // check options
    result = zoneNoId.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertEquals(changeRequestAfter, result);
    result = zone.applyChangeRequest(CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS);
    assertEquals(changeRequestAfter, result);
  }

  @Test
  public void applyChangeByNameAndNotFound() {
    // ID is not set
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST)).andThrow(EXCEPTION).times(2);
    // again for options
    expect(dns.applyChangeRequest(ZONE_NAME, CHANGE_REQUEST, CHANGE_REQUEST_FIELD_OPTIONS))
        .andThrow(EXCEPTION)
        .times(2);
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
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.getGeneratedId()))
        .andReturn(changeRequestAfter)
        .times(2);
    // again for options
    expect(
            dns.getChangeRequest(
                ZONE_NAME, CHANGE_REQUEST.getGeneratedId(), CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(changeRequestAfter)
        .times(2);
    replay(dns);
    ChangeRequest result = zoneNoId.getChangeRequest(CHANGE_REQUEST.getGeneratedId());
    assertEquals(changeRequestAfter, result);
    result = zone.getChangeRequest(CHANGE_REQUEST.getGeneratedId());
    assertEquals(changeRequestAfter, result);
    // check options
    result =
        zoneNoId.getChangeRequest(CHANGE_REQUEST.getGeneratedId(), CHANGE_REQUEST_FIELD_OPTIONS);
    assertEquals(changeRequestAfter, result);
    result = zone.getChangeRequest(CHANGE_REQUEST.getGeneratedId(), CHANGE_REQUEST_FIELD_OPTIONS);
    assertEquals(changeRequestAfter, result);
  }

  @Test
  public void getChangeAndZoneNotFoundByName() {
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.getGeneratedId()))
        .andThrow(EXCEPTION)
        .times(2);
    // again for options
    expect(
            dns.getChangeRequest(
                ZONE_NAME, CHANGE_REQUEST.getGeneratedId(), CHANGE_REQUEST_FIELD_OPTIONS))
        .andThrow(EXCEPTION)
        .times(2);
    replay(dns);
    try {
      zoneNoId.getChangeRequest(CHANGE_REQUEST.getGeneratedId());
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.getChangeRequest(CHANGE_REQUEST.getGeneratedId());
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    // check options
    try {
      zoneNoId.getChangeRequest(CHANGE_REQUEST.getGeneratedId(), CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
    try {
      zone.getChangeRequest(CHANGE_REQUEST.getGeneratedId(), CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Parent container not found, should throw an exception.");
    } catch (DnsException e) {
      // expected
    }
  }

  @Test
  public void getChangedWhichDoesNotExistZoneFound() {
    expect(dns.getChangeRequest(ZONE_NAME, CHANGE_REQUEST.getGeneratedId()))
        .andReturn(null)
        .times(2);
    // again for options
    expect(
            dns.getChangeRequest(
                ZONE_NAME, CHANGE_REQUEST.getGeneratedId(), CHANGE_REQUEST_FIELD_OPTIONS))
        .andReturn(null)
        .times(2);
    replay(dns);
    assertNull(zoneNoId.getChangeRequest(CHANGE_REQUEST.getGeneratedId()));
    assertNull(zone.getChangeRequest(CHANGE_REQUEST.getGeneratedId()));
    assertNull(
        zoneNoId.getChangeRequest(CHANGE_REQUEST.getGeneratedId(), CHANGE_REQUEST_FIELD_OPTIONS));
    assertNull(
        zone.getChangeRequest(CHANGE_REQUEST.getGeneratedId(), CHANGE_REQUEST_FIELD_OPTIONS));
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
      zone.getChangeRequest(CHANGE_REQUEST_NO_ID.getGeneratedId());
      fail("Cannot get ChangeRequest by null id.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zone.getChangeRequest(CHANGE_REQUEST_NO_ID.getGeneratedId(), CHANGE_REQUEST_FIELD_OPTIONS);
      fail("Cannot get ChangeRequest by null id.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoId.getChangeRequest(CHANGE_REQUEST_NO_ID.getGeneratedId());
      fail("Cannot get ChangeRequest by null id.");
    } catch (NullPointerException e) {
      // expected
    }
    try {
      zoneNoId.getChangeRequest(
          CHANGE_REQUEST_NO_ID.getGeneratedId(), CHANGE_REQUEST_FIELD_OPTIONS);
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
    expect(dns.listChangeRequests(ZONE_NAME)).andReturn(pageMock).times(2);
    // again for options
    expect(dns.listChangeRequests(ZONE_NAME, CHANGE_REQUEST_LIST_OPTIONS))
        .andReturn(pageMock)
        .times(2);
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
    expect(dns.listChangeRequests(ZONE_NAME)).andThrow(EXCEPTION).times(2);
    // again for options
    expect(dns.listChangeRequests(ZONE_NAME, CHANGE_REQUEST_LIST_OPTIONS))
        .andThrow(EXCEPTION)
        .times(2);
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
    expect(dns.getOptions()).andReturn(OPTIONS);
    replay(dns);
    assertEquals(Zone.fromPb(dns, zone.toPb()), zone);
  }

  @Test
  public void testEqualsAndToBuilder() {
    expect(dns.getOptions()).andReturn(OPTIONS).times(2);
    replay(dns);
    assertEquals(zone, zone.toBuilder().build());
    assertEquals(zone.hashCode(), zone.toBuilder().build().hashCode());
  }

  @Test
  public void testBuilder() {
    // one for each build() call because it invokes a constructor
    expect(dns.getOptions()).andReturn(OPTIONS).times(8);
    replay(dns);
    assertNotEquals(
        zone,
        zone.toBuilder()
            .setGeneratedId(new BigInteger(zone.getGeneratedId()).add(BigInteger.ONE).toString())
            .build());
    assertNotEquals(zone, zone.toBuilder().setDnsName(zone.getName() + "aaaa").build());
    assertNotEquals(
        zone, zone.toBuilder().setNameServerSet(zone.getNameServerSet() + "aaaa").build());
    assertNotEquals(
        zone, zone.toBuilder().setNameServers(ImmutableList.of("nameserverpppp")).build());
    assertNotEquals(zone, zone.toBuilder().setDnsName(zone.getDnsName() + "aaaa").build());
    assertNotEquals(
        zone, zone.toBuilder().setCreationTimeMillis(zone.getCreationTimeMillis() + 1).build());
    Zone.Builder builder = zone.toBuilder();
    builder
        .setGeneratedId(ZONE_ID)
        .setDnsName("example.com")
        .setCreationTimeMillis(123478946464L)
        .build();
    assertEquals(zone, builder.build());
  }
}
