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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import org.junit.After;
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
  private Map<String, Object> optionsMap;
  private LocalDnsHelper localDns;
  private ManagedZone minimalZone = new ManagedZone(); // to be adjusted as needed

  @BeforeClass
  public static void before() {
    RRSET1.setName(DNS_NAME);
    RRSET1.setType(RRSET_TYPE);
    RRSET1.setRrdatas(ImmutableList.of("1.1.1.1"));
    ZONE1.setName(ZONE_NAME1);
    ZONE1.setDescription("");
    ZONE1.setDnsName(DNS_NAME);
    ZONE2.setName(ZONE_NAME2);
    ZONE2.setDescription("");
    ZONE2.setDnsName(DNS_NAME);
    RRSET2.setName(DNS_NAME);
    RRSET2.setType(RRSET_TYPE);
    RRSET_KEEP.setName(DNS_NAME);
    RRSET_KEEP.setType("MX");
    RRSET_KEEP.setRrdatas(ImmutableList.of("255.255.255.254"));
    RRSET2.setRrdatas(ImmutableList.of("123.132.153.156"));
    CHANGE1.setAdditions(ImmutableList.of(RRSET1, RRSET2));
    CHANGE2.setDeletions(ImmutableList.of(RRSET2));
    CHANGE_KEEP.setAdditions(ImmutableList.of(RRSET_KEEP));
  }

  @Before
  public void setUp() {
    localDns = LocalDnsHelper.create(0L); // synchronous
    optionsMap = new HashMap<>();
    minimalZone = copyZone(ZONE1);
  }

  @After
  public void after() {
    localDns = null;
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
    assertEquals(0, localDns.projects().size());
    LocalDnsHelper.ProjectContainer project = localDns.findProject(PROJECT_ID1);
    assertNotNull(project);
    assertTrue(localDns.projects().containsKey(PROJECT_ID1));
    assertNotNull(localDns.findProject(PROJECT_ID2));
    assertTrue(localDns.projects().containsKey(PROJECT_ID2));
    assertTrue(localDns.projects().containsKey(PROJECT_ID1));
    assertNotNull(project.zones());
    assertEquals(0, project.zones().size());
    assertNotNull(project.project());
    assertNotNull(project.project().getQuota());
  }

  @Test
  public void testCreateAndFindZone() {
    LocalDnsHelper.ZoneContainer zone1 = localDns.findZone(PROJECT_ID1, ZONE_NAME1);
    assertTrue(localDns.projects().containsKey(PROJECT_ID1));
    assertNull(zone1);
    localDns.createZone(PROJECT_ID1, ZONE1, null); // we do not care about options
    zone1 = localDns.findZone(PROJECT_ID1, ZONE1.getName());
    assertNotNull(zone1);
    // cannot call equals because id and timestamp got assigned
    assertEquals(ZONE_NAME1, zone1.zone().getName());
    assertNotNull(zone1.changes());
    assertTrue(zone1.changes().isEmpty());
    assertNotNull(zone1.dnsRecords());
    assertEquals(2, zone1.dnsRecords().get(ZONE_NAME1).size()); // default SOA and NS
    localDns.createZone(PROJECT_ID2, ZONE1, null); // project does not exits yet
    assertEquals(ZONE1.getName(), localDns.findZone(PROJECT_ID2, ZONE_NAME1).zone().getName());
  }

  @Test
  public void testDeleteZone() {
    localDns.createZone(PROJECT_ID1, ZONE1, null);
    LocalDnsHelper.Response response = localDns.deleteZone(PROJECT_ID1, ZONE1.getName());
    assertEquals(204, response.code());
    // deleting non-existent zone
    response = localDns.deleteZone(PROJECT_ID1, ZONE1.getName());
    assertEquals(404, response.code());
    assertNull(localDns.findZone(PROJECT_ID1, ZONE1.getName()));
    localDns.createZone(PROJECT_ID1, ZONE1, null);
    localDns.createZone(PROJECT_ID1, ZONE2, null);
    assertNotNull(localDns.findZone(PROJECT_ID1, ZONE1.getName()));
    assertNotNull(localDns.findZone(PROJECT_ID1, ZONE2.getName()));
    // delete in reverse order
    response = localDns.deleteZone(PROJECT_ID1, ZONE1.getName());
    assertEquals(204, response.code());
    assertNull(localDns.findZone(PROJECT_ID1, ZONE1.getName()));
    assertNotNull(localDns.findZone(PROJECT_ID1, ZONE2.getName()));
    localDns.deleteZone(PROJECT_ID1, ZONE2.getName());
    assertEquals(204, response.code());
    assertNull(localDns.findZone(PROJECT_ID1, ZONE1.getName()));
    assertNull(localDns.findZone(PROJECT_ID1, ZONE2.getName()));
  }

  @Test
  public void testCreateAndApplyChange() {
    localDns = LocalDnsHelper.create(5 * 1000L); // we will be using threads here
    localDns.createZone(PROJECT_ID1, ZONE1, null);
    assertNull(localDns.findZone(PROJECT_ID1, ZONE_NAME1).findChange("1"));
    LocalDnsHelper.Response response
        = localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null); // add
    assertEquals(200, response.code());
    assertNotNull(localDns.findZone(PROJECT_ID1, ZONE_NAME1).findChange("1"));
    assertNull(localDns.findZone(PROJECT_ID1, ZONE_NAME1).findChange("2"));
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null); // add
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null); // add
    assertEquals(200, response.code());
    assertNotNull(localDns.findZone(PROJECT_ID1, ZONE_NAME1).findChange("1"));
    assertNotNull(localDns.findZone(PROJECT_ID1, ZONE_NAME1).findChange("2"));
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE2, null); // delete
    assertNotNull(localDns.findZone(PROJECT_ID1, ZONE_NAME1).findChange("1"));
    assertNotNull(localDns.findZone(PROJECT_ID1, ZONE_NAME1).findChange("2"));
    assertNotNull(localDns.findZone(PROJECT_ID1, ZONE_NAME1).findChange("3"));
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE_KEEP, null); // id is "4"
    // check execution
    Change change = localDns.findChange(PROJECT_ID1, ZONE_NAME1, "4");
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
        localDns.findZone(PROJECT_ID1, ZONE_NAME1).dnsRecords().get(ZONE_NAME1);
    assertTrue(list.contains(new LocalDnsHelper.RrsetWrapper(RRSET_KEEP)));
  }

  @Test
  public void testFindChange() {
    localDns.createZone(PROJECT_ID1, ZONE1, null);
    Change change = localDns.findChange(PROJECT_ID1, ZONE1.getName(), "somerandomchange");
    assertNull(change);
    localDns.createChange(PROJECT_ID1, ZONE1.getName(), CHANGE1, null);
    // changes are sequential so we should find ID 1
    assertNotNull(localDns.findChange(PROJECT_ID1, ZONE1.getName(), "1"));
    // add another
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE2, null);
    assertNotNull(localDns.findChange(PROJECT_ID1, ZONE1.getName(), "1"));
    assertNotNull(localDns.findChange(PROJECT_ID1, ZONE1.getName(), "2"));
    // try to find non-existent change
    assertNull(localDns.findChange(PROJECT_ID1, ZONE1.getName(), "3"));
    // try to find a change in yet non-existent project
    assertNull(localDns.findChange(PROJECT_ID2, ZONE1.getName(), "3"));
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
    assertNotNull(localDns.getProject(PROJECT_ID1, null));
    assertNotNull(localDns.getProject(PROJECT_ID2, null));
  }

  @Test
  public void testGetZone() {
    // non-existent
    LocalDnsHelper.Response response = localDns.getZone(PROJECT_ID1, ZONE_NAME1, null);
    assertEquals(404, response.code());
    assertTrue(response.body().contains("does not exist"));
    // existent
    localDns.createZone(PROJECT_ID1, ZONE1, null);
    response = localDns.getZone(PROJECT_ID1, ZONE1.getName(), null);
    assertEquals(200, response.code());
  }

  @Test
  public void testCreateZone() {
    // only interested in no exceptions and non-null response here
    LocalDnsHelper.Response response = localDns.createZone(PROJECT_ID1, ZONE1, null);
    assertEquals(200, response.code());
    assertEquals(1, localDns.projects().get(PROJECT_ID1).zones().size());
    try {
      localDns.createZone(PROJECT_ID1, null, null);
      fail("Zone cannot be null");
    } catch (NullPointerException ex) {
      // expected
    }
    // create zone twice
    response = localDns.createZone(PROJECT_ID1, ZONE1, null);
    assertEquals(409, response.code());
    assertTrue(response.body().contains("already exists"));
  }

  @Test
  public void testCreateChange() {
    // non-existent zone
    LocalDnsHelper.Response response =
        localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null);
    assertEquals(404, response.code());

    // existent zone
    assertNotNull(localDns.createZone(PROJECT_ID1, ZONE1, null));
    assertNull(localDns.findChange(PROJECT_ID1, ZONE_NAME1, "1"));
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null);
    assertEquals(200, response.code());
    assertNotNull(localDns.findChange(PROJECT_ID1, ZONE_NAME1, "1"));
  }

  @Test
  public void testGetChange() {
    // existent
    assertEquals(200, localDns.createZone(PROJECT_ID1, ZONE1, null).code());
    assertEquals(200, localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null).code());
    assertEquals(200, localDns.getChange(PROJECT_ID1, ZONE_NAME1, "1", null).code());
    // non-existent
    LocalDnsHelper.Response response = localDns.getChange(PROJECT_ID1, ZONE_NAME1, "2", null);
    assertEquals(404, response.code());
    assertTrue(response.body().contains("parameters.changeId"));
    // non-existent zone
    response = localDns.getChange(PROJECT_ID1, ZONE_NAME2, "1", null);
    assertEquals(404, response.code());
    assertTrue(response.body().contains("parameters.managedZone"));
  }

  @Test
  public void testListZones() {
    // only interested in no exceptions and non-null response here
    optionsMap.put("dnsName", null);
    optionsMap.put("fields", null);
    optionsMap.put("pageToken", null);
    optionsMap.put("maxResults", null);
    LocalDnsHelper.Response response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    // some zones exists
    localDns.createZone(PROJECT_ID1, ZONE1, null);
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    localDns.createZone(PROJECT_ID1, ZONE2, null);
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    // error in options
    optionsMap.put("maxResults", "aaa");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "0");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "-1");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "15");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("dnsName", "aaa");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("dnsName", "aaa.");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
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
    LocalDnsHelper.Response response = localDns.listDnsRecords(PROJECT_ID1, ZONE_NAME1,
        optionsMap);
    assertEquals(404, response.code());
    // zone exists but has no records
    localDns.createZone(PROJECT_ID1, ZONE1, null);
    localDns.listDnsRecords(PROJECT_ID1, ZONE_NAME1, optionsMap);
    // zone has records
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null);
    response = localDns.listDnsRecords(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    // error in options
    optionsMap.put("maxResults", "aaa");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "0");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "-1");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "15");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("name", "aaa");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("name", "aaa.");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("name", null);
    optionsMap.put("type", "A");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("name", "aaa.");
    optionsMap.put("type", "a");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("name", "aaaa.");
    optionsMap.put("type", "A");
    response = localDns.listZones(PROJECT_ID1, optionsMap);
    assertEquals(200, response.code());
  }

  @Test
  public void testListChanges() {
    optionsMap.put("sortBy", null);
    optionsMap.put("sortOrder", null);
    optionsMap.put("fields", null);
    optionsMap.put("pageToken", null);
    optionsMap.put("maxResults", null);
    // no such zone exists
    LocalDnsHelper.Response response = localDns.listDnsRecords(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(404, response.code());
    assertTrue(response.body().contains("managedZone"));
    // zone exists but has no changes
    localDns.createZone(PROJECT_ID1, ZONE1, null);
    assertNotNull(localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap));
    // zone has changes
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null);
    assertNotNull(localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap));
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE1, null);
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE2, null);
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, CHANGE2, null);
    assertNotNull(localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap));
    // error in options
    optionsMap.put("maxResults", "aaa");
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "0");
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "-1");
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("maxResults", "15");
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("dnsName", "aaa");
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(400, response.code());
    optionsMap.put("dnsName", "aaa.");
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("sortBy", "changeSequence");
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("sortBy", "something else");
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("Allowed values: [changesequence]"));
    optionsMap.put("sortBy", "ChAnGeSeQuEnCe"); // is not case sensitive
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("sortOrder", "ascending");
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("sortBy", null);
    optionsMap.put("sortOrder", "descending");
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(200, response.code());
    optionsMap.put("sortOrder", "somethingelse");
    response = localDns.listChanges(PROJECT_ID1, ZONE_NAME1, optionsMap);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("parameters.sortOrder"));
  }

  @Test
  public void testToListResponse() {
    LocalDnsHelper.Response response = LocalDnsHelper.toListResponse(
        Lists.newArrayList("some", "multiple", "words"), "IncludeThisPageToken", true);
    assertTrue(response.body().contains("IncludeThisPageToken"));
    response = LocalDnsHelper.toListResponse(
        Lists.newArrayList("some", "multiple", "words"), "IncludeThisPageToken", false);
    assertFalse(response.body().contains("IncludeThisPageToken"));
    response = LocalDnsHelper.toListResponse(
        Lists.newArrayList("some", "multiple", "words"), null, true);
    assertFalse(response.body().contains("pageToken"));
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
    LocalDnsHelper.Response response = localDns.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.name"));
    // no description
    copy = copyZone(minimalZone);
    copy.setDescription(null);
    response = localDns.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.description"));
    // no dns name
    copy = copyZone(minimalZone);
    copy.setDnsName(null);
    response = localDns.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.dnsName"));
    // zone name is a number
    copy = copyZone(minimalZone);
    copy.setName("123456");
    response = localDns.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.name"));
    assertTrue(response.body().contains("Invalid"));
    // dns name does not end with period
    copy = copyZone(minimalZone);
    copy.setDnsName("aaaaaa.com");
    response = localDns.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("entity.managedZone.dnsName"));
    assertTrue(response.body().contains("Invalid"));
    // dns name is reserved
    copy = copyZone(minimalZone);
    copy.setDnsName("com.");
    response = localDns.createZone(PROJECT_ID1, copy, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("not available to be created."));
    // empty description should pass
    copy = copyZone(minimalZone);
    copy.setDescription("");
    response = localDns.createZone(PROJECT_ID1, copy, null);
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
    localDns.createZone(PROJECT_ID1, ZONE1, null);
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    // delete with field mismatch
    LocalDnsHelper.ZoneContainer zone = localDns.findZone(PROJECT_ID1, ZONE_NAME1);
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
    List<String> temp = validA.getRrdatas(); // preserve
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
    localDns.createZone(PROJECT_ID1, ZONE1, null);
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    LocalDnsHelper.ZoneContainer container = localDns.findZone(PROJECT_ID1, ZONE_NAME1);
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
    localDns.createZone(PROJECT_ID1, ZONE1, null);
    localDns.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    LocalDnsHelper.Response response =
        localDns.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(409, response.code());
    assertTrue(response.body().contains("already exists"));
    // delete with field mismatch
    Change delete = new Change();
    validA.setTtl(20); // mismatch
    delete.setDeletions(ImmutableList.of(validA));
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, delete, null);
    assertEquals(412, response.code());
    assertTrue(response.body().contains("entity.change.deletions[0]"));
    // delete and add SOA
    Change addition = new Change();
    ImmutableList<LocalDnsHelper.RrsetWrapper> rrsetWrappers
        = localDns.findZone(PROJECT_ID1, ZONE_NAME1).dnsRecords().get(ZONE_NAME1);
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
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, delete, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "zone must contain exactly one resource record set of type 'SOA' at the apex"));
    assertTrue(response.body().contains("deletions[0]"));
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, addition, null);
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
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, delete, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "zone must contain exactly one resource record set of type 'NS' at the apex"));
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, addition, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "zone must contain exactly one resource record set of type 'NS' at the apex"));
    assertTrue(response.body().contains("additions[0]"));
    // change (delete + add)
    addition.setDeletions(deletions);
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, addition, null);
    assertEquals(200, response.code());
  }

  @Test
  public void testCreateChangeValidatesChange() {
    localDns.createZone(PROJECT_ID1, ZONE1, null);
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
        localDns.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(200, response.code());
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, invalidChange, null);
    assertEquals(400, response.code());
    // only empty additions/deletions
    Change empty = new Change();
    empty.setAdditions(ImmutableList.<ResourceRecordSet>of());
    empty.setDeletions(ImmutableList.<ResourceRecordSet>of());
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, empty, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains(
        "The 'entity.change' parameter is required but was missing."));
    // non-matching name
    validA.setName(ZONE1.getDnsName() + ".aaa.");
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].name"));
    // wrong type
    validA.setName(ZONE1.getDnsName()); // revert
    validA.setType("ABCD");
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].type"));
    // wrong ttl
    validA.setType("A"); // revert
    validA.setTtl(-1);
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].ttl"));
    validA.setTtl(null); // revert
    // null name
    validA.setName(null);
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].name"));
    validA.setName(ZONE1.getDnsName());
    // null type
    validA.setType(null);
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
    assertEquals(400, response.code());
    assertTrue(response.body().contains("additions[0].type"));
    validA.setType("A");
    // null rrdata
    List<String> temp = validA.getRrdatas(); // preserve
    validA.setRrdatas(null);
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, validChange, null);
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
    response = localDns.createChange(PROJECT_ID1, ZONE_NAME1, delete, null);
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
