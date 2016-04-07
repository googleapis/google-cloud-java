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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ManagedZonesListResponse;
import com.google.api.services.dns.model.Project;
import com.google.gcloud.Page;
import com.google.gcloud.dns.spi.DnsRpc;
import com.google.gcloud.dns.spi.RpcBatch;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

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
      Dns.ZoneListOption.pageSize(MAX_SIZE), Dns.ZoneListOption.pageToken(PAGE_TOKEN),
      Dns.ZoneListOption.fields(Dns.ZoneField.DESCRIPTION),
      Dns.ZoneListOption.dnsName(DNS_NAME)};
  private static final ProjectInfo PROJECT_INFO = ProjectInfo.builder().build();

  private DnsOptions optionsMock;
  private DnsRpc dnsRpcMock;
  private RpcBatch batchMock;
  private DnsBatch dnsBatch;
  private Dns dns = EasyMock.createStrictMock(Dns.class);

  @Before
  public void setUp() {
    optionsMock = EasyMock.createMock(DnsOptions.class);
    dnsRpcMock = EasyMock.createMock(DnsRpc.class);
    batchMock = EasyMock.createMock(RpcBatch.class);
    EasyMock.expect(optionsMock.rpc()).andReturn(dnsRpcMock);
    EasyMock.expect(dnsRpcMock.createBatch()).andReturn(batchMock);
    EasyMock.replay(optionsMock);
    EasyMock.replay(dnsRpcMock);
    EasyMock.replay(batchMock);
    dnsBatch = new DnsBatch(optionsMock);
  }

  @After
  public void tearDown() {
    EasyMock.verify(batchMock);
    EasyMock.verify(dnsRpcMock);
    EasyMock.verify(optionsMock);
  }

  @Test
  public void testConstructor() {
    assertSame(batchMock, dnsBatch.batch());
    assertSame(optionsMock, dnsBatch.options());
    assertSame(dnsRpcMock, dnsBatch.dnsRpc());
  }

  @Test
  public void testListZones() {
    EasyMock.reset(batchMock);
    Capture<DnsRpc.Callback<ManagedZonesListResponse>> callback = Capture.newInstance();
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
    batchResult.error(new DnsException(new IOException("expected")));
    try {
      batchResult.get();
      fail("TShould throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testListZonesWithOptions() {
    EasyMock.reset(batchMock);
    Capture<DnsRpc.Callback<ManagedZonesListResponse>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addListZones(EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    dnsBatch.listZones(ZONE_LIST_OPTIONS);
    assertNotNull(callback.getValue());
    Integer size = (Integer) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[0].rpcOption());
    assertEquals(MAX_SIZE, size);
    String selector = (String) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[1].rpcOption());
    assertEquals(PAGE_TOKEN, selector);
    selector = (String) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[2].rpcOption());
    assertTrue(selector.contains(Dns.ZoneField.DESCRIPTION.selector()));
    assertTrue(selector.contains(Dns.ZoneField.NAME.selector()));
    selector = (String) capturedOptions.getValue().get(ZONE_LIST_OPTIONS[3].rpcOption());
    assertEquals(DNS_NAME, selector);
    // cannot test callback success without ManagedZonesListResponse which is final
  }

  @Test
  public void testCreateZone() {
    EasyMock.reset(batchMock);
    Capture<DnsRpc.Callback<ManagedZone>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    Capture<ManagedZone> capturedZone = Capture.newInstance();
    batchMock.addCreateZone(EasyMock.capture(capturedZone), EasyMock.capture(callback),
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
    batchResult.error(new DnsException(new IOException("expected")));
    try {
      batchResult.get();
      fail("TShould throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testCreateZoneWithOptions() {
    EasyMock.reset(batchMock);
    EasyMock.reset(optionsMock);
    EasyMock.expect(optionsMock.service()).andReturn(dns);
    EasyMock.replay(optionsMock);
    Capture<DnsRpc.Callback<ManagedZone>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    Capture<ManagedZone> capturedZone = Capture.newInstance();
    batchMock.addCreateZone(EasyMock.capture(capturedZone), EasyMock.capture(callback),
        EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<Zone> batchResult = dnsBatch.createZone(ZONE_INFO, ZONE_FIELDS);
    assertEquals(ZONE_INFO.toPb(), capturedZone.getValue());
    assertNotNull(callback.getValue());
    String selector = (String) capturedOptions.getValue().get(ZONE_FIELDS.rpcOption());
    assertTrue(selector.contains(Dns.ZoneField.CREATION_TIME.selector()));
    assertTrue(selector.contains(Dns.ZoneField.NAME.selector()));
    DnsRpc.Callback<ManagedZone> capturedCallback = callback.getValue();
    capturedCallback.onSuccess(ZONE_INFO.toPb());
    assertEquals(ZONE_INFO.toPb(), batchResult.get().toPb());
  }

  @Test
  public void testGetZone() {
    EasyMock.reset(batchMock);
    Capture<DnsRpc.Callback<ManagedZone>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addGetZone(EasyMock.eq(ZONE_NAME), EasyMock.capture(callback),
        EasyMock.capture(capturedOptions));
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
    batchResult.error(new DnsException(new IOException("expected")));
    try {
      batchResult.get();
      fail("TShould throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testGetZoneWithOptions() {
    EasyMock.reset(batchMock);
    EasyMock.reset(optionsMock);
    Capture<DnsRpc.Callback<ManagedZone>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addGetZone(EasyMock.eq(ZONE_NAME), EasyMock.capture(callback),
        EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<Zone> batchResult = dnsBatch.getZone(ZONE_NAME, ZONE_FIELDS);
    assertNotNull(callback.getValue());
    String selector = (String) capturedOptions.getValue().get(ZONE_FIELDS.rpcOption());
    assertTrue(selector.contains(Dns.ZoneField.CREATION_TIME.selector()));
    assertTrue(selector.contains(Dns.ZoneField.NAME.selector()));
    DnsRpc.Callback<ManagedZone> capturedCallback = callback.getValue();
    EasyMock.expect(optionsMock.service()).andReturn(dns);
    EasyMock.replay(optionsMock);
    capturedCallback.onSuccess(ZONE_INFO.toPb());
    assertEquals(ZONE_INFO.toPb(), batchResult.get().toPb());
  }

  @Test
  public void testDeleteZone() {
    EasyMock.reset(batchMock);
    Capture<DnsRpc.Callback<Void>> callback = Capture.newInstance();
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
    batchResult.error(new DnsException(new IOException("expected")));
    try {
      batchResult.get();
      fail("TShould throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testDeleteZoneOnSuccess() {
    EasyMock.reset(batchMock);
    Capture<DnsRpc.Callback<Void>> callback = Capture.newInstance();
    batchMock.addDeleteZone(EasyMock.eq(ZONE_NAME), EasyMock.capture(callback));
    EasyMock.replay(batchMock);
    DnsBatchResult<Boolean> batchResult = dnsBatch.deleteZone(ZONE_NAME);
    assertNotNull(callback.getValue());
    DnsRpc.Callback<Void> capturedCallback = callback.getValue();
    Void result = null;
    capturedCallback.onSuccess(result);
    assertTrue(batchResult.get());
  }

  @Test
  public void testGetProject() {
    EasyMock.reset(batchMock);
    Capture<DnsRpc.Callback<Project>> callback = Capture.newInstance();
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
    batchResult.error(new DnsException(new IOException("expected")));
    try {
      batchResult.get();
      fail("TShould throw a DnsException on error.");
    } catch (DnsException ex) {
      // expected
    }
  }

  @Test
  public void testGetProjectWithOptions() {
    EasyMock.reset(batchMock);
    Capture<DnsRpc.Callback<Project>> callback = Capture.newInstance();
    Capture<Map<DnsRpc.Option, Object>> capturedOptions = Capture.newInstance();
    batchMock.addGetProject(EasyMock.capture(callback), EasyMock.capture(capturedOptions));
    EasyMock.replay(batchMock);
    DnsBatchResult<ProjectInfo> batchResult = dnsBatch.getProject(PROJECT_FIELDS);
    assertNotNull(callback.getValue());
    String selector = (String) capturedOptions.getValue().get(PROJECT_FIELDS.rpcOption());
    assertTrue(selector.contains(Dns.ProjectField.QUOTA.selector()));
    assertTrue(selector.contains(Dns.ProjectField.PROJECT_ID.selector()));
    DnsRpc.Callback<Project> capturedCallback = callback.getValue();
    capturedCallback.onSuccess(PROJECT_INFO.toPb());
    assertEquals(PROJECT_INFO, batchResult.get());
  }

  // todo(mderka) test submit and other methods when implemented
}
