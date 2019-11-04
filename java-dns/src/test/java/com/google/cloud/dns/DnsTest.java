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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.dns.spi.v1.DnsRpc;
import org.junit.Test;

public class DnsTest {

  private static final Integer PAGE_SIZE = 20;
  private static final String PAGE_TOKEN = "page token";
  private static final String DNS_NAME = "www.example.com.";

  @Test
  public void testRecordSetListOption() {
    // dns name
    String dnsName = "some name";
    Dns.RecordSetListOption recordSetListOption = Dns.RecordSetListOption.dnsName(dnsName);
    assertEquals(dnsName, recordSetListOption.getValue());
    assertEquals(DnsRpc.Option.NAME, recordSetListOption.getRpcOption());
    // page token
    recordSetListOption = Dns.RecordSetListOption.pageToken(PAGE_TOKEN);
    assertEquals(PAGE_TOKEN, recordSetListOption.getValue());
    assertEquals(DnsRpc.Option.PAGE_TOKEN, recordSetListOption.getRpcOption());
    // page size
    recordSetListOption = Dns.RecordSetListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, recordSetListOption.getValue());
    assertEquals(DnsRpc.Option.PAGE_SIZE, recordSetListOption.getRpcOption());
    // record type
    RecordSet.Type recordType = RecordSet.Type.AAAA;
    recordSetListOption = Dns.RecordSetListOption.type(recordType);
    assertEquals(recordType.name(), recordSetListOption.getValue());
    assertEquals(DnsRpc.Option.DNS_TYPE, recordSetListOption.getRpcOption());
    // fields
    recordSetListOption =
        Dns.RecordSetListOption.fields(Dns.RecordSetField.NAME, Dns.RecordSetField.TTL);
    assertEquals(DnsRpc.Option.FIELDS, recordSetListOption.getRpcOption());
    assertTrue(recordSetListOption.getValue() instanceof String);
    assertTrue(
        ((String) recordSetListOption.getValue()).contains(Dns.RecordSetField.NAME.getSelector()));
    assertTrue(
        ((String) recordSetListOption.getValue()).contains(Dns.RecordSetField.TTL.getSelector()));
    assertTrue(
        ((String) recordSetListOption.getValue()).contains(Dns.RecordSetField.NAME.getSelector()));
  }

  @Test
  public void testZoneOption() {
    Dns.ZoneOption fields =
        Dns.ZoneOption.fields(Dns.ZoneField.CREATION_TIME, Dns.ZoneField.DESCRIPTION);
    assertEquals(DnsRpc.Option.FIELDS, fields.getRpcOption());
    assertTrue(fields.getValue() instanceof String);
    assertTrue(((String) fields.getValue()).contains(Dns.ZoneField.CREATION_TIME.getSelector()));
    assertTrue(((String) fields.getValue()).contains(Dns.ZoneField.DESCRIPTION.getSelector()));
  }

  @Test
  public void testZoneList() {
    // fields
    Dns.ZoneListOption fields =
        Dns.ZoneListOption.fields(Dns.ZoneField.CREATION_TIME, Dns.ZoneField.DESCRIPTION);
    assertEquals(DnsRpc.Option.FIELDS, fields.getRpcOption());
    assertTrue(fields.getValue() instanceof String);
    assertTrue(((String) fields.getValue()).contains(Dns.ZoneField.CREATION_TIME.getSelector()));
    assertTrue(((String) fields.getValue()).contains(Dns.ZoneField.DESCRIPTION.getSelector()));
    assertTrue(((String) fields.getValue()).contains(Dns.ZoneField.NAME.getSelector()));
    // page token
    Dns.ZoneListOption option = Dns.ZoneListOption.pageToken(PAGE_TOKEN);
    assertEquals(PAGE_TOKEN, option.getValue());
    assertEquals(DnsRpc.Option.PAGE_TOKEN, option.getRpcOption());
    // page size
    option = Dns.ZoneListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, option.getValue());
    assertEquals(DnsRpc.Option.PAGE_SIZE, option.getRpcOption());
    // dnsName filter
    option = Dns.ZoneListOption.dnsName(DNS_NAME);
    assertEquals(DNS_NAME, option.getValue());
    assertEquals(DnsRpc.Option.DNS_NAME, option.getRpcOption());
  }

  @Test
  public void testProjectGetOption() {
    // fields
    Dns.ProjectOption fields = Dns.ProjectOption.fields(Dns.ProjectField.QUOTA);
    assertEquals(DnsRpc.Option.FIELDS, fields.getRpcOption());
    assertTrue(fields.getValue() instanceof String);
    assertTrue(((String) fields.getValue()).contains(Dns.ProjectField.QUOTA.getSelector()));
    assertTrue(((String) fields.getValue()).contains(Dns.ProjectField.PROJECT_ID.getSelector()));
  }

  @Test
  public void testChangeRequestOption() {
    // fields
    Dns.ChangeRequestOption fields =
        Dns.ChangeRequestOption.fields(
            Dns.ChangeRequestField.START_TIME, Dns.ChangeRequestField.STATUS);
    assertEquals(DnsRpc.Option.FIELDS, fields.getRpcOption());
    assertTrue(fields.getValue() instanceof String);
    assertTrue(
        ((String) fields.getValue()).contains(Dns.ChangeRequestField.START_TIME.getSelector()));
    assertTrue(((String) fields.getValue()).contains(Dns.ChangeRequestField.STATUS.getSelector()));
    assertTrue(((String) fields.getValue()).contains(Dns.ChangeRequestField.ID.getSelector()));
  }

  @Test
  public void testChangeRequestListOption() {
    // fields
    Dns.ChangeRequestListOption fields =
        Dns.ChangeRequestListOption.fields(
            Dns.ChangeRequestField.START_TIME, Dns.ChangeRequestField.STATUS);
    assertEquals(DnsRpc.Option.FIELDS, fields.getRpcOption());
    assertTrue(fields.getValue() instanceof String);
    assertTrue(
        ((String) fields.getValue()).contains(Dns.ChangeRequestField.START_TIME.getSelector()));
    assertTrue(((String) fields.getValue()).contains(Dns.ChangeRequestField.STATUS.getSelector()));
    assertTrue(((String) fields.getValue()).contains(Dns.ChangeRequestField.ID.getSelector()));
    // page token
    Dns.ChangeRequestListOption option = Dns.ChangeRequestListOption.pageToken(PAGE_TOKEN);
    assertEquals(PAGE_TOKEN, option.getValue());
    assertEquals(DnsRpc.Option.PAGE_TOKEN, option.getRpcOption());
    // page size
    option = Dns.ChangeRequestListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, option.getValue());
    assertEquals(DnsRpc.Option.PAGE_SIZE, option.getRpcOption());
    // sort order
    option = Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING);
    assertEquals(DnsRpc.Option.SORTING_ORDER, option.getRpcOption());
    assertEquals(Dns.SortingOrder.ASCENDING.selector(), option.getValue());
  }
}
