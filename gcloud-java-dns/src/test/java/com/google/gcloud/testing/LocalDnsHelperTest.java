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

package com.google.gcloud.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.gcloud.dns.DnsException;
import com.google.gcloud.spi.DefaultDnsRpc;
import com.google.gcloud.spi.DnsRpc;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
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
  private static final String ZONE_NAME1 = "my little zone";
  private static final String ZONE_NAME2 = "another zone name";
  private static final ManagedZone ZONE1 = new ManagedZone();
  private static final ManagedZone ZONE2 = new ManagedZone();
  private static final String DNS_NAME = "www.example.com.";
  private static final Change CHANGE1 = new Change();
  private static final Change CHANGE2 = new Change();
  private static final Change CHANGE_KEEP = new Change();
  private static final Change CHANGE_COMPLEX = new Change();
  private static final LocalDnsHelper LOCAL_DNS_HELPER = LocalDnsHelper.create(0L); // synchronous
  private static final Map<DnsRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();
  private static final DnsRpc RPC =
      new DefaultDnsRpc(LOCAL_DNS_HELPER.options());
  private static final String REAL_PROJECT_ID = LOCAL_DNS_HELPER.options().projectId();
  private Map<String, Object> optionsMap;

  private ManagedZone minimalZone = new ManagedZone(); // to be adjusted as needed

  @BeforeClass
  public static void before() {
    RRSET1.setName(DNS_NAME);
    RRSET1.setType(RRSET_TYPE);
    RRSET1.setRrdatas(ImmutableList.of("1.1.1.1"));
    ZONE1.setName(ZONE_NAME1);
    ZONE1.setDescription("");
    ZONE1.setDnsName(DNS_NAME);
    ZONE1.setNameServerSet("somenameserveset");
    ZONE2.setName(ZONE_NAME2);
    ZONE2.setDescription("");
    ZONE2.setDnsName(DNS_NAME);
    ZONE2.setNameServerSet("somenameserveset");
    RRSET2.setName(DNS_NAME);
    RRSET2.setType(RRSET_TYPE);
    RRSET_KEEP.setName(DNS_NAME);
    RRSET_KEEP.setType("MX");
    RRSET_KEEP.setRrdatas(ImmutableList.of("255.255.255.254"));
    RRSET2.setRrdatas(ImmutableList.of("123.132.153.156"));
    CHANGE1.setAdditions(ImmutableList.of(RRSET1, RRSET2));
    CHANGE2.setDeletions(ImmutableList.of(RRSET2));
    CHANGE_KEEP.setAdditions(ImmutableList.of(RRSET_KEEP));
    CHANGE_COMPLEX.setAdditions(ImmutableList.of(RRSET_KEEP));
    CHANGE_COMPLEX.setDeletions(ImmutableList.of(RRSET_KEEP));
    LOCAL_DNS_HELPER.start();
  }

  @Before
  public void setUp() {
    resetProjects();
    optionsMap = new HashMap<>();
    minimalZone = copyZone(ZONE1);
  }

  private static void resetProjects() {
    for (String project : LOCAL_DNS_HELPER.projects().keySet()) {
      LOCAL_DNS_HELPER.projects().remove(project);
    }
  }

  @AfterClass
  public static void after() {
    LOCAL_DNS_HELPER.stop();
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
    assertNotNull(LocalDnsHelper.getUniqueId(Lists.<LocalDnsHelper.RrsetWrapper>newLinkedList()));
  }

  @Test
  public void testFindProject() {
    assertEquals(0, LOCAL_DNS_HELPER.projects().size());
    LocalDnsHelper.ProjectContainer project = LOCAL_DNS_HELPER.findProject(PROJECT_ID1);
    assertNotNull(project);
    assertTrue(LOCAL_DNS_HELPER.projects().containsKey(PROJECT_ID1));
    assertNotNull(LOCAL_DNS_HELPER.findProject(PROJECT_ID2));
    assertTrue(LOCAL_DNS_HELPER.projects().containsKey(PROJECT_ID2));
    assertTrue(LOCAL_DNS_HELPER.projects().containsKey(PROJECT_ID1));
    assertNotNull(project.zones());
    assertEquals(0, project.zones().size());
    assertNotNull(project.project());
    assertNotNull(project.project().getQuota());
  }

  @Test
  public void testCreateAndFindZone() {
    LocalDnsHelper.ZoneContainer zone1 = LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE_NAME1);
    assertTrue(LOCAL_DNS_HELPER.projects().containsKey(PROJECT_ID1));
    assertNull(zone1);
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null); // we do not care about options
    zone1 = LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE1.getName());
    assertNotNull(zone1);
    // cannot call equals because id and timestamp got assigned
    assertEquals(ZONE_NAME1, zone1.zone().getName());
    assertNotNull(zone1.changes());
    assertTrue(zone1.changes().isEmpty());
    assertNotNull(zone1.dnsRecords());
    assertEquals(2, zone1.dnsRecords().get(ZONE_NAME1).size()); // default SOA and NS
    LOCAL_DNS_HELPER.createZone(PROJECT_ID2, ZONE1, null); // project does not exits yet
    assertEquals(ZONE1.getName(),
        LOCAL_DNS_HELPER.findZone(PROJECT_ID2, ZONE_NAME1).zone().getName());
  }

  @Test
  public void testCreateAndFindZoneUsingRpc() {
    // zone does not exist yet
    ManagedZone zone1 = RPC.getZone(ZONE_NAME1, EMPTY_RPC_OPTIONS);
    assertTrue(LOCAL_DNS_HELPER.projects().containsKey(REAL_PROJECT_ID)); // check internal state
    assertNull(zone1);
    // create zone
    ManagedZone createdZone = RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    assertEquals(ZONE1.getName(), createdZone.getName());
    assertEquals(ZONE1.getDescription(), createdZone.getDescription());
    assertEquals(ZONE1.getDnsName(), createdZone.getDnsName());
    assertEquals(4, createdZone.getNameServers().size());
    // get the same zone zone
    ManagedZone zone = RPC.getZone(ZONE1.getName(), EMPTY_RPC_OPTIONS);
    assertEquals(createdZone, zone);
    // check that default records were created
    DnsRpc.ListResult<ResourceRecordSet> resourceRecordSetListResult
        = RPC.listDnsRecords(ZONE1.getName(), EMPTY_RPC_OPTIONS);
    assertEquals(2, Lists.newLinkedList(resourceRecordSetListResult.results()).size());
  }

  @Test
  public void testDeleteZone() {
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    LocalDnsHelper.Response response = LOCAL_DNS_HELPER.deleteZone(PROJECT_ID1, ZONE1.getName());
    assertEquals(204, response.code());
    // deleting non-existent zone
    response = LOCAL_DNS_HELPER.deleteZone(PROJECT_ID1, ZONE1.getName());
    assertEquals(404, response.code());
    assertNull(LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE1.getName()));
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE2, null);
    assertNotNull(LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE1.getName()));
    assertNotNull(LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE2.getName()));
    // delete in reverse order
    response = LOCAL_DNS_HELPER.deleteZone(PROJECT_ID1, ZONE1.getName());
    assertEquals(204, response.code());
    assertNull(LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE1.getName()));
    assertNotNull(LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE2.getName()));
    LOCAL_DNS_HELPER.deleteZone(PROJECT_ID1, ZONE2.getName());
    assertEquals(204, response.code());
    assertNull(LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE1.getName()));
    assertNull(LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE2.getName()));
  }

  @Test
  public void testDeleteZoneUsingRpc() {
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
  }

  @Test
  public void testCreateAndApplyChange() {
    LocalDnsHelper localDnsThreaded = LocalDnsHelper.create(5 * 1000L); // using threads here
    localDnsThreaded.createZone(PROJECT_ID1, ZONE1, null);
    assertNull(localDnsThreaded.findZone(PROJECT_ID1, ZONE_NAME1).findChange("1"));
    LocalDnsHelper.Response response
        = localDnsThreaded.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null); // add
    assertEquals(200, response.code());
    assertNotNull(localDnsThreaded.findZone(PROJECT_ID1, ZONE_NAME1).findChange("1"));
    assertNull(localDnsThreaded.findZone(PROJECT_ID1, ZONE_NAME1).findChange("2"));
    localDnsThreaded.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null); // add
    response = localDnsThreaded.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null); // add
    assertEquals(200, response.code());
    assertNotNull(localDnsThreaded.findZone(PROJECT_ID1, ZONE_NAME1).findChange("1"));
    assertNotNull(localDnsThreaded.findZone(PROJECT_ID1, ZONE_NAME1).findChange("2"));
    localDnsThreaded.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE2, null); // delete
    assertNotNull(localDnsThreaded.findZone(PROJECT_ID1, ZONE_NAME1).findChange("1"));
    assertNotNull(localDnsThreaded.findZone(PROJECT_ID1, ZONE_NAME1).findChange("2"));
    assertNotNull(localDnsThreaded.findZone(PROJECT_ID1, ZONE_NAME1).findChange("3"));
    localDnsThreaded.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE_KEEP, null); // id is "4"
    // check execution
    Change change = localDnsThreaded.findChange(PROJECT_ID1, ZONE_NAME1, "4");
    for (int i = 0; i < 10 && !change.getStatus().equals("done"); i++) {
      // change has not been finished yet; wait at most 20 seconds
      // it takes 5 seconds for the thread to kick in in the first place
      try {
        Thread.sleep(2 * 1000);
      } catch (InterruptedException e) {
        fail("Test was interrupted");
      }
    }
    assertEquals("done", change.getStatus());
    List<LocalDnsHelper.RrsetWrapper> list =
        localDnsThreaded.findZone(PROJECT_ID1, ZONE_NAME1).dnsRecords().get(ZONE_NAME1);
    assertTrue(list.contains(new LocalDnsHelper.RrsetWrapper(RRSET_KEEP)));
    localDnsThreaded.stop();
  }

  @Test
  public void testCreateAndApplyChangeUsingRpc() {
    // not using threads
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    assertNull(RPC.getChangeRequest(ZONE1.getName(), "1", EMPTY_RPC_OPTIONS));
    //add
    Change createdChange = RPC.applyChangeRequest(ZONE1.getName(), CHANGE1, EMPTY_RPC_OPTIONS);
    assertEquals(createdChange.getAdditions(), CHANGE1.getAdditions());
    assertEquals(createdChange.getDeletions(), CHANGE1.getDeletions());
    assertNotNull(createdChange.getStartTime());
    assertEquals("1", createdChange.getId());
    Change retrievedChange = RPC.getChangeRequest(ZONE1.getName(), "1", EMPTY_RPC_OPTIONS);
    assertEquals(createdChange, retrievedChange);
    assertNull(RPC.getChangeRequest(ZONE1.getName(), "2", EMPTY_RPC_OPTIONS));
    try {
      Change anotherChange = RPC.applyChangeRequest(ZONE1.getName(), CHANGE1, EMPTY_RPC_OPTIONS);
    } catch (DnsException ex) {
      assertEquals(409, ex.code());
    }
    assertNotNull(RPC.getChangeRequest(ZONE1.getName(), "1", EMPTY_RPC_OPTIONS));
    assertNull(RPC.getChangeRequest(ZONE1.getName(), "2", EMPTY_RPC_OPTIONS));
    // delete
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE2, EMPTY_RPC_OPTIONS);
    assertNotNull(RPC.getChangeRequest(ZONE1.getName(), "1", EMPTY_RPC_OPTIONS));
    assertNotNull(RPC.getChangeRequest(ZONE1.getName(), "2", EMPTY_RPC_OPTIONS));
    Change last = RPC.applyChangeRequest(ZONE1.getName(), CHANGE_KEEP, EMPTY_RPC_OPTIONS);
    assertEquals("done", last.getStatus());
    // todo(mderka) replace with real call
    List<LocalDnsHelper.RrsetWrapper> list =
        LOCAL_DNS_HELPER.findZone(REAL_PROJECT_ID, ZONE_NAME1).dnsRecords().get(ZONE_NAME1);
    assertTrue(list.contains(new LocalDnsHelper.RrsetWrapper(RRSET_KEEP)));
    Iterable<ResourceRecordSet> results =
        RPC.listDnsRecords(ZONE1.getName(), EMPTY_RPC_OPTIONS).results();
    boolean ok = false;
    for (ResourceRecordSet dnsRecord : results) {
      if (dnsRecord.getName().equals(RRSET_KEEP.getName())
          && dnsRecord.getType().equals(RRSET_KEEP.getType())) {
        ok = true;
      }
    }
    assertTrue(ok);
  }

  @Test
  public void testFindChange() {
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    Change change = LOCAL_DNS_HELPER.findChange(PROJECT_ID1, ZONE1.getName(), "somerandomchange");
    assertNull(change);
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE1.getName(), CHANGE1, null);
    // changes are sequential so we should find ID 1
    assertNotNull(LOCAL_DNS_HELPER.findChange(PROJECT_ID1, ZONE1.getName(), "1"));
    // add another
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE2, null);
    assertNotNull(LOCAL_DNS_HELPER.findChange(PROJECT_ID1, ZONE1.getName(), "1"));
    assertNotNull(LOCAL_DNS_HELPER.findChange(PROJECT_ID1, ZONE1.getName(), "2"));
    // try to find non-existent change
    assertNull(LOCAL_DNS_HELPER.findChange(PROJECT_ID1, ZONE1.getName(), "3"));
    // try to find a change in yet non-existent project
    assertNull(LOCAL_DNS_HELPER.findChange(PROJECT_ID2, ZONE1.getName(), "3"));
  }

  @Test
  public void testRandomNameServers() {
    assertEquals(4, LocalDnsHelper.randomNameservers().size());
    assertEquals(4, LocalDnsHelper.randomNameservers().size());
    assertEquals(4, LocalDnsHelper.randomNameservers().size());
    assertEquals(4, LocalDnsHelper.randomNameservers().size());
  }

  @Test
  public void testGetProject() {
    // only interested in no exceptions and non-null response here
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
  public void testGetZone() {
    // non-existent
    LocalDnsHelper.Response response = LOCAL_DNS_HELPER.getZone(PROJECT_ID1, ZONE_NAME1, null);
    assertEquals(404, response.code());
    assertTrue(response.body().contains("does not exist"));
    // existent
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    response = LOCAL_DNS_HELPER.getZone(PROJECT_ID1, ZONE1.getName(), null);
    assertEquals(200, response.code());
  }

  @Test
  public void testGetZoneUsingRpc() {
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
  public void testCreateZone() {
    // only interested in no exceptions and non-null response here
    LocalDnsHelper.Response response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    assertEquals(200, response.code());
    assertEquals(1, LOCAL_DNS_HELPER.projects().get(PROJECT_ID1).zones().size());
    try {
      LOCAL_DNS_HELPER.createZone(PROJECT_ID1, null, null);
      fail("Zone cannot be null");
    } catch (NullPointerException ex) {
      // expected
    }
    // create zone twice
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    assertEquals(409, response.code());
    assertTrue(response.body().contains("already exists"));
  }

  @Test
  public void testCreateZoneUsingRpc() {
    ManagedZone created = RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
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
  public void testCreateChange() {
    // non-existent zone
    LocalDnsHelper.Response response =
        LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null);
    assertEquals(404, response.code());
    // existent zone
    assertNotNull(LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null));
    assertNull(LOCAL_DNS_HELPER.findChange(PROJECT_ID1, ZONE_NAME1, "1"));
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null);
    assertEquals(200, response.code());
    assertNotNull(LOCAL_DNS_HELPER.findChange(PROJECT_ID1, ZONE_NAME1, "1"));
  }

  @Test
  public void testCreateChangeUsingRpc() {
    // non-existent zone
    try {
      RPC.applyChangeRequest(ZONE_NAME1, CHANGE1, EMPTY_RPC_OPTIONS);
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
    assertEquals(200, LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null).code());
    assertEquals(200, LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null).code());
    assertEquals(200, LOCAL_DNS_HELPER.getChange(PROJECT_ID1, ZONE_NAME1, "1", null).code());
    // non-existent
    LocalDnsHelper.Response response =
        LOCAL_DNS_HELPER.getChange(PROJECT_ID1, ZONE_NAME1, "2", null);
    assertEquals(404, response.code());
    assertTrue(response.body().contains("parameters.changeId"));
    // non-existent zone
    response = LOCAL_DNS_HELPER.getChange(PROJECT_ID1, ZONE_NAME2, "1", null);
    assertEquals(404, response.code());
    assertTrue(response.body().contains("parameters.managedZone"));
  }

  @Test
  public void testGetChangeUsingRpc() {
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
    } catch (DnsException ex) {
      // expected
      assertEquals(404, ex.code());
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
    // only interested in no exceptions and non-null response here
    optionsMap.put("dnsName", null);
    optionsMap.put("fields", null);
    optionsMap.put("pageToken", null);
    optionsMap.put("maxResults", null);
    LocalDnsHelper.Response response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    // some zones exists
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE2, null);
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    // error in options
    optionsMap.put("maxResults", "aaa");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "0");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "-1");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "15");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("dnsName", "aaa");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("dnsName", "aaa.");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
  }

  @Test
  public void testListZonesUsingRpc() {
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
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
    }
    options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, -1);
    try {
      RPC.listZones(options);
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
    }
    // ok size
    options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, 1);
    results = RPC.listZones(options).results();
    zones = ImmutableList.copyOf(results);
    assertEquals(1, zones.size());
    // dns name problems
    options = new HashMap<>();
    options.put(DnsRpc.Option.DNS_NAME, "aaa");
    try {
      RPC.listZones(options);
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
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
    DnsRpc.ListResult<ManagedZone> managedZoneListResult = RPC.listZones(options);
    zone = managedZoneListResult.results().iterator().next();
    assertNull(managedZoneListResult.pageToken());
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
    managedZoneListResult = RPC.listZones(options);
    zone = managedZoneListResult.results().iterator().next();
    assertNull(zone.getCreationTime());
    assertNotNull(zone.getName());
    assertNull(zone.getDnsName());
    assertNotNull(zone.getDescription());
    assertNull(zone.getNameServers());
    assertNotNull(zone.getNameServerSet());
    assertNotNull(zone.getId());
    assertEquals(zone.getName(), managedZoneListResult.pageToken());
    // paging
    options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, 1);
    managedZoneListResult = RPC.listZones(options);
    ImmutableList<ManagedZone> page1 = ImmutableList.copyOf(managedZoneListResult.results());
    assertEquals(1, page1.size());
    options.put(DnsRpc.Option.PAGE_TOKEN, managedZoneListResult.pageToken());
    managedZoneListResult = RPC.listZones(options);
    ImmutableList<ManagedZone> page2 = ImmutableList.copyOf(managedZoneListResult.results());
    assertEquals(1, page2.size());
    assertNotEquals(page1.get(0), page2.get(0));
  }

  @Test
  public void testListDnsRecords() {
    // only interested in no exceptions and non-null response here
    optionsMap.put("name", null);
    optionsMap.put("fields", null);
    optionsMap.put("type", null);
    optionsMap.put("pageToken", null);
    optionsMap.put("maxResults", null);
    // no zone exists
    LocalDnsHelper.Response response = LOCAL_DNS_HELPER.listDnsRecords(PROJECT_ID1, ZONE_NAME1,
        optionsMap);
    assertEquals(404, response.code());
    // zone exists but has no records
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    LOCAL_DNS_HELPER.listDnsRecords(PROJECT_ID1, ZONE_NAME1, optionsMap);
    // zone has records
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null);
    response = LOCAL_DNS_HELPER.listDnsRecords(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    // error in options
    optionsMap.put("maxResults", "aaa");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "0");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "-1");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "15");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("name", "aaa");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("name", "aaa.");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("name", null);
    optionsMap.put("type", "A");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("name", "aaa.");
    optionsMap.put("type", "a");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("name", "aaaa.");
    optionsMap.put("type", "A");
    response = LOCAL_DNS_HELPER.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
  }

  @Test
  public void testListDnsRecordsUsingRpc() {
    // no zone exists
    try {
      RPC.listDnsRecords(ZONE_NAME1, EMPTY_RPC_OPTIONS);
    } catch (DnsException ex) {
      // expected
      assertEquals(404, ex.code());
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
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
    }
    options.put(DnsRpc.Option.PAGE_SIZE, -1);
    try {
      RPC.listDnsRecords(ZONE1.getName(), options);
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
    }
    options.put(DnsRpc.Option.PAGE_SIZE, 1);
    results = RPC.listDnsRecords(ZONE1.getName(), options).results();
    records = ImmutableList.copyOf(results);
    assertEquals(1, records.size());
    options.put(DnsRpc.Option.PAGE_SIZE, 15);
    results = RPC.listDnsRecords(ZONE1.getName(), options).results();
    records = ImmutableList.copyOf(results);
    assertEquals(3, records.size());

    // dnsName filter
    options = new HashMap<>();
    options.put(DnsRpc.Option.NAME, "aaa");
    try {
      RPC.listDnsRecords(ZONE1.getName(), options);
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
    }
    options.put(DnsRpc.Option.NAME, "aaa.");
    results = RPC.listDnsRecords(ZONE1.getName(), options).results();
    records = ImmutableList.copyOf(results);
    assertEquals(0, records.size());
    options.put(DnsRpc.Option.NAME, null);
    options.put(DnsRpc.Option.DNS_TYPE, "A");
    try {
      RPC.listDnsRecords(ZONE1.getName(), options);
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
    }
    options.put(DnsRpc.Option.NAME, "aaa.");
    options.put(DnsRpc.Option.DNS_TYPE, "a");
    try {
      RPC.listDnsRecords(ZONE1.getName(), options);
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
    }
    options.put(DnsRpc.Option.NAME, DNS_NAME);
    options.put(DnsRpc.Option.DNS_TYPE, "SOA");
    results = RPC.listDnsRecords(ZONE1.getName(), options).results();
    records = ImmutableList.copyOf(results);
    assertEquals(1, records.size());
    // field options
    options = new HashMap<>();
    options.put(DnsRpc.Option.FIELDS, "rrsets(name)");
    DnsRpc.ListResult<ResourceRecordSet> resourceRecordSetListResult =
        RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(resourceRecordSetListResult.results());
    ResourceRecordSet record = records.get(0);
    assertNotNull(record.getName());
    assertNull(record.getRrdatas());
    assertNull(record.getType());
    assertNull(record.getTtl());
    assertNull(resourceRecordSetListResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "rrsets(rrdatas)");
    resourceRecordSetListResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(resourceRecordSetListResult.results());
    record = records.get(0);
    assertNull(record.getName());
    assertNotNull(record.getRrdatas());
    assertNull(record.getType());
    assertNull(record.getTtl());
    assertNull(resourceRecordSetListResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "rrsets(ttl)");
    resourceRecordSetListResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(resourceRecordSetListResult.results());
    record = records.get(0);
    assertNull(record.getName());
    assertNull(record.getRrdatas());
    assertNull(record.getType());
    assertNotNull(record.getTtl());
    assertNull(resourceRecordSetListResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "rrsets(type)");
    resourceRecordSetListResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(resourceRecordSetListResult.results());
    record = records.get(0);
    assertNull(record.getName());
    assertNull(record.getRrdatas());
    assertNotNull(record.getType());
    assertNull(record.getTtl());
    assertNull(resourceRecordSetListResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "nextPageToken");
    resourceRecordSetListResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(resourceRecordSetListResult.results());
    record = records.get(0);
    assertNull(record.getName());
    assertNull(record.getRrdatas());
    assertNull(record.getType());
    assertNull(record.getTtl());
    assertNull(resourceRecordSetListResult.pageToken());
    options.put(DnsRpc.Option.FIELDS, "nextPageToken,rrsets(name,rrdatas)");
    options.put(DnsRpc.Option.PAGE_SIZE, 1);
    resourceRecordSetListResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(resourceRecordSetListResult.results());
    assertEquals(1, records.size());
    record = records.get(0);
    assertNotNull(record.getName());
    assertNotNull(record.getRrdatas());
    assertNull(record.getType());
    assertNull(record.getTtl());
    assertNotNull(resourceRecordSetListResult.pageToken());
    // paging
    options.put(DnsRpc.Option.PAGE_TOKEN, resourceRecordSetListResult.pageToken());
    resourceRecordSetListResult = RPC.listDnsRecords(ZONE1.getName(), options);
    records = ImmutableList.copyOf(resourceRecordSetListResult.results());
    assertEquals(1, records.size());
    ResourceRecordSet nextRecord = records.get(0);
    assertNotEquals(record, nextRecord);
  }

  @Test
  public void testListChanges() {
    optionsMap.put("sortBy", null);
    optionsMap.put("sortOrder", null);
    optionsMap.put("fields", null);
    optionsMap.put("pageToken", null);
    optionsMap.put("maxResults", null);
    // no such zone exists
    LocalDnsHelper.Response response =
        LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(404, response.code());
    assertTrue(response.body().contains("managedZone"));
    // zone exists but has no changes
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    assertNotNull(LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap));
    // zone has changes
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null);
    assertNotNull(LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap));
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null);
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE2, null);
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE2, null);
    assertNotNull(LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap));
    // error in options
    optionsMap.put("maxResults", "aaa");
    response = LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "0");
    response = LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "-1");
    response = LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "15");
    response = LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("sortBy", "changeSequence");
    response = LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("sortBy", "something else");
    response = LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("Allowed values: [changesequence]"));
    optionsMap.put("sortBy", "ChAnGeSeQuEnCe"); // is not case sensitive
    response = LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("sortOrder", "ascending");
    response = LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("sortBy", null);
    optionsMap.put("sortOrder", "descending");
    response = LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("sortOrder", "somethingelse");
    response = LOCAL_DNS_HELPER.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("parameters.sortOrder"));
  }

  @Test
  public void testListChangesUsingRpc() {
    // no such zone exists
    try {
      RPC.listChangeRequests(ZONE_NAME1, EMPTY_RPC_OPTIONS);
    } catch (DnsException ex) {
      // expected
      assertEquals(404, ex.code());
    }
    // zone exists but has no changes
    RPC.create(ZONE1, EMPTY_RPC_OPTIONS);
    Iterable<Change> results = RPC.listChangeRequests(ZONE1.getName(), EMPTY_RPC_OPTIONS).results();
    ImmutableList<Change> changes = ImmutableList.copyOf(results);
    assertEquals(0, changes.size());
    // zone has changes
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE1, EMPTY_RPC_OPTIONS);
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE2, EMPTY_RPC_OPTIONS);
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE_KEEP, EMPTY_RPC_OPTIONS);
    results = RPC.listChangeRequests(ZONE1.getName(), EMPTY_RPC_OPTIONS).results();
    changes = ImmutableList.copyOf(results);
    assertEquals(3, changes.size());
    // error in options
    Map<DnsRpc.Option, Object> options = new HashMap<>();
    options.put(DnsRpc.Option.PAGE_SIZE, 0);
    try {
      RPC.listChangeRequests(ZONE1.getName(), options);
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
    }
    options.put(DnsRpc.Option.PAGE_SIZE, -1);
    try {
      RPC.listChangeRequests(ZONE1.getName(), options);
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
    }
    options.put(DnsRpc.Option.PAGE_SIZE, 15);
    try {
      RPC.listChangeRequests(ZONE1.getName(), options);
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
    }
    options = new HashMap<>();
    options.put(DnsRpc.Option.SORTING_ORDER, "descending");
    results = RPC.listChangeRequests(ZONE1.getName(), options).results();
    ImmutableList<Change> descending = ImmutableList.copyOf(results);
    results = RPC.listChangeRequests(ZONE1.getName(), EMPTY_RPC_OPTIONS).results();
    ImmutableList<Change> ascending = ImmutableList.copyOf(results);
    int size = 3;
    assertEquals(size, descending.size());
    for (int i = 0; i < size; i++) {
      assertEquals(descending.get(i), ascending.get(size - i - 1));
    }
    options.put(DnsRpc.Option.SORTING_ORDER, "something else");
    try {
      RPC.listChangeRequests(ZONE1.getName(), options);
    } catch (DnsException ex) {
      // expected
      assertEquals(400, ex.code());
    }
    // field options
    RPC.applyChangeRequest(ZONE1.getName(), CHANGE_COMPLEX, EMPTY_RPC_OPTIONS);
    options = new HashMap<>();
    options.put(DnsRpc.Option.SORTING_ORDER, "descending");
    options.put(DnsRpc.Option.FIELDS, "changes(additions)");
    DnsRpc.ListResult<Change> changeListResult =
        RPC.listChangeRequests(ZONE1.getName(), options);
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
    // paging
    options.put(DnsRpc.Option.FIELDS, "nextPageToken,changes(id)");
    options.put(DnsRpc.Option.PAGE_SIZE, 1);
    changeListResult = RPC.listChangeRequests(ZONE1.getName(), options);
    changes = ImmutableList.copyOf(changeListResult.results());
    assertEquals(1, changes.size());
    final Change first = changes.get(0);
    assertNotNull(changeListResult.pageToken());
    options.put(DnsRpc.Option.PAGE_TOKEN, changeListResult.pageToken());
    changeListResult = RPC.listChangeRequests(ZONE1.getName(), options);
    changes = ImmutableList.copyOf(changeListResult.results());
    assertEquals(1, changes.size());
    Change second = changes.get(0);
    assertNotEquals(first, second);
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
  public void testCheckZone() {
    // no name
    ManagedZone copy = copyZone(minimalZone);
    copy.setName(null);
    LocalDnsHelper.Response response = LocalDnsHelper.checkZone(copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.name"));
    // no description
    copy = copyZone(minimalZone);
    copy.setDescription(null);
    response = LocalDnsHelper.checkZone(copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.description"));
    // no description
    copy = copyZone(minimalZone);
    copy.setDnsName(null);
    response = LocalDnsHelper.checkZone(copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.dnsName"));
    // zone name is a number
    copy = copyZone(minimalZone);
    copy.setName("123456");
    response = LocalDnsHelper.checkZone(copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.name"));
    assertTrue(response.body().contains("Invalid"));
    // dns name does not end with period
    copy = copyZone(minimalZone);
    copy.setDnsName("aaaaaa.com");
    response = LocalDnsHelper.checkZone(copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.dnsName"));
    assertTrue(response.body().contains("Invalid"));
    // dns name is reserved
    copy = copyZone(minimalZone);
    copy.setDnsName("com.");
    response = LocalDnsHelper.checkZone(copy);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("not available to be created."));
    // empty description should pass
    copy = copyZone(minimalZone);
    copy.setDescription("");
    assertNull(LocalDnsHelper.checkZone(copy));
  }

  @Test
  public void testCreateZoneValidatesZone() {
    // no name
    ManagedZone copy = copyZone(minimalZone);
    copy.setName(null);
    LocalDnsHelper.Response response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.name"));
    // no description
    copy = copyZone(minimalZone);
    copy.setDescription(null);
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.description"));
    // no dns name
    copy = copyZone(minimalZone);
    copy.setDnsName(null);
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.dnsName"));
    // zone name is a number
    copy = copyZone(minimalZone);
    copy.setName("123456");
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.name"));
    assertTrue(response.body().contains("Invalid"));
    // dns name does not end with period
    copy = copyZone(minimalZone);
    copy.setDnsName("aaaaaa.com");
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.dnsName"));
    assertTrue(response.body().contains("Invalid"));
    // dns name is reserved
    copy = copyZone(minimalZone);
    copy.setDnsName("com.");
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("not available to be created."));
    // empty description should pass
    copy = copyZone(minimalZone);
    copy.setDescription("");
    response = LOCAL_DNS_HELPER.createZone(PROJECT_ID1, copy, null);
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
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
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
    assertTrue(LocalDnsHelper.checkRrData(":::::::", "AAAA"));
    assertTrue(LocalDnsHelper.checkRrData("1F:fa:09fd::343:aaaa:AAAA:", "AAAA"));
    assertTrue(LocalDnsHelper.checkRrData("0000:FFFF:09fd::343:aaaa:AAAA:", "AAAA"));
    assertFalse(LocalDnsHelper.checkRrData("-2:::::::", "AAAA"));
    assertTrue(LocalDnsHelper.checkRrData("0:::::::", "AAAA"));
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
    nonExistent.setRrdatas(ImmutableList.of(":::::::"));
    Change delete = new Change();
    delete.setDeletions(ImmutableList.of(nonExistent));
    response = LocalDnsHelper.checkChange(delete, zoneContainer);
    assertEquals(404, response.code());
    assertTrue(response.body().contains("deletions[0]"));

  }

  @Test
  public void testAdditionsMeetDeletions() {
    ResourceRecordSet validA = new ResourceRecordSet();
    validA.setName(ZONE1.getDnsName());
    validA.setType("A");
    validA.setRrdatas(ImmutableList.of("0.255.1.5"));
    Change validChange = new Change();
    validChange.setAdditions(ImmutableList.of(validA));
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    LocalDnsHelper.ZoneContainer container = LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE_NAME1);
    LocalDnsHelper.Response response =
        LocalDnsHelper.additionsMeetDeletions(ImmutableList.of(validA), null, container);
    assertEquals(409, response.code());
    assertTrue(response.body().contains("already exists"));

  }

  @Test
  public void testCreateChangeValidatesChangeContent() {
    ResourceRecordSet validA = new ResourceRecordSet();
    validA.setName(ZONE1.getDnsName());
    validA.setType("A");
    validA.setRrdatas(ImmutableList.of("0.255.1.5"));
    Change validChange = new Change();
    validChange.setAdditions(ImmutableList.of(validA));
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
    LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    LocalDnsHelper.Response response =
        LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(409, response.code());
    assertTrue(response.body().contains("already exists"));
    // delete with field mismatch
    Change delete = new Change();
    validA.setTtl(20); // mismatch
    delete.setDeletions(ImmutableList.of(validA));
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, delete, null);
    assertEquals(412, response.code());
    assertTrue(response.body().contains("entity.change.deletions[0]"));
    // delete and add SOA
    Change addition = new Change();
    ImmutableList<LocalDnsHelper.RrsetWrapper> rrsetWrappers
        = LOCAL_DNS_HELPER.findZone(PROJECT_ID1, ZONE_NAME1).dnsRecords().get(ZONE_NAME1);
    LinkedList<ResourceRecordSet> deletions = new LinkedList<>();
    LinkedList<ResourceRecordSet> additions = new LinkedList<>();
    for (LocalDnsHelper.RrsetWrapper wrapper : rrsetWrappers) {
      ResourceRecordSet rrset = wrapper.rrset();
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
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, delete, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "zone must contain exactly one resource record set of type 'SOA' at the apex"));
    assertTrue(response.body().contains("deletions[0]"));
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, addition, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "zone must contain exactly one resource record set of type 'SOA' at the apex"));
    assertTrue(response.body().contains("additions[0]"));
    // delete NS
    deletions = new LinkedList<>();
    additions = new LinkedList<>();
    for (LocalDnsHelper.RrsetWrapper wrapper : rrsetWrappers) {
      ResourceRecordSet rrset = wrapper.rrset();
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
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, delete, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "zone must contain exactly one resource record set of type 'NS' at the apex"));
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, addition, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "zone must contain exactly one resource record set of type 'NS' at the apex"));
    assertTrue(response.body().contains("additions[0]"));
    // change (delete + add)
    addition.setDeletions(deletions);
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, addition, null);
    assertEquals(200, response.code());
  }

  @Test
  public void testCreateChangeValidatesChange() {
    LOCAL_DNS_HELPER.createZone(PROJECT_ID1, ZONE1, null);
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
    LocalDnsHelper.Response response =
        LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(200, response.code());
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, invalidChange, null);
    assertEquals(400, response.code());
    // only empty additions/deletions
    Change empty = new Change();
    empty.setAdditions(ImmutableList.<ResourceRecordSet>of());
    empty.setDeletions(ImmutableList.<ResourceRecordSet>of());
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, empty, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "The 'entity.change' parameter is required but was missing."));
    // non-matching name
    validA.setName(ZONE1.getDnsName() + ".aaa.");
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].name"));
    // wrong type
    validA.setName(ZONE1.getDnsName()); // revert
    validA.setType("ABCD");
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].type"));
    // wrong ttl
    validA.setType("A"); // revert
    validA.setTtl(-1);
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].ttl"));
    validA.setTtl(null); // revert
    // null name
    validA.setName(null);
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].name"));
    validA.setName(ZONE1.getDnsName());
    // null type
    validA.setType(null);
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].type"));
    validA.setType("A");
    // null rrdata
    final List<String> temp = validA.getRrdatas(); // preserve
    validA.setRrdatas(null);
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].rrdata"));
    validA.setRrdatas(temp);
    // delete non-existent
    ResourceRecordSet nonExistent = new ResourceRecordSet();
    nonExistent.setName(ZONE1.getDnsName());
    nonExistent.setType("AAAA");
    nonExistent.setRrdatas(ImmutableList.of(":::::::"));
    Change delete = new Change();
    delete.setDeletions(ImmutableList.of(nonExistent));
    response = LOCAL_DNS_HELPER.createChange(PROJECT_ID1, ZONE_NAME1, delete, null);
    assertEquals(404, response.code());
    assertTrue(response.body().contains("deletions[0]"));
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
