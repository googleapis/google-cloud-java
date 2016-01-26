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

import com.google.gcloud.Page;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class ManagedZoneTest {

  private static final String ZONE_NAME = "dns-zone-name";
  private static final BigInteger ZONE_ID = new BigInteger("123");
  private static final ManagedZoneInfo ZONE_INFO = ManagedZoneInfo.builder(ZONE_NAME, ZONE_ID)
      .dnsName("example.com")
      .creationTimeMillis(123478946464L)
      .build();
  private static final ManagedZoneInfo NO_ID_INFO = ManagedZoneInfo.builder(ZONE_NAME)
      .dnsName("anoter-example.com")
      .creationTimeMillis(893123464L)
      .build();
  private static final ManagedZoneInfo NO_NAME_INFO = ManagedZoneInfo.builder(ZONE_ID)
      .dnsName("one-more-example.com")
      .creationTimeMillis(875221546464L)
      .build();
  private DnsService dnsService;
  private ManagedZone managedZone;
  private ManagedZone managedZoneNoName;
  private ManagedZone managedZoneNoId;

  @Before
  public void setUp() throws Exception {
    dnsService = createStrictMock(DnsService.class);
    managedZone = new ManagedZone(dnsService, ZONE_INFO);
    managedZoneNoId = new ManagedZone(dnsService, NO_ID_INFO);
    managedZoneNoName = new ManagedZone(dnsService, NO_NAME_INFO);
  }

  @After
  public void tearDown() throws Exception {
    verify(dnsService);
  }

  @Test
  public void testConstructor() {
    replay(dnsService);
    assertNotNull(managedZone.info());
    assertEquals(ZONE_INFO, managedZone.info());
    assertNotNull(managedZone.dnsService());
    assertEquals(dnsService, managedZone.dnsService());
  }

  @Test
  public void testGetById() {
    expect(dnsService.getManagedZone(ZONE_ID)).andReturn(ZONE_INFO);
    replay(dnsService);
    ManagedZone retrieved = ManagedZone.get(dnsService, ZONE_ID);
    assertSame(dnsService, retrieved.dnsService());
    assertEquals(ZONE_INFO, retrieved.info());
  }

  @Test
  public void testGetByName() {
    expect(dnsService.getManagedZone(ZONE_NAME)).andReturn(ZONE_INFO);
    replay(dnsService);
    ManagedZone retrieved = ManagedZone.get(dnsService, ZONE_NAME);
    assertSame(dnsService, retrieved.dnsService());
    assertEquals(ZONE_INFO, retrieved.info());
  }

  @Test
  public void deleteByIdAndFound() {
    expect(dnsService.delete(ZONE_ID)).andReturn(true);
    replay(dnsService);
    boolean result = managedZone.delete();
    assertTrue(result);
  }

  @Test
  public void deleteByIdAndNotFoundAndNameSetAndFound() {
    expect(dnsService.delete(ZONE_ID)).andReturn(false);
    expect(dnsService.delete(ZONE_NAME)).andReturn(true);
    replay(dnsService);
    boolean result = managedZone.delete();
    assertTrue(result);
  }

  @Test
  public void deleteByIdAndNotFoundAndNameSetAndNotFound() {
    expect(dnsService.delete(ZONE_ID)).andReturn(false);
    expect(dnsService.delete(ZONE_NAME)).andReturn(false);
    replay(dnsService);
    boolean result = managedZone.delete();
    assertFalse(result);
  }

  @Test
  public void deleteByIdAndNotFoundAndNameNotSet() {
    expect(dnsService.delete(ZONE_ID)).andReturn(false);
    replay(dnsService);
    boolean result = managedZoneNoName.delete();
    assertFalse(result);
  }

  @Test
  public void deleteByNameAndFound() {
    expect(dnsService.delete(ZONE_NAME)).andReturn(true);
    replay(dnsService);
    boolean result = managedZoneNoId.delete();
    assertTrue(result);
  }

  @Test
  public void deleteByNameAndNotFound() {
    expect(dnsService.delete(ZONE_NAME)).andReturn(true);
    replay(dnsService);
    boolean result = managedZoneNoId.delete();
    assertTrue(result);
  }

  @Test
  public void listDnsRecordsByIdAndFound() {
    Page<DnsRecord> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dnsService.listDnsRecords(ZONE_ID)).andReturn(pageMock);
    replay(dnsService);
    Page<DnsRecord> result = managedZone.listDnsRecords();
    assertSame(pageMock, result);
    verify(pageMock);
  }

  @Test
  public void listDnsRecordsByIdAndNotFoundAndNameSetAndFound() {
    Page<DnsRecord> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dnsService.listDnsRecords(ZONE_ID)).andReturn(null);
    expect(dnsService.listDnsRecords(ZONE_NAME)).andReturn(pageMock);
    replay(dnsService);
    Page<DnsRecord> result = managedZone.listDnsRecords();
    assertSame(pageMock, result);
    verify(pageMock);
  }

  @Test
  public void listDnsRecordsByIdAndNotFoundAndNameSetAndNotFound() {
    expect(dnsService.listDnsRecords(ZONE_ID)).andReturn(null);
    expect(dnsService.listDnsRecords(ZONE_NAME)).andReturn(null);
    replay(dnsService);
    Page<DnsRecord> result = managedZone.listDnsRecords();
    assertNull(result);
  }

  @Test
  public void listDnsRecordsByIdAndNotFoundAndNameNotSet() {
    expect(dnsService.listDnsRecords(ZONE_ID)).andReturn(null);
    replay(dnsService);
    Page<DnsRecord> result = managedZoneNoName.listDnsRecords();
    assertNull(result);
  }

  @Test
  public void listDnsRecordsByNameAndFound() {
    Page<DnsRecord> pageMock = createStrictMock(Page.class);
    replay(pageMock);
    expect(dnsService.listDnsRecords(ZONE_NAME)).andReturn(pageMock);
    replay(dnsService);
    Page<DnsRecord> result = managedZoneNoId.listDnsRecords();
    assertSame(pageMock, result);
    verify(pageMock);
  }

  @Test
  public void listDnsRecordsByNameAndNotFound() {
    expect(dnsService.listDnsRecords(ZONE_NAME)).andReturn(null);
    replay(dnsService);
    Page<DnsRecord> result = managedZoneNoId.listDnsRecords();
    assertNull(result);
  }

  @Test
  public void reloadByIdAndFound() {
    expect(dnsService.getManagedZone(ZONE_ID)).andReturn(managedZone.info());
    replay(dnsService);
    ManagedZone result = managedZone.reload();
    assertSame(managedZone.dnsService(), result.dnsService());
    assertEquals(managedZone.info(), result.info());
  }

  @Test
  public void reloadByIdAndNotFoundAndNameSetAndFound() {
    expect(dnsService.getManagedZone(ZONE_ID)).andReturn(null);
    expect(dnsService.getManagedZone(ZONE_NAME)).andReturn(managedZone.info());
    replay(dnsService);
    ManagedZone result = managedZone.reload();
    assertSame(managedZone.dnsService(), result.dnsService());
    assertEquals(managedZone.info(), result.info());
  }

  @Test
  public void reloadByIdAndNotFoundAndNameSetAndNotFound() {
    expect(dnsService.getManagedZone(ZONE_ID)).andReturn(null);
    expect(dnsService.getManagedZone(ZONE_NAME)).andReturn(null);
    replay(dnsService);
    ManagedZone result = managedZone.reload();
    assertNull(result);
  }

  @Test
  public void reloadByIdAndNotFoundAndNameNotSet() {
    expect(dnsService.getManagedZone(ZONE_ID)).andReturn(null);
    replay(dnsService);
    ManagedZone result = managedZoneNoName.reload();
    assertNull(result);
  }

  @Test
  public void reloadByNameAndFound() {
    expect(dnsService.getManagedZone(ZONE_NAME)).andReturn(managedZoneNoId.info());
    replay(dnsService);
    ManagedZone result = managedZoneNoId.reload();
    assertSame(managedZoneNoId.dnsService(), result.dnsService());
    assertEquals(managedZoneNoId.info(), result.info());
  }

  @Test
  public void reloadByNameAndNotFound() {
    expect(dnsService.getManagedZone(ZONE_NAME)).andReturn(null);
    replay(dnsService);
    ManagedZone result = managedZoneNoId.reload();
    assertNull(result);
  }
}
