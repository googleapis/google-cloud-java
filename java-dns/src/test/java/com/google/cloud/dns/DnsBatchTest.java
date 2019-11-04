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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.gax.paging.Page;
import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ChangesListResponse;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ManagedZonesListResponse;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.api.services.dns.model.ResourceRecordSetsListResponse;
import com.google.cloud.dns.spi.v1.DnsRpc;
import com.google.cloud.dns.spi.v1.RpcBatch;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DnsBatchTest {

  private static final String ZONE_NAME = "somezonename";
  private static final String DNS_NAME = "example.com.";
  private static final String DESCRIPTION = "desc";
  private static final Integer MAX_SIZE = 20;
  private static final String PAGE_TOKEN = "some token";

  private static final ZoneInfo ZONE_INFO = ZoneInfo.of(ZONE_NAME, DNS_NAME, DESCRIPTION);
  private static final Dns.ZoneOption ZONE_FIELDS =
      Dns.ZoneOption.fields(Dns.ZoneField.CREATION_TIME);
  private static final Dns.ProjectOption PROJECT_FIELDS =
      Dns.ProjectOption.fields(Dns.ProjectField.QUOTA);
  private static final Dns.ZoneListOption[] ZONE_LIST_OPTIONS = {
    Dns.ZoneListOption.pageSize(MAX_SIZE),
    Dns.ZoneListOption.pageToken(PAGE_TOKEN),
    Dns.ZoneListOption.fields(Dns.ZoneField.DESCRIPTION),
    Dns.ZoneListOption.dnsName(DNS_NAME)
  };
  private static final ProjectInfo PROJECT_INFO = ProjectInfo.newBuilder().build();
  private static final Dns.RecordSetListOption[] RECORD_SET_LIST_OPTIONS = {
    Dns.RecordSetListOption.pageSize(MAX_SIZE),
    Dns.RecordSetListOption.pageToken(PAGE_TOKEN),
    Dns.RecordSetListOption.fields(Dns.RecordSetField.TTL),
    Dns.RecordSetListOption.dnsName(DNS_NAME),
    Dns.RecordSetListOption.type(RecordSet.Type.AAAA)
  };
  private static final RecordSet RECORD_SET =
      RecordSet.newBuilder("Something", RecordSet.Type.AAAA).build();
  private static final ChangeRequestInfo CHANGE_REQUEST_PARTIAL =
      ChangeRequestInfo.newBuilder().add(RECORD_SET).build();
  private static final String CHANGE_ID = "some change id";
  private static final ChangeRequestInfo CHANGE_REQUEST_COMPLETE =
      ChangeRequestInfo.newBuilder()
          .add(RECORD_SET)
          .setStartTime(123L)
          .setStatus(ChangeRequest.Status.PENDING)
          .setGeneratedId(CHANGE_ID)
          .build();
  private static final Dns.ChangeRequestListOption[] CHANGE_LIST_OPTIONS = {
    Dns.ChangeRequestListOption.pageSize(MAX_SIZE),
    Dns.ChangeRequestListOption.pageToken(PAGE_TOKEN),
    Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.STATUS),
    Dns.ChangeRequestListOption.sortOrder(Dns.SortingOrder.ASCENDING)
  };
  private static final Dns.ChangeRequestOption CHANGE_GET_FIELDS =
      Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS);
  private static final List<ResourceRecordSet> RECORD_SET_LIST =
      ImmutableList.of(RECORD_SET.toPb(), RECORD_SET.toPb(), RECORD_SET.toPb(), RECORD_SET.toPb());
  private static final List<Change> CHANGE_LIST =
      ImmutableList.of(
          CHANGE_REQUEST_COMPLETE.toPb(),
          CHANGE_REQUEST_COMPLETE.toPb(),
          CHANGE_REQUEST_COMPLETE.toPb());
  private static final List<ManagedZone> ZONE_LIST =
      ImmutableList.of(ZONE_INFO.toPb(), ZONE_INFO.toPb());
  private static final GoogleJsonError GOOGLE_JSON_ERROR = new GoogleJsonError();

  private DnsOptions optionsMock;
  private DnsRpc dnsRpcMock;
  private RpcBatch batchMock;
  private DnsBatch dnsBatch;
  private final Dns dns = EasyMock.createStrictMock(Dns.class);

  @Before
  public void setUp() {
    optionsMock = EasyMock.createMock(DnsOptions.class);
    dnsRpcMock = EasyMock.createMock(DnsRpc.class);
    batchMock = EasyMock.createMock(RpcBatch.class);
    EasyMock.expect(optionsMock.getDnsRpcV1()).andReturn(dnsRpcMock);
    EasyMock.expect(dnsRpcMock.createBatch()).andReturn(batchMock);
    EasyMock.replay(optionsMock, dnsRpcMock, batchMock, dns);
    dnsBatch = new DnsBatch(optionsMock);
  }

  @After
  public void tearDown() {
    EasyMock.verify(batchMock, dnsRpcMock, optionsMock, dns);
  }

  @Test
  public void testConstructor() {
    assertSame(batchMock, dnsBatch.getBatch());
    assertSame(optionsMock, dnsBatch.getOptions());
    assertSame(dnsRpcMock, dnsBatch.getDnsRpc());
  }

  @Test
  public void testListZones() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<ManagedZonesListResponse>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addListZones(EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<Page<Zone>> batchResult = dnsBatch.listZones();
    assertEquals(0, capturedOptions.getValue().size());
    assertNotNull(callback.getValue());
    try {
      batchResult.get();
      fail("No result available yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    RpcBatch.Callback<ManagedZonesListResponse> capturedCallback = callback.getValue();
    capturedCallback.onFailure(GOOGLE_JSON_ERROR);
    try {
      batchResult.get();
      fail("Should throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testListZonesWithOptions() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<ManagedZonesListResponse>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addListZones(EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<Page<Zone>> batchResult = dnsBatch.listZones(ZONE_LIST_OPTIONS);
    assertNotNull(callback.getValue());
    Integer size = (Integer) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[0].getRpcOption());
    assertEquals(MAX_SIZE, size);
    String selector = (String) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[1].getRpcOption());
    assertEquals(PAGE_TOKEN, selector);
    selector = (String) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[2].getRpcOption());
    assertTrue(selector.contains(Dns.ZoneField.DESCRIPTION.getSelector()));
    assertTrue(selector.contains(Dns.ZoneField.NAME.getSelector()));
    selector = (String) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[3].getRpcOption());
    assertEquals(DNS_NAME, selector);
    // check the callback
    ManagedZonesListResponse response =
        new ManagedZonesListResponse().setManagedZones(ZONE_LIST).setNextPageToken(PAGE_TOKEN);
    RpcBatch.Callback<ManagedZonesListResponse> capturedCallback = callback.getValue();
    EasyMock.verify(optionsMock);
    EasyMock.reset(optionsMock);
    EasyMock.expect(optionsMock.getService()).andReturn(dns).times(ZONE_LIST.size());
    EasyMock.replay(optionsMock);
    capturedCallback.onSuccess(response);
    Page<Zone> page = batchResult.get();
    assertEquals(PAGE_TOKEN, page.getNextPageToken());
    Iterator<Zone> iterator = page.getValues().iterator();
    int resultSize = 0;
    EasyMock.verify(dns);
    EasyMock.reset(dns);
    EasyMock.expect(dns.getOptions()).andReturn(optionsMock).times(ZONE_LIST.size() + 1);
    EasyMock.replay(dns);
    Zone zoneInfoFunctional = new Zone(dns, new ZoneInfo.BuilderImpl(ZONE_INFO));
    while (iterator.hasNext()) {
      assertEquals(zoneInfoFunctional, iterator.next());
      resultSize++;
    }
    assertEquals(ZONE_LIST.size(), resultSize);
  }

  @Test
  public void testCreateZone() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<ManagedZone>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    Capture<ManagedZone> capturedZone = Capture.newInstance();
    batchMock.addCreateZone(
        EasyMock.capture(capturedZone),
        EasyMock.capture(callback),
        EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<Zone> batchResult = dnsBatch.createZone(ZONE_INFO);
    assertEquals(0, capturedOptions.getValue().size());
    assertEquals(ZONE_INFO.toPb(), capturedZone.getValue());
    assertNotNull(callback.getValue());
    try {
      batchResult.get();
      fail("No result available yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    // testing error here, success is tested with options
    RpcBatch.Callback<ManagedZone> capturedCallback = callback.getValue();
    GoogleJsonError error = new GoogleJsonError();
    error.setCode(404);
    capturedCallback.onFailure(error);
    try {
      batchResult.get();
      fail("Should throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testCreateZoneWithOptions() {
    EasyMock.reset(dns, batchMock, optionsMock);
    EasyMock.expect(dns.getOptions()).andReturn(optionsMock);
    EasyMock.expect(optionsMock.getService()).andReturn(dns);
    Capture<RpcBatch.Callback<ManagedZone>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    Capture<ManagedZone> capturedZone = Capture.newInstance();
    batchMock.addCreateZone(
        EasyMock.capture(capturedZone),
        EasyMock.capture(callback),
        EasyMock.capture(capturedOptions));
    EasyMock.replay(dns, batchMock, optionsMock);
    DnsBatchResult<Zone> batchResult = dnsBatch.createZone(ZONE_INFO, ZONE_FIELDS);
    assertEquals(ZONE_INFO.toPb(), capturedZone.getValue());
    assertNotNull(callback.getValue());
    String selector = (String) capturedOptions.getValue().get(ZONE_FIELDS.getRpcOption());
    assertTrue(selector.contains(Dns.ZoneField.CREATION_TIME.getSelector()));
    assertTrue(selector.contains(Dns.ZoneField.NAME.getSelector()));
    RpcBatch.Callback<ManagedZone> capturedCallback = callback.getValue();
    capturedCallback.onSuccess(ZONE_INFO.toPb());
    assertEquals(ZONE_INFO.toPb(), batchResult.get().toPb());
  }

  @Test
  public void testGetZone() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<ManagedZone>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addGetZone(
        EasyMock.eq(ZONE_NAME), EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<Zone> batchResult = dnsBatch.getZone(ZONE_NAME);
    assertEquals(0, capturedOptions.getValue().size());
    assertNotNull(callback.getValue());
    try {
      batchResult.get();
      fail("No result available yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    // testing error here, success is tested with options
    RpcBatch.Callback<ManagedZone> capturedCallback = callback.getValue();
    capturedCallback.onFailure(GOOGLE_JSON_ERROR);
    try {
      batchResult.get();
      fail("Should throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testGetZoneNotFound() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<ManagedZone>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addGetZone(
        EasyMock.eq(ZONE_NAME), EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<Zone> batchResult = dnsBatch.getZone(ZONE_NAME);
    assertEquals(0, capturedOptions.getValue().size());
    GoogleJsonError error = new GoogleJsonError();
    error.setCode(404);
    RpcBatch.Callback<ManagedZone> capturedCallback = callback.getValue();
    capturedCallback.onFailure(error);
    assertNull(batchResult.get());
  }

  @Test
  public void testGetZoneWithOptions() {
    EasyMock.reset(dns, batchMock, optionsMock);
    EasyMock.expect(dns.getOptions()).andReturn(optionsMock);
    Capture<RpcBatch.Callback<ManagedZone>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addGetZone(
        EasyMock.eq(ZONE_NAME), EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.expect(optionsMock.getService()).andReturn(dns);
    EasyMock.replay(dns, batchMock, optionsMock);
    DnsBatchResult<Zone> batchResult = dnsBatch.getZone(ZONE_NAME, ZONE_FIELDS);
    assertNotNull(callback.getValue());
    String selector = (String) capturedOptions.getValue().get(ZONE_FIELDS.getRpcOption());
    assertTrue(selector.contains(Dns.ZoneField.CREATION_TIME.getSelector()));
    assertTrue(selector.contains(Dns.ZoneField.NAME.getSelector()));
    RpcBatch.Callback<ManagedZone> capturedCallback = callback.getValue();
    capturedCallback.onSuccess(ZONE_INFO.toPb());
    assertEquals(ZONE_INFO.toPb(), batchResult.get().toPb());
  }

  @Test
  public void testDeleteZone() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<Void>> callback = Capture.newInstance();
    batchMock.addDeleteZone(EasyMock.eq(ZONE_NAME), EasyMock.capture(callback));
    EasyMock.replay(batchMock);
    DnsBatchResult<Boolean> batchResult = dnsBatch.deleteZone(ZONE_NAME);
    assertNotNull(callback.getValue());
    try {
      batchResult.get();
      fail("No result available yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    // testing error here, success is tested with options
    RpcBatch.Callback<Void> capturedCallback = callback.getValue();
    capturedCallback.onFailure(GOOGLE_JSON_ERROR);
    try {
      batchResult.get();
      fail("Should throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testDeleteZoneOnSuccess() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<Void>> callback = Capture.newInstance();
    batchMock.addDeleteZone(EasyMock.eq(ZONE_NAME), EasyMock.capture(callback));
    EasyMock.replay(batchMock);
    DnsBatchResult<Boolean> batchResult = dnsBatch.deleteZone(ZONE_NAME);
    assertNotNull(callback.getValue());
    RpcBatch.Callback<Void> capturedCallback = callback.getValue();
    Void result = null;
    capturedCallback.onSuccess(result);
    assertTrue(batchResult.get());
  }

  @Test
  public void testGetProject() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<Project>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addGetProject(EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<ProjectInfo> batchResult = dnsBatch.getProject();
    assertEquals(0, capturedOptions.getValue().size());
    assertNotNull(callback.getValue());
    try {
      batchResult.get();
      fail("No result available yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    // testing error here, success is tested with options
    RpcBatch.Callback<Project> capturedCallback = callback.getValue();
    capturedCallback.onFailure(GOOGLE_JSON_ERROR);
    try {
      batchResult.get();
      fail("Should throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testGetProjectWithOptions() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<Project>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addGetProject(EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<ProjectInfo> batchResult = dnsBatch.getProject(PROJECT_FIELDS);
    assertNotNull(callback.getValue());
    String selector = (String) capturedOptions.getValue().get(PROJECT_FIELDS.getRpcOption());
    assertTrue(selector.contains(Dns.ProjectField.QUOTA.getSelector()));
    assertTrue(selector.contains(Dns.ProjectField.PROJECT_ID.getSelector()));
    RpcBatch.Callback<Project> capturedCallback = callback.getValue();
    capturedCallback.onSuccess(PROJECT_INFO.toPb());
    assertEquals(PROJECT_INFO, batchResult.get());
  }

  @Test
  public void testListRecordSets() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<ResourceRecordSetsListResponse>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addListRecordSets(
        EasyMock.eq(ZONE_NAME), EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<Page<RecordSet>> batchResult = dnsBatch.listRecordSets(ZONE_NAME);
    assertEquals(0, capturedOptions.getValue().size());
    assertNotNull(callback.getValue());
    try {
      batchResult.get();
      fail("No result available yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    RpcBatch.Callback<ResourceRecordSetsListResponse> capturedCallback = callback.getValue();
    capturedCallback.onFailure(GOOGLE_JSON_ERROR);
    try {
      batchResult.get();
      fail("Should throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testListRecordSetsWithOptions() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<ResourceRecordSetsListResponse>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addListRecordSets(
        EasyMock.eq(ZONE_NAME), EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<Page<RecordSet>> batchResult =
        dnsBatch.listRecordSets(ZONE_NAME, RECORD_SET_LIST_OPTIONS);
    assertNotNull(callback.getValue());
    Integer size =
        (Integer) capturedOptions.getValue().get(RECORD_SET_LIST_OPTIONS[0].getRpcOption());
    assertEquals(MAX_SIZE, size);
    String selector =
        (String) capturedOptions.getValue().get(RECORD_SET_LIST_OPTIONS[1].getRpcOption());
    assertEquals(PAGE_TOKEN, selector);
    selector = (String) capturedOptions.getValue().get(RECORD_SET_LIST_OPTIONS[2].getRpcOption());
    assertTrue(selector.contains(Dns.RecordSetField.NAME.getSelector()));
    assertTrue(selector.contains(Dns.RecordSetField.TTL.getSelector()));
    selector = (String) capturedOptions.getValue().get(RECORD_SET_LIST_OPTIONS[3].getRpcOption());
    assertEquals(RECORD_SET_LIST_OPTIONS[3].getValue(), selector);
    String type =
        (String) capturedOptions.getValue().get(RECORD_SET_LIST_OPTIONS[4].getRpcOption());
    assertEquals(RECORD_SET_LIST_OPTIONS[4].getValue(), type);
    RpcBatch.Callback<ResourceRecordSetsListResponse> capturedCallback = callback.getValue();
    ResourceRecordSetsListResponse response =
        new ResourceRecordSetsListResponse()
            .setRrsets(RECORD_SET_LIST)
            .setNextPageToken(PAGE_TOKEN);
    capturedCallback.onSuccess(response);
    Page<RecordSet> page = batchResult.get();
    assertEquals(PAGE_TOKEN, page.getNextPageToken());
    Iterator<RecordSet> iterator = page.getValues().iterator();
    int resultSize = 0;
    while (iterator.hasNext()) {
      assertEquals(RECORD_SET, iterator.next());
      resultSize++;
    }
    assertEquals(RECORD_SET_LIST.size(), resultSize);
  }

  @Test
  public void testListChangeRequests() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<ChangesListResponse>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addListChangeRequests(
        EasyMock.eq(ZONE_NAME), EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<Page<ChangeRequest>> batchResult = dnsBatch.listChangeRequests(ZONE_NAME);
    assertNotNull(callback.getValue());
    assertEquals(0, capturedOptions.getValue().size());
    try {
      batchResult.get();
      fail("No result available yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    RpcBatch.Callback<ChangesListResponse> capturedCallback = callback.getValue();
    capturedCallback.onFailure(GOOGLE_JSON_ERROR);
    try {
      batchResult.get();
      fail("Should throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testListChangeRequestsWithOptions() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<ChangesListResponse>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addListChangeRequests(
        EasyMock.eq(ZONE_NAME), EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<Page<ChangeRequest>> batchResult =
        dnsBatch.listChangeRequests(ZONE_NAME, CHANGE_LIST_OPTIONS);
    assertNotNull(callback.getValue());
    Integer size = (Integer) capturedOptions.getValue().get(CHANGE_LIST_OPTIONS[0].getRpcOption());
    assertEquals(MAX_SIZE, size);
    String selector =
        (String) capturedOptions.getValue().get(CHANGE_LIST_OPTIONS[1].getRpcOption());
    assertEquals(PAGE_TOKEN, selector);
    selector = (String) capturedOptions.getValue().get(CHANGE_LIST_OPTIONS[2].getRpcOption());
    assertTrue(selector.contains(Dns.ChangeRequestField.STATUS.getSelector()));
    assertTrue(selector.contains(Dns.ChangeRequestField.ID.getSelector()));
    selector = (String) capturedOptions.getValue().get(CHANGE_LIST_OPTIONS[3].getRpcOption());
    assertTrue(selector.contains(Dns.SortingOrder.ASCENDING.selector()));
    // check the callback
    ChangesListResponse response =
        new ChangesListResponse().setChanges(CHANGE_LIST).setNextPageToken(PAGE_TOKEN);
    RpcBatch.Callback<ChangesListResponse> capturedCallback = callback.getValue();
    EasyMock.verify(optionsMock);
    EasyMock.reset(optionsMock);
    EasyMock.expect(optionsMock.getService()).andReturn(dns);
    EasyMock.replay(optionsMock);
    capturedCallback.onSuccess(response);
    Page<ChangeRequest> page = batchResult.get();
    assertEquals(PAGE_TOKEN, page.getNextPageToken());
    Iterator<ChangeRequest> iterator = page.getValues().iterator();
    int resultSize = 0;
    EasyMock.verify(dns);
    EasyMock.reset(dns);
    EasyMock.expect(dns.getOptions()).andReturn(optionsMock).times(CHANGE_LIST.size());
    EasyMock.replay(dns);
    while (iterator.hasNext()) {
      assertEquals(CHANGE_REQUEST_COMPLETE.toPb(), iterator.next().toPb());
      resultSize++;
    }
    assertEquals(CHANGE_LIST.size(), resultSize);
  }

  @Test
  public void testGetChangeRequest() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<Change>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addGetChangeRequest(
        EasyMock.eq(ZONE_NAME),
        EasyMock.eq(CHANGE_REQUEST_COMPLETE.getGeneratedId()),
        EasyMock.capture(callback),
        EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<ChangeRequest> batchResult =
        dnsBatch.getChangeRequest(ZONE_NAME, CHANGE_REQUEST_COMPLETE.getGeneratedId());
    assertEquals(0, capturedOptions.getValue().size());
    assertNotNull(callback.getValue());
    try {
      batchResult.get();
      fail("No result available yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    // testing error here, success is tested with options
    RpcBatch.Callback<Change> capturedCallback = callback.getValue();
    capturedCallback.onFailure(GOOGLE_JSON_ERROR);
    try {
      batchResult.get();
      fail("Should throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testGetChangeRequestNotFound() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<Change>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addGetChangeRequest(
        EasyMock.eq(ZONE_NAME),
        EasyMock.eq(CHANGE_REQUEST_COMPLETE.getGeneratedId()),
        EasyMock.capture(callback),
        EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<ChangeRequest> batchResult =
        dnsBatch.getChangeRequest(ZONE_NAME, CHANGE_REQUEST_COMPLETE.getGeneratedId());
    assertEquals(0, capturedOptions.getValue().size());
    RpcBatch.Callback<Change> capturedCallback = callback.getValue();
    GoogleJsonError error = new GoogleJsonError();
    GoogleJsonError.ErrorInfo errorInfo = new GoogleJsonError.ErrorInfo();
    errorInfo.setReason("reason");
    errorInfo.setLocation("entity.parameters.changeId");
    error.setCode(404);
    error.setErrors(ImmutableList.of(errorInfo));
    capturedCallback.onFailure(error);
    assertNull(batchResult.get());
  }

  @Test
  public void testGetChangeRequestWithOptions() {
    EasyMock.reset(dns, batchMock, optionsMock);
    EasyMock.expect(dns.getOptions()).andReturn(optionsMock);
    EasyMock.expect(optionsMock.getService()).andReturn(dns);
    Capture<RpcBatch.Callback<Change>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addGetChangeRequest(
        EasyMock.eq(ZONE_NAME),
        EasyMock.eq(CHANGE_REQUEST_COMPLETE.getGeneratedId()),
        EasyMock.capture(callback),
        EasyMock.capture(capturedOptions));
    EasyMock.replay(dns, batchMock, optionsMock);
    DnsBatchResult<ChangeRequest> batchResult =
        dnsBatch.getChangeRequest(
            ZONE_NAME, CHANGE_REQUEST_COMPLETE.getGeneratedId(), CHANGE_GET_FIELDS);
    assertNotNull(callback.getValue());
    String selector = (String) capturedOptions.getValue().get(CHANGE_GET_FIELDS.getRpcOption());
    assertTrue(selector.contains(Dns.ChangeRequestField.STATUS.getSelector()));
    assertTrue(selector.contains(Dns.ChangeRequestField.ID.getSelector()));
    RpcBatch.Callback<Change> capturedCallback = callback.getValue();
    capturedCallback.onSuccess(CHANGE_REQUEST_COMPLETE.toPb());
    assertEquals(CHANGE_REQUEST_COMPLETE.toPb(), batchResult.get().toPb());
  }

  @Test
  public void testApplyChangeRequest() {
    EasyMock.reset(batchMock);
    Capture<RpcBatch.Callback<Change>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addApplyChangeRequest(
        EasyMock.eq(ZONE_NAME),
        EasyMock.eq(CHANGE_REQUEST_PARTIAL.toPb()),
        EasyMock.capture(callback),
        EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<ChangeRequest> batchResult =
        dnsBatch.applyChangeRequest(ZONE_INFO.getName(), CHANGE_REQUEST_PARTIAL);
    assertEquals(0, capturedOptions.getValue().size());
    assertNotNull(callback.getValue());
    try {
      batchResult.get();
      fail("No result available yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    // testing error here, success is tested with options
    RpcBatch.Callback<Change> capturedCallback = callback.getValue();
    GoogleJsonError error = new GoogleJsonError();
    error.setCode(404);
    capturedCallback.onFailure(error);
    try {
      batchResult.get();
      fail("Should throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testApplyChangeRequestWithOptions() {
    EasyMock.reset(dns, batchMock, optionsMock);
    EasyMock.expect(dns.getOptions()).andReturn(optionsMock);
    Capture<RpcBatch.Callback<Change>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addApplyChangeRequest(
        EasyMock.eq(ZONE_NAME),
        EasyMock.eq(CHANGE_REQUEST_PARTIAL.toPb()),
        EasyMock.capture(callback),
        EasyMock.capture(capturedOptions));
    EasyMock.expect(optionsMock.getService()).andReturn(dns);
    EasyMock.replay(dns, batchMock, optionsMock);
    DnsBatchResult<ChangeRequest> batchResult =
        dnsBatch.applyChangeRequest(ZONE_INFO.getName(), CHANGE_REQUEST_PARTIAL, CHANGE_GET_FIELDS);
    String selector = (String) capturedOptions.getValue().get(CHANGE_GET_FIELDS.getRpcOption());
    assertTrue(selector.contains(Dns.ChangeRequestField.STATUS.getSelector()));
    assertTrue(selector.contains(Dns.ChangeRequestField.ID.getSelector()));
    RpcBatch.Callback<Change> capturedCallback = callback.getValue();
    capturedCallback.onSuccess(CHANGE_REQUEST_COMPLETE.toPb());
    assertEquals(CHANGE_REQUEST_COMPLETE.toPb(), batchResult.get().toPb());
  }
}
