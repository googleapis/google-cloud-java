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

import com.google.gcloud.spi.DnsRpc;

import org.junit.Test;

public class DnsTest {

  private static final Integer PAGE_SIZE = 20;
  private static final String PAGE_TOKEN = "page token";

  @Test
  public void testDnsRecordListOption() {
    // dns name
    String dnsName = "some name";
    Dns.DnsRecordListOption dnsRecordListOption = Dns.DnsRecordListOption.dnsName(dnsName);
    assertEquals(dnsName, dnsRecordListOption.value());
    assertEquals(DnsRpc.Option.DNS_NAME, dnsRecordListOption.rpcOption());
    // page token
    dnsRecordListOption = Dns.DnsRecordListOption.pageToken(PAGE_TOKEN);
    assertEquals(PAGE_TOKEN, dnsRecordListOption.value());
    assertEquals(DnsRpc.Option.PAGE_TOKEN, dnsRecordListOption.rpcOption());
    // page size
    dnsRecordListOption = Dns.DnsRecordListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, dnsRecordListOption.value());
    assertEquals(DnsRpc.Option.PAGE_SIZE, dnsRecordListOption.rpcOption());
    // record type
    DnsRecord.Type recordType = DnsRecord.Type.AAAA;
    dnsRecordListOption = Dns.DnsRecordListOption.type(recordType);
    assertEquals(recordType, dnsRecordListOption.value());
    assertEquals(DnsRpc.Option.DNS_TYPE, dnsRecordListOption.rpcOption());
    // fields
    dnsRecordListOption = Dns.DnsRecordListOption.fields(Dns.DnsRecordField.NAME,
        Dns.DnsRecordField.TTL);
    assertEquals(DnsRpc.Option.FIELDS, dnsRecordListOption.rpcOption());
    assertTrue(dnsRecordListOption.value() instanceof String);
    assertTrue(((String) dnsRecordListOption.value()).contains(
        Dns.DnsRecordField.NAME.selector()));
    assertTrue(((String) dnsRecordListOption.value()).contains(
        Dns.DnsRecordField.TTL.selector()));
    assertTrue(((String) dnsRecordListOption.value()).contains(
        Dns.DnsRecordField.NAME.selector()));
  }

  @Test
  public void testZoneOption() {
    Dns.ZoneOption fields = Dns.ZoneOption.fields(Dns.ZoneField.CREATION_TIME,
        Dns.ZoneField.DESCRIPTION);
    assertEquals(DnsRpc.Option.FIELDS, fields.rpcOption());
    assertTrue(fields.value() instanceof String);
    assertTrue(((String) fields.value()).contains(Dns.ZoneField.CREATION_TIME.selector()));
    assertTrue(((String) fields.value()).contains(Dns.ZoneField.DESCRIPTION.selector()));
  }

  @Test
  public void testZoneList() {
    // fields
    Dns.ZoneListOption fields = Dns.ZoneListOption.fields(Dns.ZoneField.CREATION_TIME,
        Dns.ZoneField.DESCRIPTION);
    assertEquals(DnsRpc.Option.FIELDS, fields.rpcOption());
    assertTrue(fields.value() instanceof String);
    assertTrue(((String) fields.value()).contains(Dns.ZoneField.CREATION_TIME.selector()));
    assertTrue(((String) fields.value()).contains(Dns.ZoneField.DESCRIPTION.selector()));
    assertTrue(((String) fields.value()).contains(Dns.ZoneField.ZONE_ID.selector()));
    // page token
    Dns.ZoneListOption option = Dns.ZoneListOption.pageToken(PAGE_TOKEN);
    assertEquals(PAGE_TOKEN, option.value());
    assertEquals(DnsRpc.Option.PAGE_TOKEN, option.rpcOption());
    // page size
    option = Dns.ZoneListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, option.value());
    assertEquals(DnsRpc.Option.PAGE_SIZE, option.rpcOption());
  }

  @Test
  public void testProjectGetOption() {
    // fields
    Dns.ProjectGetOption fields = Dns.ProjectGetOption.fields(Dns.ProjectField.QUOTA);
    assertEquals(DnsRpc.Option.FIELDS, fields.rpcOption());
    assertTrue(fields.value() instanceof String);
    assertTrue(((String) fields.value()).contains(Dns.ProjectField.QUOTA.selector()));
    assertTrue(((String) fields.value()).contains(Dns.ProjectField.PROJECT_ID.selector()));
  }

  @Test
  public void testChangeRequestOption() {
    // fields
    Dns.ChangeRequestOption fields = Dns.ChangeRequestOption.fields(
        Dns.ChangeRequestField.START_TIME, Dns.ChangeRequestField.STATUS);
    assertEquals(DnsRpc.Option.FIELDS, fields.rpcOption());
    assertTrue(fields.value() instanceof String);
    assertTrue(((String) fields.value()).contains(
        Dns.ChangeRequestField.START_TIME.selector()));
    assertTrue(((String) fields.value()).contains(Dns.ChangeRequestField.STATUS.selector()));
    assertTrue(((String) fields.value()).contains(Dns.ChangeRequestField.ID.selector()));
  }

  @Test
  public void testChangeRequestListOption() {
    // fields
    Dns.ChangeRequestListOption fields = Dns.ChangeRequestListOption.fields(
        Dns.ChangeRequestField.START_TIME, Dns.ChangeRequestField.STATUS);
    assertEquals(DnsRpc.Option.FIELDS, fields.rpcOption());
    assertTrue(fields.value() instanceof String);
    assertTrue(((String) fields.value()).contains(
        Dns.ChangeRequestField.START_TIME.selector()));
    assertTrue(((String) fields.value()).contains(Dns.ChangeRequestField.STATUS.selector()));
    assertTrue(((String) fields.value()).contains(Dns.ChangeRequestField.ID.selector()));
    // page token
    Dns.ChangeRequestListOption option = Dns.ChangeRequestListOption.pageToken(PAGE_TOKEN);
    assertEquals(PAGE_TOKEN, option.value());
    assertEquals(DnsRpc.Option.PAGE_TOKEN, option.rpcOption());
    // page size
    option = Dns.ChangeRequestListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, option.value());
    assertEquals(DnsRpc.Option.PAGE_SIZE, option.rpcOption());
    // sort order
    option = Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING);
    assertEquals(DnsRpc.Option.SORTING_ORDER, option.rpcOption());
    assertEquals(Dns.SortingOrder.ASCENDING.selector(), option.value());
  }
}
