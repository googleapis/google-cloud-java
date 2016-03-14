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

package com.google.gcloud.dns.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.gcloud.dns.DnsException;
import com.google.gcloud.dns.spi.DefaultDnsRpc;
import com.google.gcloud.dns.spi.DnsRpc;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LocalDnsHelperTest {

  private static final String RRSET_TYPE = "A";
  private static final ResourceRecordSet RRSET1 = new ResourceRecordSet();
  private static final ResourceRecordSet RRSET2 = new ResourceRecordSet();
  private static final ResourceRecordSet RRSET_KEEP = new ResourceRecordSet();
  private static final String PROJECT_ID1 = "2135436541254";
  private static final String PROJECT_ID2 = "882248761325";
  private static final String ZONE_NAME1 = "my-little-zone";
  private static final String ZONE_NAME2 = "another-zone-name";
  private static final ManagedZone ZONE1 = new ManagedZone();
  private static final ManagedZone ZONE2 = new ManagedZone();
  private static final String DNS_NAME = "www.example.com.";
  private static final Change CHANGE1 = new Change();
  private static final Change CHANGE2 = new Change();
  private static final Change CHANGE_KEEP = new Change();
  private static final Change CHANGE_COMPLEX = new Change();
  private static final LocalDnsHelper LOCAL_DNS_HELPER = LocalDnsHelper.create(0L);
  private static final Map<DnsRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();
  private static final DnsRpc RPC = new DefaultDnsRpc(LOCAL_DNS_HELPER.options());
  private static final String REAL_PROJECT_ID = LOCAL_DNS_HELPER.options().projectId();
  private Map<String, Object> optionsMap;

  @BeforeClass
  public static void before() {
    ZONE1.setName(ZONE_NAME1);
    ZONE1.setDescription("");
    ZONE1.setDnsName(DNS_NAME);
    ZONE1.setNameServerSet("somenameserverset");
    ZONE2.setName(ZONE_NAME2);
    ZONE2.setDescription("");
    ZONE2.setDnsName(DNS_NAME);
    ZONE2.setNameServerSet("somenameserverset");
    RRSET1.setName(DNS_NAME);
    RRSET1.setType(RRSET_TYPE);
    RRSET1.setRrdatas(ImmutableList.of("1.1.1.1"));
    RRSET2.setName(DNS_NAME);
    RRSET2.setType(RRSET_TYPE);
    RRSET2.setRrdatas(ImmutableList.of("123.132.153.156"));
    RRSET_KEEP.setName(DNS_NAME);
    RRSET_KEEP.setType("MX");
    RRSET_KEEP.setRrdatas(ImmutableList.of("255.255.255.254"));
    CHANGE1.setAdditions(ImmutableList.of(RRSET1, RRSET2));
    CHANGE2.setDeletions(ImmutableList.of(RRSET2));
    CHANGE_KEEP.setAdditions(ImmutableList.of(RRSET_KEEP));
    CHANGE_COMPLEX.setAdditions(ImmutableList.of(RRSET_KEEP));
    CHANGE_COMPLEX.setDeletions(ImmutableList.of(RRSET_KEEP));
    LOCAL_DNS_HELPER.start();
  }

  @Rule
  public Timeout globalTimeout = Timeout.seconds(60);

  @Before
  public void setUp() {
    resetProjects();
    optionsMap = new HashMap<>();
  }

  @AfterClass
  public static void after() {
    LOCAL_DNS_HELPER.stop();
  }

  private static void resetProjects() {
    for (String project : LOCAL_DNS_HELPER.projects().keySet()) {
      LOCAL_DNS_HELPER.projects().remove(project);
    }
  }

  private static void assertEqChangesIgnoreStatus(Change expected, Change actual) {
    assertEquals(expected.getAdditions(), actual.getAdditions());
    assertEquals(expected.getDeletions(), actual.getDeletions());
    assertEquals(expected.getId(), actual.getId());
    assertEquals(expected.getStartTime(), actual.getStartTime());
  }

  @Test
  public void testCreateZone() {
    ManagedZone created = RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    // check that default records were created
    DnsRpc.ListResult<ResourceRecordSet> listResult
        = RPC.listDnsRecords(ZONE1.getName(), EMPTY_RPC_OPTIONS);
    ImmutableList<String> defaultTypes = ImmutableList.of("SOA", "NS");
    Iterator<ResourceRecordSet> iterator = listResult.results().iterator();
    assertTrue(defaultTypes.contains(iterator.next().getType()));
    assertTrue(defaultTypes.contains(iterator.next().getType()));
    assertFalse(iterator.hasNext());
    assertEquals(created, LOCAL_DNS_HELPER.findZone(REAL_PROJECT_ID, ZONE1.getName()).zone());
    ManagedZone zone = RPC.getZone(ZONE_NAME1, EMPTY_RPC_OPTIONS);
    assertEquals(created, zone);
    try {
      RPC.create(null, EMPTY_RPC_OPTIONS);
      fail("Zone cannot be null");
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("entity.managedZone"));
    }
    // create zone twice
    try {
      RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
      fail("Zone already exists.");
    } catch (DnsException ex) {
      // expected
      assertEquals(409, ex.code());
      assertTrue(ex.getMessage().contains("already exists"));
    }
    // field options
    resetProjects();
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.FIELDS, "id");
    zone = RPC.create(ZONE1, options);
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNotNull(zone.getId());
    resetProjects();
    options.put(DnsRpc.Option.FIELDS, "creationTime");
    zone = RPC.create(ZONE1, options);
    assertNotNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "dnsName");
    resetProjects();
    zone = RPC.create(ZONE1, options);
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNotNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "description");
    resetProjects();
    zone = RPC.create(ZONE1, options);
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNotNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "nameServers");
    resetProjects();
    zone = RPC.create(ZONE1, options);
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNotNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "nameServerSet");
    resetProjects();
    zone = RPC.create(ZONE1, options);
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNotNull(zone.getNameServerSet());
    assertNull(zone.getId());
    // several combined
    options.put(DnsRpc.Option.FIELDS, "nameServerSet,description,id,name");
    resetProjects();
    zone = RPC.create(ZONE1, options);
    assertNull(zone.getCreationTime());
    assertNotNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNotNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNotNull(zone.getNameServerSet());
    assertNotNull(zone.getId());
  }

  @Test
  public void testGetZone() {
    // non-existent
    assertNull(RPC.getZone(ZONE_NAME1, EMPTY_RPC_OPTIONS));
    // existent
    ManagedZone created = RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    ManagedZone zone = RPC.getZone(ZONE_NAME1, EMPTY_RPC_OPTIONS);
    assertEquals(created, zone);
    assertEquals(ZONE1.getName(), zone.getName());
    // field options
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.FIELDS, "id");
    zone = RPC.getZone(ZONE1.getName(), options);
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNotNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "creationTime");
    zone = RPC.getZone(ZONE1.getName(), options);
    assertNotNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "dnsName");
    zone = RPC.getZone(ZONE1.getName(), options);
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNotNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "description");
    zone = RPC.getZone(ZONE1.getName(), options);
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNotNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "nameServers");
    zone = RPC.getZone(ZONE1.getName(), options);
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNotNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "nameServerSet");
    zone = RPC.getZone(ZONE1.getName(), options);
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNotNull(zone.getNameServerSet());
    assertNull(zone.getId());
    // several combined
    options.put(DnsRpc.Option.FIELDS, "nameServerSet,description,id,name");
    zone = RPC.getZone(ZONE1.getName(), options);
    assertNull(zone.getCreationTime());
    assertNotNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNotNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNotNull(zone.getNameServerSet());
    assertNotNull(zone.getId());
  }

  @Test
  public void testDeleteZone() {
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    assertTrue(RPC.deleteZone(ZONE1.getName()));
    assertNull(RPC.getZone(ZONE1.getName(), EMPTY_RPC_OPTIONS));
    // deleting non-existent zone
    assertFalse(RPC.deleteZone(ZONE1.getName()));
    assertNull(RPC.getZone(ZONE1.getName(), EMPTY_RPC_OPTIONS));
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    RPC.create(ZONE2, EMPTY_RPC_OPTIONS);
    assertNotNull(RPC.getZone(ZONE1.getName(), EMPTY_RPC_OPTIONS));
    assertNotNull(RPC.getZone(ZONE2.getName(), EMPTY_RPC_OPTIONS));
    // delete in reverse order
    assertTrue(RPC.deleteZone(ZONE1.getName()));
    assertNull(RPC.getZone(ZONE1.getName(), EMPTY_RPC_OPTIONS));
    assertNotNull(RPC.getZone(ZONE2.getName(), EMPTY_RPC_OPTIONS));
    assertTrue(RPC.deleteZone(ZONE2.getName()));
    assertNull(RPC.getZone(ZONE1.getName(), EMPTY_RPC_OPTIONS));
    assertNull(RPC.getZone(ZONE2.getName(), EMPTY_RPC_OPTIONS));
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE_KEEP, EMPTY_RPC_OPTIONS);
    try {
      RPC.deleteZone(ZONE1.getName());
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("not empty"));
    }
  }

  @Test
  public void testCreateAndApplyChange() {
    executeCreateAndApplyChangeTest(RPC);
  }

  @Test
  public void testCreateAndApplyChangeWithThreads() {
    LocalDnsHelper localDnsThreaded = LocalDnsHelper.create(50L);
    localDnsThreaded.start();
    DnsRpc rpc = new DefaultDnsRpc(localDnsThreaded.options());
    executeCreateAndApplyChangeTest(rpc);
    localDnsThreaded.stop();
  }

  private static void waitForChangeToComplete(DnsRpc rpc, String zoneName, String changeId) {
    while (true) {
      Change change = rpc.getChangeRequest(zoneName, changeId, EMPTY_RPC_OPTIONS);
      if ("done".equals(change.getStatus())) {
        return;
      }
      try {
        Thread.sleep(50L);
      } catch (InterruptedException e) {
        fail("Thread was interrupted while waiting for change processing.");
      }
    }
  }

  private static void executeCreateAndApplyChangeTest(DnsRpc rpc) {
    rpc.create(ZONE1, EMPTY_RPC_OPTIONS);
    assertNull(rpc.getChangeRequest(ZONE1.getName(), "1", EMPTY_RPC_OPTIONS));
    // add
    Change createdChange = rpc.applyChangeRequest(ZONE1.getName(), CHANGE1, EMPTY_RPC_OPTIONS);
    assertEquals(CHANGE1.getAdditions(), createdChange.getAdditions());
    assertEquals(CHANGE1.getDeletions(), createdChange.getDeletions());
    assertNotNull(createdChange.getStartTime());
    assertEquals("1", createdChange.getId());
    waitForChangeToComplete(rpc, ZONE1.getName(), "1"); // necessary for the following to return 409
    try {
      rpc.applyChangeRequest(ZONE1.getName(), CHANGE1, EMPTY_RPC_OPTIONS);
      fail();
    } catch (DnsException ex) {
      assertEquals(409, ex.code());
      assertTrue(ex.getMessage().contains("already exists"));
    }
    assertNotNull(rpc.getChangeRequest(ZONE1.getName(), "1", EMPTY_RPC_OPTIONS));
    assertNull(rpc.getChangeRequest(ZONE1.getName(), "2", EMPTY_RPC_OPTIONS));
    // delete
    rpc.applyChangeRequest(ZONE1.getName(), CHANGE2, EMPTY_RPC_OPTIONS);
    assertNotNull(rpc.getChangeRequest(ZONE1.getName(), "1", EMPTY_RPC_OPTIONS));
    assertNotNull(rpc.getChangeRequest(ZONE1.getName(), "2", EMPTY_RPC_OPTIONS));
    waitForChangeToComplete(rpc, ZONE1.getName(), "2");
    rpc.applyChangeRequest(ZONE1.getName(), CHANGE_KEEP, EMPTY_RPC_OPTIONS);
    waitForChangeToComplete(rpc, ZONE1.getName(), "3");
    Iterable<ResourceRecordSet> results =
        rpc.listDnsRecords(ZONE1.getName(), EMPTY_RPC_OPTIONS).results();
    List<String> defaults = ImmutableList.of("SOA", "NS");
    boolean rrsetKeep = false;
    boolean rrset1 = false;
    for (ResourceRecordSet dnsRecord : results) {
      if (dnsRecord.getName().equals(RRSET_KEEP.getName())
          && dnsRecord.getType().equals(RRSET_KEEP.getType())) {
        rrsetKeep = true;
      } else if (dnsRecord.getName().equals(RRSET1.getName())
          && dnsRecord.getType().equals(RRSET1.getType())) {
        rrset1 = true;
      } else if (!defaults.contains(dnsRecord.getType())) {
        fail(String.format("Record with type %s should not exist", dnsRecord.getType()));
      }
    }
    assertTrue(rrset1);
    assertTrue(rrsetKeep);
  }

  @Test
  public void testGetProject() {
    // the projects are automatically created when getProject is called
    assertNotNull(LOCAL_DNS_HELPER.getProject(PROJECT_ID1, null));
    assertNotNull(LOCAL_DNS_HELPER.getProject(PROJECT_ID2, null));
    Project project = RPC.getProject(EMPTY_RPC_OPTIONS);
    assertNotNull(project.getQuota());
    assertEquals(REAL_PROJECT_ID, project.getId());
    // fields options
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.FIELDS, "number");
    project = RPC.getProject(options);
    assertNull(project.getId());
    assertNotNull(project.getNumber());
    assertNull(project.getQuota());
    options.put(DnsRpc.Option.FIELDS, "id");
    project = RPC.getProject(options);
    assertNotNull(project.getId());
    assertNull(project.getNumber());
    assertNull(project.getQuota());
    options.put(DnsRpc.Option.FIELDS, "quota");
    project = RPC.getProject(options);
    assertNull(project.getId());
    assertNull(project.getNumber());
    assertNotNull(project.getQuota());
  }

  @Test
  public void testCreateChange() {
    // non-existent zone
    try {
      RPC.applyChangeRequest(ZONE_NAME1, CHANGE1, EMPTY_RPC_OPTIONS);
      fail("Zone was not created yet.");
    } catch (DnsException ex) {
      assertEquals(404, ex.code());
    }
    // existent zone
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    assertNull(RPC.getChangeRequest(ZONE_NAME1, "1", EMPTY_RPC_OPTIONS));
    Change created = RPC.applyChangeRequest(ZONE1.getName(), CHANGE1, EMPTY_RPC_OPTIONS);
    assertEquals(created, RPC.getChangeRequest(ZONE_NAME1, "1", EMPTY_RPC_OPTIONS));
    // field options
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE_KEEP, EMPTY_RPC_OPTIONS);
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.FIELDS, "additions");
    Change complex = RPC.applyChangeRequest(ZONE1.getName(), CHANGE_COMPLEX, options);
    assertNotNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNull(complex.getStatus());
    options.put(DnsRpc.Option.FIELDS, "deletions");
    complex = RPC.applyChangeRequest(ZONE1.getName(), CHANGE_COMPLEX, options);
    assertNull(complex.getAdditions());
    assertNotNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNull(complex.getStatus());
    options.put(DnsRpc.Option.FIELDS, "id");
    complex = RPC.applyChangeRequest(ZONE1.getName(), CHANGE_COMPLEX, options);
    assertNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNotNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNull(complex.getStatus());
    options.put(DnsRpc.Option.FIELDS, "startTime");
    complex = RPC.applyChangeRequest(ZONE1.getName(), CHANGE_COMPLEX, options);
    assertNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNotNull(complex.getStartTime());
    assertNull(complex.getStatus());
    options.put(DnsRpc.Option.FIELDS, "status");
    complex = RPC.applyChangeRequest(ZONE1.getName(), CHANGE_COMPLEX, options);
    assertNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNotNull(complex.getStatus());
  }

  @Test
  public void testGetChange() {
    // existent
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    Change created = RPC.applyChangeRequest(ZONE1.getName(), CHANGE1, EMPTY_RPC_OPTIONS);
    Change retrieved = RPC.getChangeRequest(ZONE1.getName(), "1", EMPTY_RPC_OPTIONS);
    assertEquals(created, retrieved);
    // non-existent
    assertNull(RPC.getChangeRequest(ZONE1.getName(), "2", EMPTY_RPC_OPTIONS));
    // non-existent zone
    try {
      RPC.getChangeRequest(ZONE_NAME2, "1", EMPTY_RPC_OPTIONS);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(404, ex.code());
      assertTrue(ex.getMessage().contains("managedZone"));
    }
    // field options
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE_KEEP, EMPTY_RPC_OPTIONS);
    Change change = RPC.applyChangeRequest(ZONE1.getName(), CHANGE_COMPLEX, EMPTY_RPC_OPTIONS);
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.FIELDS, "additions");
    Change complex = RPC.getChangeRequest(ZONE1.getName(), change.getId(), options);
    assertNotNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNull(complex.getStatus());
    options.put(DnsRpc.Option.FIELDS, "deletions");
    complex = RPC.getChangeRequest(ZONE1.getName(), change.getId(), options);
    assertNull(complex.getAdditions());
    assertNotNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNull(complex.getStatus());
    options.put(DnsRpc.Option.FIELDS, "id");
    complex = RPC.getChangeRequest(ZONE1.getName(), change.getId(), options);
    assertNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNotNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNull(complex.getStatus());
    options.put(DnsRpc.Option.FIELDS, "startTime");
    complex = RPC.getChangeRequest(ZONE1.getName(), change.getId(), options);
    assertNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNotNull(complex.getStartTime());
    assertNull(complex.getStatus());
    options.put(DnsRpc.Option.FIELDS, "status");
    complex = RPC.getChangeRequest(ZONE1.getName(), change.getId(), options);
    assertNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNotNull(complex.getStatus());
  }

  @Test
  public void testListZones() {
    Iterable<ManagedZone> results = RPC.listZones(EMPTY_RPC_OPTIONS).results();
    ImmutableList<ManagedZone> zones = ImmutableList.copyOf(results);
    assertEquals(0, zones.size());
    // some zones exists
    ManagedZone created = RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    results = RPC.listZones(EMPTY_RPC_OPTIONS).results();
    zones = ImmutableList.copyOf(results);
    assertEquals(created, zones.get(0));
    assertEquals(1, zones.size());
    created = RPC.create(ZONE2, EMPTY_RPC_OPTIONS);
    results = RPC.listZones(EMPTY_RPC_OPTIONS).results();
    zones = ImmutableList.copyOf(results);
    assertEquals(2, zones.size());
    assertTrue(zones.contains(created));
    // error in options
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, 0);
    try {
      RPC.listZones(options);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("parameters.maxResults"));
    }
    options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, -1);
    try {
      RPC.listZones(options);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("parameters.maxResults"));
    }
    // ok size
    options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, 335);
    results = RPC.listZones(options).results();
    zones = ImmutableList.copyOf(results);
    assertEquals(2, zones.size());
    // dns name problems
    options = new HashMap<>();
    options.put(DnsRpc.Option.DNS_NAME, "aaa");
    try {
      RPC.listZones(options);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("parameters.dnsName"));
    }
    // ok name
    options = new HashMap<>();
    options.put(DnsRpc.Option.DNS_NAME, "aaaa.");
    results = RPC.listZones(options).results();
    zones = ImmutableList.copyOf(results);
    assertEquals(0, zones.size());
    // field options
    options = new HashMap<>();
    options.put(DnsRpc.Option.FIELDS, "managedZones(id)");
    ManagedZone zone = RPC.listZones(options).results().iterator().next();
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNotNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "managedZones(creationTime)");
    zone = RPC.listZones(options).results().iterator().next();
    assertNotNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "managedZones(dnsName)");
    zone = RPC.listZones(options).results().iterator().next();
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNotNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "managedZones(description)");
    zone = RPC.listZones(options).results().iterator().next();
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNotNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "managedZones(nameServers)");
    zone = RPC.listZones(options).results().iterator().next();
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNotNull(zone.getNameServers());
    assertNull(zone.getNameServerSet());
    assertNull(zone.getId());
    options.put(DnsRpc.Option.FIELDS, "managedZones(nameServerSet)");
    DnsRpc.ListResult<ManagedZone> listResult = RPC.listZones(options);
    zone = listResult.results().iterator().next();
    assertNull(listResult.pageToken());
    assertNull(zone.getCreationTime());
    assertNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNotNull(zone.getNameServerSet());
    assertNull(zone.getId());
    // several combined
    options.put(DnsRpc.Option.FIELDS,
        "managedZones(nameServerSet,description,id,name),nextPageToken");
    options.put(DnsRpc.Option.PAGE_SIZE, 1);
    listResult = RPC.listZones(options);
    zone = listResult.results().iterator().next();
    assertNull(zone.getCreationTime());
    assertNotNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNotNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNotNull(zone.getNameServerSet());
    assertNotNull(zone.getId());
    assertEquals(zone.getName(), listResult.pageToken());
  }

  @Test
  public void testListDnsRecords() {
    // no zone exists
    try {
      RPC.listDnsRecords(ZONE_NAME1, EMPTY_RPC_OPTIONS);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(404, ex.code());
      assertTrue(ex.getMessage().contains("managedZone"));
    }
    // zone exists but has no records
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    Iterable<ResourceRecordSet> results =
        RPC.listDnsRecords(ZONE_NAME1, EMPTY_RPC_OPTIONS).results();
    ImmutableList<ResourceRecordSet> records = ImmutableList.copyOf(results);
    assertEquals(2, records.size()); // contains default NS and SOA
    // zone has records
    RPC.applyChangeRequest(ZONE_NAME1, CHANGE_KEEP, EMPTY_RPC_OPTIONS);
    results = RPC.listDnsRecords(ZONE_NAME1, EMPTY_RPC_OPTIONS).results();
    records = ImmutableList.copyOf(results);
    assertEquals(3, records.size());
    // error in options
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, 0);
    try {
      RPC.listDnsRecords(ZONE1.getName(), options);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("parameters.maxResults"));
    }
    options.put(DnsRpc.Option.PAGE_SIZE, -1);
    try {
      RPC.listDnsRecords(ZONE1.getName(), options);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("parameters.maxResults"));
    }
    options.put(DnsRpc.Option.PAGE_SIZE, 15);
    results = RPC.listDnsRecords(ZONE1.getName(), options).results();
    records = ImmutableList.copyOf(results);
    assertEquals(3, records.size());
    // dnsName filter
    options = new HashMap<>();
    options.put(DnsRpc.Option.NAME, "aaa");
    try {
      RPC.listDnsRecords(ZONE1.getName(), options);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("parameters.name"));
    }
    options.put(DnsRpc.Option.NAME, "aaa.");
    results = RPC.listDnsRecords(ZONE1.getName(), options).results();
    records = ImmutableList.copyOf(results);
    assertEquals(0, records.size());
    options.put(DnsRpc.Option.NAME, null);
    options.put(DnsRpc.Option.DNS_TYPE, "A");
    try {
      RPC.listDnsRecords(ZONE1.getName(), options);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("parameters.name"));
    }
    options.put(DnsRpc.Option.NAME, "aaa.");
    options.put(DnsRpc.Option.DNS_TYPE, "a");
    try {
      RPC.listDnsRecords(ZONE1.getName(), options);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("parameters.type"));
    }
    options.put(DnsRpc.Option.NAME, DNS_NAME);
    options.put(DnsRpc.Option.DNS_TYPE, "SOA");
    results = RPC.listDnsRecords(ZONE1.getName(), options).results();
    records = ImmutableList.copyOf(results);
    assertEquals(1, records.size());
    // field options
    options = new HashMap<>();
    options.put(DnsRpc.Option.FIELDS, "rrsets(name)");
    DnsRpc.ListResult<ResourceRecordSet> listResult =
        RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(listResult.results());
    ResourceRecordSet record = records.get(0);
    assertNotNull(record.getName());
    assertNull(record.getRrdatas());
    assertNull(record.getType());
    assertNull(record.getTtl());
    assertNull(listResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "rrsets(rrdatas)");
    listResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(listResult.results());
    record = records.get(0);
    assertNull(record.getName());
    assertNotNull(record.getRrdatas());
    assertNull(record.getType());
    assertNull(record.getTtl());
    assertNull(listResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "rrsets(ttl)");
    listResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(listResult.results());
    record = records.get(0);
    assertNull(record.getName());
    assertNull(record.getRrdatas());
    assertNull(record.getType());
    assertNotNull(record.getTtl());
    assertNull(listResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "rrsets(type)");
    listResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(listResult.results());
    record = records.get(0);
    assertNull(record.getName());
    assertNull(record.getRrdatas());
    assertNotNull(record.getType());
    assertNull(record.getTtl());
    assertNull(listResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "nextPageToken");
    listResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(listResult.results());
    record = records.get(0);
    assertNull(record.getName());
    assertNull(record.getRrdatas());
    assertNull(record.getType());
    assertNull(record.getTtl());
    assertNull(listResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "nextPageToken,rrsets(name,rrdatas)");
    options.put(DnsRpc.Option.PAGE_SIZE, 1);
    listResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(listResult.results());
    assertEquals(1, records.size());
    record = records.get(0);
    assertNotNull(record.getName());
    assertNotNull(record.getRrdatas());
    assertNull(record.getType());
    assertNull(record.getTtl());
    assertNotNull(listResult.pageToken());
  }

  @Test
  public void testListChanges() {
    // no such zone exists
    try {
      RPC.listChangeRequests(ZONE_NAME1, EMPTY_RPC_OPTIONS);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(404, ex.code());
      assertTrue(ex.getMessage().contains("managedZone"));
    }
    // zone exists but has no changes
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    Iterable<Change> results = RPC.listChangeRequests(ZONE1.getName(), EMPTY_RPC_OPTIONS).results();
    ImmutableList<Change> changes = ImmutableList.copyOf(results);
    assertEquals(1, changes.size());
    // zone has changes
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE1, EMPTY_RPC_OPTIONS);
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE2, EMPTY_RPC_OPTIONS);
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE_KEEP, EMPTY_RPC_OPTIONS);
    results = RPC.listChangeRequests(ZONE1.getName(), EMPTY_RPC_OPTIONS).results();
    changes = ImmutableList.copyOf(results);
    assertEquals(4, changes.size());
    // error in options
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, 0);
    try {
      RPC.listChangeRequests(ZONE1.getName(), options);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("parameters.maxResults"));
    }
    options.put(DnsRpc.Option.PAGE_SIZE, -1);
    try {
      RPC.listChangeRequests(ZONE1.getName(), options);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("parameters.maxResults"));
    }
    options.put(DnsRpc.Option.PAGE_SIZE, 15);
    results = RPC.listChangeRequests(ZONE1.getName(), options).results();
    changes = ImmutableList.copyOf(results);
    assertEquals(4, changes.size());
    options = new HashMap<>();
    options.put(DnsRpc.Option.SORTING_ORDER, "descending");
    results = RPC.listChangeRequests(ZONE1.getName(), options).results();
    ImmutableList<Change> descending = ImmutableList.copyOf(results);
    results = RPC.listChangeRequests(ZONE1.getName(), EMPTY_RPC_OPTIONS).results();
    ImmutableList<Change> ascending = ImmutableList.copyOf(results);
    int size = 4;
    assertEquals(size, descending.size());
    for (int i = 0; i < size; i++) {
      assertEquals(descending.get(i), ascending.get(size - i - 1));
    }
    options.put(DnsRpc.Option.SORTING_ORDER, "something else");
    try {
      RPC.listChangeRequests(ZONE1.getName(), options);
      fail();
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
      assertTrue(ex.getMessage().contains("parameters.sortOrder"));
    }
    // field options
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE_COMPLEX, EMPTY_RPC_OPTIONS);
    options = new HashMap<>();
    options.put(DnsRpc.Option.SORTING_ORDER, "descending");
    options.put(DnsRpc.Option.FIELDS, "changes(additions)");
    DnsRpc.ListResult<Change> changeListResult = RPC.listChangeRequests(ZONE1.getName(), options);
    changes = ImmutableList.copyOf(changeListResult.results());
    Change complex = changes.get(0);
    assertNotNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNull(complex.getStatus());
    assertNull(changeListResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "changes(deletions)");
    changeListResult = RPC.listChangeRequests(ZONE1.getName(), options);
    changes = ImmutableList.copyOf(changeListResult.results());
    complex = changes.get(0);
    assertNull(complex.getAdditions());
    assertNotNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNull(complex.getStatus());
    assertNull(changeListResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "changes(id)");
    changeListResult = RPC.listChangeRequests(ZONE1.getName(), options);
    changes = ImmutableList.copyOf(changeListResult.results());
    complex = changes.get(0);
    assertNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNotNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNull(complex.getStatus());
    assertNull(changeListResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "changes(startTime)");
    changeListResult = RPC.listChangeRequests(ZONE1.getName(), options);
    changes = ImmutableList.copyOf(changeListResult.results());
    complex = changes.get(0);
    assertNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNotNull(complex.getStartTime());
    assertNull(complex.getStatus());
    assertNull(changeListResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "changes(status)");
    changeListResult = RPC.listChangeRequests(ZONE1.getName(), options);
    changes = ImmutableList.copyOf(changeListResult.results());
    complex = changes.get(0);
    assertNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNotNull(complex.getStatus());
    assertNull(changeListResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "nextPageToken");
    options.put(DnsRpc.Option.PAGE_SIZE, 1);
    changeListResult = RPC.listChangeRequests(ZONE1.getName(), options);
    changes = ImmutableList.copyOf(changeListResult.results());
    complex = changes.get(0);
    assertNull(complex.getAdditions());
    assertNull(complex.getDeletions());
    assertNull(complex.getId());
    assertNull(complex.getStartTime());
    assertNull(complex.getStatus());
    assertNotNull(changeListResult.pageToken());
  }

  @Test
  public void testDnsRecordPaging() {
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    List<ResourceRecordSet> complete = ImmutableList.copyOf(
        RPC.listDnsRecords(ZONE1.getName(), EMPTY_RPC_OPTIONS).results());
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, 1);
    DnsRpc.ListResult<ResourceRecordSet> listResult = RPC.listDnsRecords(ZONE1.getName(), options);
    ImmutableList<ResourceRecordSet> records = ImmutableList.copyOf(listResult.results());
    assertEquals(1, records.size());
    assertEquals(complete.get(0), records.get(0));
    options.put(DnsRpc.Option.PAGE_TOKEN, listResult.pageToken());
    listResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(listResult.results());
    assertEquals(1, records.size());
    assertEquals(complete.get(1), records.get(0));
  }

  @Test
  public void testZonePaging() {
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    RPC.create(ZONE2, EMPTY_RPC_OPTIONS);
    ImmutableList<ManagedZone> complete = ImmutableList.copyOf(
        RPC.listZones(EMPTY_RPC_OPTIONS).results());
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, 1);
    DnsRpc.ListResult<ManagedZone> listResult = RPC.listZones(options);
    ImmutableList<ManagedZone> page1 = ImmutableList.copyOf(listResult.results());
    assertEquals(1, page1.size());
    assertEquals(complete.get(0), page1.get(0));
    assertEquals(page1.get(0).getName(), listResult.pageToken());
    options.put(DnsRpc.Option.PAGE_TOKEN, listResult.pageToken());
    listResult = RPC.listZones(options);
    ImmutableList<ManagedZone> page2 = ImmutableList.copyOf(listResult.results());
    assertEquals(1, page2.size());
    assertEquals(complete.get(1), page2.get(0));
    assertNull(listResult.pageToken());
  }

  @Test
  public void testChangePaging() {
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE1, EMPTY_RPC_OPTIONS);
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE2, EMPTY_RPC_OPTIONS);
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE_KEEP, EMPTY_RPC_OPTIONS);
    ImmutableList<Change> complete =
        ImmutableList.copyOf(RPC.listChangeRequests(ZONE1.getName(), EMPTY_RPC_OPTIONS).results());
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, 1);
    DnsRpc.ListResult<Change> changeListResult = RPC.listChangeRequests(ZONE1.getName(), options);
    List<Change> changes = ImmutableList.copyOf(changeListResult.results());
    assertEquals(1, changes.size());
    assertEquals(complete.get(0), changes.get(0));
    assertEquals(complete.get(0).getId(), changeListResult.pageToken());
    options.put(DnsRpc.Option.PAGE_TOKEN, changeListResult.pageToken());
    changeListResult = RPC.listChangeRequests(ZONE1.getName(), options);
    changes = ImmutableList.copyOf(changeListResult.results());
    assertEquals(1, changes.size());
    assertEquals(complete.get(1), changes.get(0));
    assertEquals(complete.get(1).getId(), changeListResult.pageToken());
  }

  @Test
  public void testToListResponse() {
    LocalDnsHelper.Response response = LocalDnsHelper.toListResponse(
        Lists.newArrayList("some", "multiple", "words"), "contextA", "IncludeThisPageToken", true);
    assertTrue(response.body().contains("IncludeThisPageToken"));
    assertTrue(response.body().contains("contextA"));
    response = LocalDnsHelper.toListResponse(
        Lists.newArrayList("some", "multiple", "words"), "contextB", "IncludeThisPageToken", false);
    assertFalse(response.body().contains("IncludeThisPageToken"));
    assertTrue(response.body().contains("contextB"));
    response = LocalDnsHelper.toListResponse(
        Lists.newArrayList("some", "multiple", "words"), "contextC", null, true);
    assertFalse(response.body().contains("pageToken"));
    assertTrue(response.body().contains("contextC"));
  }

  @Test
  public void testCreateZoneValidation() {
    ManagedZone minimalZone = copyZone(ZONE1);
    // no name
    ManagedZone copy = copyZone(minimalZone);
    copy.setName(null);
    LocalDnsHelper.Response response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.name"));
    // no description
    copy = copyZone(minimalZone);
    copy.setDescription(null);
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.description"));
    // no dns name
    copy = copyZone(minimalZone);
    copy.setDnsName(null);
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.dnsName"));
    // zone name does not start with a letter
    copy = copyZone(minimalZone);
    copy.setName("1aaaaaa");
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.name"));
    assertTrue(response.body().contains("Invalid"));
    // zone name is too long
    copy = copyZone(minimalZone);
    copy.setName("123456aaaa123456aaaa123456aaaa123456aaaa123456aaaa123456aaaa123456aaaa123456aa");
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.name"));
    assertTrue(response.body().contains("Invalid"));
    // zone name contains invalid characters
    copy = copyZone(minimalZone);
    copy.setName("x1234AA6aa");
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.name"));
    assertTrue(response.body().contains("Invalid"));
    // zone name contains invalid characters
    copy = copyZone(minimalZone);
    copy.setName("x a");
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.name"));
    assertTrue(response.body().contains("Invalid"));
    // dns name does not end with period
    copy = copyZone(minimalZone);
    copy.setDnsName("aaaaaa.com");
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.dnsName"));
    assertTrue(response.body().contains("Invalid"));
    // dns name is reserved
    copy = copyZone(minimalZone);
    copy.setDnsName("com.");
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("not available to be created."));
    // empty description should pass
    copy = copyZone(minimalZone);
    copy.setDescription("");
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy);
    assertEquals(200, response.code());
  }

  @Test
  public void testCheckListOptions() {
    // listing zones
    optionsMap.put("maxResults", "-1");
    LocalDnsHelper.Response response = LocalDnsHelper.checkListOptions(optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("parameters.maxResults"));
    optionsMap.put("maxResults", "0");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("parameters.maxResults"));
    optionsMap.put("maxResults", "aaaa");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("integer"));
    optionsMap.put("maxResults", "15");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertNull(response);
    optionsMap.put("dnsName", "aaa");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("parameters.dnsName"));
    optionsMap.put("dnsName", "aaa.");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertNull(response);
    // listing dns records
    optionsMap.put("name", "aaa");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("parameters.name"));
    optionsMap.put("name", "aaa.");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertNull(response);
    optionsMap.put("name", null);
    optionsMap.put("type", "A");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("parameters.name"));
    optionsMap.put("name", "aaa.");
    optionsMap.put("type", "a");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("parameters.type"));
    optionsMap.put("name", "aaaa.");
    optionsMap.put("type", "A");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertNull(response);
    // listing changes
    optionsMap.put("sortBy", "changeSequence");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertNull(response);
    optionsMap.put("sortBy", "something else");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("Allowed values: [changesequence]"));
    optionsMap.put("sortBy", "ChAnGeSeQuEnCe"); // is not case sensitive
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertNull(response);
    optionsMap.put("sortOrder", "ascending");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertNull(response);
    optionsMap.put("sortOrder", "descending");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertNull(response);
    optionsMap.put("sortOrder", "somethingelse");
    response = LocalDnsHelper.checkListOptions(optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("parameters.sortOrder"));
  }

  @Test
  public void testCheckRrset() {
    ResourceRecordSet valid = new ResourceRecordSet();
    valid.setName(ZONE1.getDnsName());
    valid.setType("A");
    valid.setRrdatas(ImmutableList.of("0.255.1.5"));
    valid.setTtl(500);
    Change validChange = new Change();
    validChange.setAdditions(ImmutableList.of(valid));
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1);
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange);
    // delete with field mismatch
    LocalDnsHelper.ZoneContainer zone = LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE_NAME1);
    valid.setTtl(valid.getTtl() + 20);
    LocalDnsHelper.Response response = LocalDnsHelper.checkRrset(valid, zone, 0, "deletions");
    assertEquals(412, response.code());
    assertTrue(response.body().contains("entity.change.deletions[0]"));
  }

  @Test
  public void testCheckRrdata() {
    // A
    assertTrue(LocalDnsHelper.checkRrData("255.255.255.255", "A"));
    assertTrue(LocalDnsHelper.checkRrData("13.15.145.165", "A"));
    assertTrue(LocalDnsHelper.checkRrData("0.0.0.0", "A"));
    assertFalse(LocalDnsHelper.checkRrData("255.255.255.256", "A"));
    assertFalse(LocalDnsHelper.checkRrData("-1.255.255.255", "A"));
    assertFalse(LocalDnsHelper.checkRrData(".255.255.254", "A"));
    assertFalse(LocalDnsHelper.checkRrData("111.255.255.", "A"));
    assertFalse(LocalDnsHelper.checkRrData("111.255..22", "A"));
    assertFalse(LocalDnsHelper.checkRrData("111.255.aa.22", "A"));
    assertFalse(LocalDnsHelper.checkRrData("", "A"));
    assertFalse(LocalDnsHelper.checkRrData("...", "A"));
    assertFalse(LocalDnsHelper.checkRrData("111.255.12", "A"));
    assertFalse(LocalDnsHelper.checkRrData("111.255.12.11.11", "A"));
    // AAAA
    assertTrue(LocalDnsHelper.checkRrData("1F:fa:09fd::343:aaaa:AAAA:0", "AAAA"));
    assertTrue(LocalDnsHelper.checkRrData("0000:FFFF:09fd::343:aaaa:AAAA:0", "AAAA"));
    assertFalse(LocalDnsHelper.checkRrData("-2:::::::", "AAAA"));
    assertTrue(LocalDnsHelper.checkRrData("0::0", "AAAA"));
    assertFalse(LocalDnsHelper.checkRrData("::1FFFF:::::", "AAAA"));
    assertFalse(LocalDnsHelper.checkRrData("::aqaa:::::", "AAAA"));
    assertFalse(LocalDnsHelper.checkRrData("::::::::", "AAAA")); // too long
    assertFalse(LocalDnsHelper.checkRrData("::::::", "AAAA")); // too short
  }

  @Test
  public void testCheckChange() {
    ResourceRecordSet validA = new ResourceRecordSet();
    validA.setName(ZONE1.getDnsName());
    validA.setType("A");
    validA.setRrdatas(ImmutableList.of("0.255.1.5"));
    ResourceRecordSet invalidA = new ResourceRecordSet();
    invalidA.setName(ZONE1.getDnsName());
    invalidA.setType("A");
    invalidA.setRrdatas(ImmutableList.of("0.-255.1.5"));
    Change validChange = new Change();
    validChange.setAdditions(ImmutableList.of(validA));
    Change invalidChange = new Change();
    invalidChange.setAdditions(ImmutableList.of(invalidA));
    LocalDnsHelper.ZoneContainer zoneContainer = new LocalDnsHelper.ZoneContainer(ZONE1);
    LocalDnsHelper.Response response = LocalDnsHelper.checkChange(validChange, zoneContainer);
    assertNull(response);
    response = LocalDnsHelper.checkChange(invalidChange, zoneContainer);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].rrdata[0]"));
    // only empty additions/deletions
    Change empty = new Change();
    empty.setAdditions(ImmutableList.<ResourceRecordSet>of());
    empty.setDeletions(ImmutableList.<ResourceRecordSet>of());
    response = LocalDnsHelper.checkChange(empty, zoneContainer);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "The 'entity.change' parameter is required but was missing."));
    // null additions/deletions
    empty = new Change();
    response = LocalDnsHelper.checkChange(empty, zoneContainer);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "The 'entity.change' parameter is required but was missing."));
    // non-matching name
    validA.setName(ZONE1.getDnsName() + ".aaa.");
    response = LocalDnsHelper.checkChange(validChange, zoneContainer);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].name"));
    // wrong type
    validA.setName(ZONE1.getDnsName()); // revert
    validA.setType("ABCD");
    response = LocalDnsHelper.checkChange(validChange, zoneContainer);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].type"));
    // wrong ttl
    validA.setType("A"); // revert
    validA.setTtl(-1);
    response = LocalDnsHelper.checkChange(validChange, zoneContainer);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].ttl"));
    validA.setTtl(null);
    // null name
    validA.setName(null);
    response = LocalDnsHelper.checkChange(validChange, zoneContainer);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].name"));
    validA.setName(ZONE1.getDnsName());
    // null type
    validA.setType(null);
    response = LocalDnsHelper.checkChange(validChange, zoneContainer);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].type"));
    validA.setType("A");
    // null rrdata
    final List<String> temp = validA.getRrdatas(); // preserve
    validA.setRrdatas(null);
    response = LocalDnsHelper.checkChange(validChange, zoneContainer);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].rrdata"));
    validA.setRrdatas(temp);
    // delete non-existent
    ResourceRecordSet nonExistent = new ResourceRecordSet();
    nonExistent.setName(ZONE1.getDnsName());
    nonExistent.setType("AAAA");
    nonExistent.setRrdatas(ImmutableList.of("0:0:0:0:5::6"));
    Change delete = new Change();
    delete.setDeletions(ImmutableList.of(nonExistent));
    response = LocalDnsHelper.checkChange(delete, zoneContainer);
    assertEquals(404, response.code());
    assertTrue(response.body().contains("deletions[0]"));
  }

  @Test
  public void testCheckAdditionsDeletions() {
    ResourceRecordSet validA = new ResourceRecordSet();
    validA.setName(ZONE1.getDnsName());
    validA.setType("A");
    validA.setRrdatas(ImmutableList.of("0.255.1.5"));
    Change validChange = new Change();
    validChange.setAdditions(ImmutableList.of(validA));
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1);
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange);
    LocalDnsHelper.ZoneContainer container = LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE_NAME1);
    LocalDnsHelper.Response response =
        LocalDnsHelper.checkAdditionsDeletions(ImmutableList.of(validA), null, container);
    assertEquals(409, response.code());
    assertTrue(response.body().contains("already exists"));
  }

  @Test
  public void testCreateChangeContentValidation() {
    ResourceRecordSet validA = new ResourceRecordSet();
    validA.setName(ZONE1.getDnsName());
    validA.setType("A");
    validA.setRrdatas(ImmutableList.of("0.255.1.5"));
    Change validChange = new Change();
    validChange.setAdditions(ImmutableList.of(validA));
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1);
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange);
    LocalDnsHelper.Response response =
        LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange);
    assertEquals(409, response.code());
    assertTrue(response.body().contains("already exists"));
    // delete with field mismatch
    Change delete = new Change();
    validA.setTtl(20); // mismatch
    delete.setDeletions(ImmutableList.of(validA));
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, delete);
    assertEquals(412, response.code());
    assertTrue(response.body().contains("entity.change.deletions[0]"));
    // delete and add SOA
    Change addition = new Change();
    ImmutableCollection<ResourceRecordSet> dnsRecords =
        LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE_NAME1).dnsRecords().get().values();
    LinkedList<ResourceRecordSet> deletions = new LinkedList<>();
    LinkedList<ResourceRecordSet> additions = new LinkedList<>();
    for (ResourceRecordSet rrset : dnsRecords) {
      if (rrset.getType().equals("SOA")) {
        deletions.add(rrset);
        ResourceRecordSet copy = copyRrset(rrset);
        copy.setName("x." + copy.getName());
        additions.add(copy);
        break;
      }
    }
    delete.setDeletions(deletions);
    addition.setAdditions(additions);
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, delete);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "zone must contain exactly one resource record set of type 'SOA' at the apex"));
    assertTrue(response.body().contains("deletions[0]"));
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, addition);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "zone must contain exactly one resource record set of type 'SOA' at the apex"));
    assertTrue(response.body().contains("additions[0]"));
    // delete NS
    deletions = new LinkedList<>();
    additions = new LinkedList<>();
    for (ResourceRecordSet rrset : dnsRecords) {
      if (rrset.getType().equals("NS")) {
        deletions.add(rrset);
        ResourceRecordSet copy = copyRrset(rrset);
        copy.setName("x." + copy.getName());
        additions.add(copy);
        break;
      }
    }
    delete.setDeletions(deletions);
    addition.setAdditions(additions);
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, delete);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "zone must contain exactly one resource record set of type 'NS' at the apex"));
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, addition);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "zone must contain exactly one resource record set of type 'NS' at the apex"));
    assertTrue(response.body().contains("additions[0]"));
    // change (delete + add)
    addition.setDeletions(deletions);
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, addition);
    assertEquals(200, response.code());
  }

  @Test
  public void testMatchesCriteria() {
    assertTrue(LocalDnsHelper.matchesCriteria(RRSET1, RRSET1.getName(), RRSET1.getType()));
    assertFalse(LocalDnsHelper.matchesCriteria(RRSET1, RRSET1.getName(), "anothertype"));
    assertTrue(LocalDnsHelper.matchesCriteria(RRSET1, null, RRSET1.getType()));
    assertTrue(LocalDnsHelper.matchesCriteria(RRSET1, RRSET1.getName(), null));
    assertFalse(LocalDnsHelper.matchesCriteria(RRSET1, "anothername", RRSET1.getType()));
  }

  @Test
  public void testGetUniqueId() {
    assertNotNull(LocalDnsHelper.getUniqueId(new HashSet<String>()));
  }

  @Test
  public void testRandomNameServers() {
    assertEquals(4, LocalDnsHelper.randomNameservers().size());
  }

  private static ManagedZone copyZone(ManagedZone original) {
    ManagedZone copy = new ManagedZone();
    copy.setDescription(original.getDescription());
    copy.setName(original.getName());
    copy.setCreationTime(original.getCreationTime());
    copy.setId(original.getId());
    copy.setNameServerSet(original.getNameServerSet());
    copy.setDnsName(original.getDnsName());
    if (original.getNameServers() != null) {
      copy.setNameServers(ImmutableList.copyOf(original.getNameServers()));
    }
    return copy;
  }

  private static ResourceRecordSet copyRrset(ResourceRecordSet set) {
    ResourceRecordSet copy = new ResourceRecordSet();
    if (set.getRrdatas() != null) {
      copy.setRrdatas(ImmutableList.copyOf(set.getRrdatas()));
    }
    copy.setTtl(set.getTtl());
    copy.setName(set.getName());
    copy.setType(set.getType());
    return copy;
  }
}
