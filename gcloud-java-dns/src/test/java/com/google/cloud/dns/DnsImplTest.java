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

package com.google.cloud.dns;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.cloud.Clock;
import com.google.cloud.Page;
import com.google.cloud.RetryParams;
import com.google.cloud.dns.spi.DnsRpc;
import com.google.cloud.dns.spi.DnsRpcFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class DnsImplTest {

  // Dns entities
  private static final String ZONE_NAME = "some zone name";
  private static final String DNS_NAME = "example.com.";
  private static final String DESCRIPTION = "desc";
  private static final String CHANGE_ID = "some change id";
  private static final RecordSet DNS_RECORD1 =
      RecordSet.builder("Something", RecordSet.Type.AAAA).build();
  private static final RecordSet DNS_RECORD2 =
      RecordSet.builder("Different", RecordSet.Type.AAAA).build();
  private static final Integer MAX_SIZE = 20;
  private static final String PAGE_TOKEN = "some token";
  private static final ZoneInfo ZONE_INFO = ZoneInfo.of(ZONE_NAME, DNS_NAME, DESCRIPTION);
  private static final ProjectInfo PROJECT_INFO = ProjectInfo.builder().build();
  private static final ChangeRequestInfo CHANGE_REQUEST_PARTIAL = ChangeRequestInfo.builder()
      .add(DNS_RECORD1)
      .build();
  private static final ChangeRequestInfo CHANGE_REQUEST_COMPLETE = ChangeRequestInfo.builder()
      .add(DNS_RECORD1)
      .startTimeMillis(123L)
      .status(ChangeRequest.Status.PENDING)
      .generatedId(CHANGE_ID)
      .build();

  // Result lists
  private static final DnsRpc.ListResult<Change> LIST_RESULT_OF_PB_CHANGES =
      DnsRpc.ListResult.of("cursor", ImmutableList.of(CHANGE_REQUEST_COMPLETE.toPb(),
          CHANGE_REQUEST_PARTIAL.toPb()));
  private static final DnsRpc.ListResult<ManagedZone> LIST_RESULT_OF_PB_ZONES =
      DnsRpc.ListResult.of("cursor", ImmutableList.of(ZONE_INFO.toPb()));
  private static final DnsRpc.ListResult<ResourceRecordSet> LIST_OF_PB_DNS_RECORDS =
      DnsRpc.ListResult.of("cursor", ImmutableList.of(DNS_RECORD1.toPb(), DNS_RECORD2.toPb()));

  // Field options
  private static final Dns.ZoneOption ZONE_FIELDS =
      Dns.ZoneOption.fields(Dns.ZoneField.CREATION_TIME);
  private static final Dns.ProjectOption PROJECT_FIELDS =
      Dns.ProjectOption.fields(Dns.ProjectField.QUOTA);
  private static final Dns.ChangeRequestOption CHANGE_GET_FIELDS =
      Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS);

  // Listing options
  private static final Dns.ZoneListOption[] ZONE_LIST_OPTIONS = {
      Dns.ZoneListOption.pageSize(MAX_SIZE), Dns.ZoneListOption.pageToken(PAGE_TOKEN),
      Dns.ZoneListOption.fields(Dns.ZoneField.DESCRIPTION),
      Dns.ZoneListOption.dnsName(DNS_NAME)};
  private static final Dns.ChangeRequestListOption[] CHANGE_LIST_OPTIONS = {
      Dns.ChangeRequestListOption.pageSize(MAX_SIZE),
      Dns.ChangeRequestListOption.pageToken(PAGE_TOKEN),
      Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.STATUS),
      Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING)};
  private static final Dns.RecordSetListOption[] RECORD_SET_LIST_OPTIONS = {
      Dns.RecordSetListOption.pageSize(MAX_SIZE),
      Dns.RecordSetListOption.pageToken(PAGE_TOKEN),
      Dns.RecordSetListOption.fields(Dns.RecordSetField.TTL),
      Dns.RecordSetListOption.dnsName(DNS_NAME),
      Dns.RecordSetListOption.type(RecordSet.Type.AAAA)};

  // Other
  private static final Map<DnsRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();
  private static final Clock TIME_SOURCE = new Clock() {
    @Override
    public long millis() {
      return 42000L;
    }
  };

  private DnsOptions options;
  private DnsRpcFactory rpcFactoryMock;
  private DnsRpc dnsRpcMock;
  private Dns dns;

  @Before
  public void setUp() {
    rpcFactoryMock = EasyMock.createMock(DnsRpcFactory.class);
    dnsRpcMock = EasyMock.createMock(DnsRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(DnsOptions.class)))
        .andReturn(dnsRpcMock);
    EasyMock.replay(rpcFactoryMock);
    options = DnsOptions.builder()
        .projectId("projectId")
        .clock(TIME_SOURCE)
        .serviceRpcFactory(rpcFactoryMock)
        .retryParams(RetryParams.noRetries())
        .build();
  }

  @After
  public void tearDown() throws Exception {
    EasyMock.verify(rpcFactoryMock);
  }

  @Test
  public void testCreateZone() {
    EasyMock.expect(dnsRpcMock.create(ZONE_INFO.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(ZONE_INFO.toPb());
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    Zone zone = dns.create(ZONE_INFO);
    assertEquals(new Zone(dns, new ZoneInfo.BuilderImpl(ZONE_INFO)), zone);
  }

  @Test
  public void testCreateZoneWithOptions() {
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(dnsRpcMock.create(EasyMock.eq(ZONE_INFO.toPb()),
        EasyMock.capture(capturedOptions))).andReturn(ZONE_INFO.toPb());
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    Zone zone = dns.create(ZONE_INFO, ZONE_FIELDS);
    String selector = (String) capturedOptions.getValue().get(ZONE_FIELDS.rpcOption());
    assertEquals(new Zone(dns, new ZoneInfo.BuilderImpl(ZONE_INFO)), zone);
    assertTrue(selector.contains(Dns.ZoneField.CREATION_TIME.selector()));
    assertTrue(selector.contains(Dns.ZoneField.NAME.selector()));
  }

  @Test
  public void testGetZone() {
    EasyMock.expect(dnsRpcMock.getZone(ZONE_INFO.name(), EMPTY_RPC_OPTIONS))
        .andReturn(ZONE_INFO.toPb());
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    Zone zone = dns.getZone(ZONE_INFO.name());
    assertEquals(new Zone(dns, new ZoneInfo.BuilderImpl(ZONE_INFO)), zone);
  }

  @Test
  public void testGetZoneWithOptions() {
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(dnsRpcMock.getZone(EasyMock.eq(ZONE_INFO.name()),
        EasyMock.capture(capturedOptions))).andReturn(ZONE_INFO.toPb());
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    Zone zone = dns.getZone(ZONE_INFO.name(), ZONE_FIELDS);
    String selector = (String) capturedOptions.getValue().get(ZONE_FIELDS.rpcOption());
    assertEquals(new Zone(dns, new ZoneInfo.BuilderImpl(ZONE_INFO)), zone);
    assertTrue(selector.contains(Dns.ZoneField.CREATION_TIME.selector()));
    assertTrue(selector.contains(Dns.ZoneField.NAME.selector()));
  }

  @Test
  public void testDeleteZone() {
    EasyMock.expect(dnsRpcMock.deleteZone(ZONE_INFO.name()))
        .andReturn(true);
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    assertTrue(dns.delete(ZONE_INFO.name()));
  }

  @Test
  public void testGetProject() {
    EasyMock.expect(dnsRpcMock.getProject(EMPTY_RPC_OPTIONS))
        .andReturn(PROJECT_INFO.toPb());
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    ProjectInfo projectInfo = dns.getProject();
    assertEquals(PROJECT_INFO, projectInfo);
  }

  @Test
  public void testProjectGetWithOptions() {
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(dnsRpcMock.getProject(EasyMock.capture(capturedOptions)))
        .andReturn(PROJECT_INFO.toPb());
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    ProjectInfo projectInfo = dns.getProject(PROJECT_FIELDS);
    String selector = (String) capturedOptions.getValue().get(PROJECT_FIELDS.rpcOption());
    assertEquals(PROJECT_INFO, projectInfo);
    assertTrue(selector.contains(Dns.ProjectField.QUOTA.selector()));
    assertTrue(selector.contains(Dns.ProjectField.PROJECT_ID.selector()));
  }

  @Test
  public void testGetChangeRequest() {
    EasyMock.expect(dnsRpcMock.getChangeRequest(ZONE_INFO.name(),
        CHANGE_REQUEST_COMPLETE.generatedId(), EMPTY_RPC_OPTIONS))
        .andReturn(CHANGE_REQUEST_COMPLETE.toPb());
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    ChangeRequest changeRequest = dns.getChangeRequest(ZONE_INFO.name(),
        CHANGE_REQUEST_COMPLETE.generatedId());
    assertEquals(new ChangeRequest(dns, ZONE_INFO.name(),
        new ChangeRequestInfo.BuilderImpl(CHANGE_REQUEST_COMPLETE)), changeRequest);
  }

  @Test
  public void testGetChangeRequestWithOptions() {
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(dnsRpcMock.getChangeRequest(EasyMock.eq(ZONE_INFO.name()),
        EasyMock.eq(CHANGE_REQUEST_COMPLETE.generatedId()), EasyMock.capture(capturedOptions)))
        .andReturn(CHANGE_REQUEST_COMPLETE.toPb());
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    ChangeRequest changeRequest = dns.getChangeRequest(ZONE_INFO.name(),
        CHANGE_REQUEST_COMPLETE.generatedId(), CHANGE_GET_FIELDS);
    String selector = (String) capturedOptions.getValue().get(CHANGE_GET_FIELDS.rpcOption());
    assertEquals(new ChangeRequest(dns, ZONE_INFO.name(),
        new ChangeRequestInfo.BuilderImpl(CHANGE_REQUEST_COMPLETE)), changeRequest);
    assertTrue(selector.contains(Dns.ChangeRequestField.STATUS.selector()));
    assertTrue(selector.contains(Dns.ChangeRequestField.ID.selector()));
  }

  @Test
  public void testApplyChangeRequest() {
    EasyMock.expect(dnsRpcMock.applyChangeRequest(ZONE_INFO.name(), CHANGE_REQUEST_PARTIAL.toPb(),
        EMPTY_RPC_OPTIONS)).andReturn(CHANGE_REQUEST_COMPLETE.toPb());
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    ChangeRequest changeRequest = dns.applyChangeRequest(ZONE_INFO.name(),
        CHANGE_REQUEST_PARTIAL);
    assertEquals(new ChangeRequest(dns, ZONE_INFO.name(),
        new ChangeRequestInfo.BuilderImpl(CHANGE_REQUEST_COMPLETE)), changeRequest);
  }

  @Test
  public void testApplyChangeRequestWithOptions() {
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(dnsRpcMock.applyChangeRequest(EasyMock.eq(ZONE_INFO.name()),
        EasyMock.eq(CHANGE_REQUEST_PARTIAL.toPb()), EasyMock.capture(capturedOptions)))
        .andReturn(CHANGE_REQUEST_COMPLETE.toPb());
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    ChangeRequest changeRequest = dns.applyChangeRequest(ZONE_INFO.name(),
        CHANGE_REQUEST_PARTIAL, CHANGE_GET_FIELDS);
    String selector = (String) capturedOptions.getValue().get(CHANGE_GET_FIELDS.rpcOption());
    assertEquals(new ChangeRequest(dns, ZONE_INFO.name(),
        new ChangeRequestInfo.BuilderImpl(CHANGE_REQUEST_COMPLETE)), changeRequest);
    assertTrue(selector.contains(Dns.ChangeRequestField.STATUS.selector()));
    assertTrue(selector.contains(Dns.ChangeRequestField.ID.selector()));
  }

  // lists
  @Test
  public void testListChangeRequests() {
    EasyMock.expect(dnsRpcMock.listChangeRequests(ZONE_INFO.name(), EMPTY_RPC_OPTIONS))
        .andReturn(LIST_RESULT_OF_PB_CHANGES);
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    Page<ChangeRequest> changeRequestPage = dns.listChangeRequests(ZONE_INFO.name());
    assertTrue(Lists.newArrayList(changeRequestPage.values()).contains(
        new ChangeRequest(dns, ZONE_INFO.name(),
            new ChangeRequestInfo.BuilderImpl(CHANGE_REQUEST_COMPLETE))));
    assertTrue(Lists.newArrayList(changeRequestPage.values()).contains(
        new ChangeRequest(dns, ZONE_INFO.name(),
            new ChangeRequestInfo.BuilderImpl(CHANGE_REQUEST_PARTIAL))));
    assertEquals(2, Lists.newArrayList(changeRequestPage.values()).size());
  }

  @Test
  public void testListChangeRequestsWithOptions() {
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(dnsRpcMock.listChangeRequests(EasyMock.eq(ZONE_NAME),
        EasyMock.capture(capturedOptions))).andReturn(LIST_RESULT_OF_PB_CHANGES);
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    Page<ChangeRequest> changeRequestPage = dns.listChangeRequests(ZONE_NAME, CHANGE_LIST_OPTIONS);
    assertTrue(Lists.newArrayList(changeRequestPage.values()).contains(
        new ChangeRequest(dns, ZONE_INFO.name(),
            new ChangeRequestInfo.BuilderImpl(CHANGE_REQUEST_COMPLETE))));
    assertTrue(Lists.newArrayList(changeRequestPage.values()).contains(
        new ChangeRequest(dns, ZONE_INFO.name(),
            new ChangeRequestInfo.BuilderImpl(CHANGE_REQUEST_PARTIAL))));
    assertEquals(2, Lists.newArrayList(changeRequestPage.values()).size());
    Integer size = (Integer) capturedOptions.getValue().get(CHANGE_LIST_OPTIONS[0].rpcOption());
    assertEquals(MAX_SIZE, size);
    String selector = (String) capturedOptions.getValue().get(CHANGE_LIST_OPTIONS[1].rpcOption());
    assertEquals(PAGE_TOKEN, selector);
    selector = (String) capturedOptions.getValue().get(CHANGE_LIST_OPTIONS[2].rpcOption());
    assertTrue(selector.contains(Dns.ChangeRequestField.STATUS.selector()));
    assertTrue(selector.contains(Dns.ChangeRequestField.ID.selector()));
    selector = (String) capturedOptions.getValue().get(CHANGE_LIST_OPTIONS[3].rpcOption());
    assertTrue(selector.contains(Dns.SortingOrder.ASCENDING.selector()));
  }

  @Test
  public void testListZones() {
    EasyMock.expect(dnsRpcMock.listZones(EMPTY_RPC_OPTIONS))
        .andReturn(LIST_RESULT_OF_PB_ZONES);
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    Page<Zone> zonePage = dns.listZones();
    assertEquals(1, Lists.newArrayList(zonePage.values()).size());
    assertEquals(new Zone(dns, new ZoneInfo.BuilderImpl(ZONE_INFO)),
        Lists.newArrayList(zonePage.values()).get(0));
  }

  @Test
  public void testListZonesWithOptions() {
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(dnsRpcMock.listZones(EasyMock.capture(capturedOptions)))
        .andReturn(LIST_RESULT_OF_PB_ZONES);
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    Page<Zone> zonePage = dns.listZones(ZONE_LIST_OPTIONS);
    assertEquals(1, Lists.newArrayList(zonePage.values()).size());
    assertEquals(new Zone(dns, new ZoneInfo.BuilderImpl(ZONE_INFO)),
        Lists.newArrayList(zonePage.values()).get(0));
    Integer size = (Integer) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[0].rpcOption());
    assertEquals(MAX_SIZE, size);
    String selector = (String) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[1].rpcOption());
    assertEquals(PAGE_TOKEN, selector);
    selector = (String) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[2].rpcOption());
    assertTrue(selector.contains(Dns.ZoneField.DESCRIPTION.selector()));
    assertTrue(selector.contains(Dns.ZoneField.NAME.selector()));
    selector = (String) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[3].rpcOption());
    assertEquals(DNS_NAME, selector);
  }

  @Test
  public void testListRecordSets() {
    EasyMock.expect(dnsRpcMock.listRecordSets(ZONE_INFO.name(), EMPTY_RPC_OPTIONS))
        .andReturn(LIST_OF_PB_DNS_RECORDS);
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    Page<RecordSet> dnsPage = dns.listRecordSets(ZONE_INFO.name());
    assertEquals(2, Lists.newArrayList(dnsPage.values()).size());
    assertTrue(Lists.newArrayList(dnsPage.values()).contains(DNS_RECORD1));
    assertTrue(Lists.newArrayList(dnsPage.values()).contains(DNS_RECORD2));
  }

  @Test
  public void testListRecordSetsWithOptions() {
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(dnsRpcMock.listRecordSets(EasyMock.eq(ZONE_NAME),
        EasyMock.capture(capturedOptions))).andReturn(LIST_OF_PB_DNS_RECORDS);
    EasyMock.replay(dnsRpcMock);
    dns = options.service(); // creates DnsImpl
    Page<RecordSet> dnsPage = dns.listRecordSets(ZONE_NAME, RECORD_SET_LIST_OPTIONS);
    assertEquals(2, Lists.newArrayList(dnsPage.values()).size());
    assertTrue(Lists.newArrayList(dnsPage.values()).contains(DNS_RECORD1));
    assertTrue(Lists.newArrayList(dnsPage.values()).contains(DNS_RECORD2));
    Integer size = (Integer) capturedOptions.getValue().get(RECORD_SET_LIST_OPTIONS[0].rpcOption());
    assertEquals(MAX_SIZE, size);
    String selector = (String) capturedOptions.getValue()
        .get(RECORD_SET_LIST_OPTIONS[1].rpcOption());
    assertEquals(PAGE_TOKEN, selector);
    selector = (String) capturedOptions.getValue().get(RECORD_SET_LIST_OPTIONS[2].rpcOption());
    assertTrue(selector.contains(Dns.RecordSetField.NAME.selector()));
    assertTrue(selector.contains(Dns.RecordSetField.TTL.selector()));
    selector = (String) capturedOptions.getValue().get(RECORD_SET_LIST_OPTIONS[3].rpcOption());
    assertEquals(RECORD_SET_LIST_OPTIONS[3].value(), selector);
    String type = (String) capturedOptions.getValue().get(RECORD_SET_LIST_OPTIONS[4]
        .rpcOption());
    assertEquals(RECORD_SET_LIST_OPTIONS[4].value(), type);
  }
}
