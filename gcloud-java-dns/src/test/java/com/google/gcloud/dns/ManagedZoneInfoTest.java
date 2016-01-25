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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class ManagedZoneInfoTest {

  private static final String NAME = "mz-example.com";
  private static final BigInteger ID = BigInteger.valueOf(123L);
  private static final Long CREATION_TIME_MILLIS = 1123468321321L;
  private static final String DNS_NAME = "example.com.";
  private static final String DESCRIPTION = "description for the zone";
  private static final String NAME_SERVER_SET = "some set";
  private static final String NS1 = "name server 1";
  private static final String NS2 = "name server 2";
  private static final String NS3 = "name server 3";
  private static final List<String> NAME_SERVERS = ImmutableList.of(NS1, NS2, NS3);
  private static final ManagedZoneInfo INFO = ManagedZoneInfo.builder(NAME, ID)
      .creationTimeMillis(CREATION_TIME_MILLIS)
      .dnsName(DNS_NAME)
      .description(DESCRIPTION)
      .nameServerSet(NAME_SERVER_SET)
      .nameServers(NAME_SERVERS)
      .build();

  @Test
  public void testDefaultBuilders() {
    ManagedZoneInfo withName = ManagedZoneInfo.builder(NAME).build();
    assertTrue(withName.nameServers().isEmpty());
    assertEquals(NAME, withName.name());
    assertNull(withName.id());
    assertNull(withName.creationTimeMillis());
    assertNull(withName.nameServerSet());
    assertNull(withName.description());
    assertNull(withName.dnsName());
    ManagedZoneInfo withId = ManagedZoneInfo.builder(ID).build();
    assertTrue(withId.nameServers().isEmpty());
    assertEquals(ID, withId.id());
    assertNull(withId.name());
    assertNull(withId.creationTimeMillis());
    assertNull(withId.nameServerSet());
    assertNull(withId.description());
    assertNull(withId.dnsName());
    ManagedZoneInfo withBoth = ManagedZoneInfo.builder(NAME, ID).build();
    assertTrue(withBoth.nameServers().isEmpty());
    assertEquals(ID, withBoth.id());
    assertEquals(NAME, withBoth.name());
    assertNull(withBoth.creationTimeMillis());
    assertNull(withBoth.nameServerSet());
    assertNull(withBoth.description());
    assertNull(withBoth.dnsName());
  }

  @Test
  public void testBuilder() {
    assertEquals(3, INFO.nameServers().size());
    assertEquals(NS1, INFO.nameServers().get(0));
    assertEquals(NS2, INFO.nameServers().get(1));
    assertEquals(NS3, INFO.nameServers().get(2));
    assertEquals(NAME, INFO.name());
    assertEquals(ID, INFO.id());
    assertEquals(CREATION_TIME_MILLIS, INFO.creationTimeMillis());
    assertEquals(NAME_SERVER_SET, INFO.nameServerSet());
    assertEquals(DESCRIPTION, INFO.description());
    assertEquals(DNS_NAME, INFO.dnsName());
  }

  @Test
  public void testEqualsAndNotEquals() {
    ManagedZoneInfo clone = INFO.toBuilder().build();
    assertEquals(INFO, clone);
    List<String> moreServers = Lists.newLinkedList(NAME_SERVERS);
    moreServers.add(NS1);
    clone = INFO.toBuilder().nameServers(moreServers).build();
    assertNotEquals(INFO, clone);
    String differentName = "totally different name";
    clone = INFO.toBuilder().name(differentName).build();
    assertNotEquals(INFO, clone);
    clone = INFO.toBuilder().creationTimeMillis(INFO.creationTimeMillis() + 1).build();
    assertNotEquals(INFO, clone);
    clone = INFO.toBuilder().description(INFO.description() + "aaaa").build();
    assertNotEquals(INFO, clone);
    clone = INFO.toBuilder().dnsName(differentName).build();
    assertNotEquals(INFO, clone);
    clone = INFO.toBuilder().id(INFO.id().add(BigInteger.ONE)).build();
    assertNotEquals(INFO, clone);
    clone = INFO.toBuilder().nameServerSet(INFO.nameServerSet() + "salt").build();
    assertNotEquals(INFO, clone);
  }

  @Test
  public void testSameHashCodeOnEquals() {
    int hash = INFO.hashCode();
    ManagedZoneInfo clone = INFO.toBuilder().build();
    assertEquals(clone.hashCode(), hash);
  }

  @Test
  public void testToBuilder() {
    assertEquals(INFO, INFO.toBuilder().build());
    ManagedZoneInfo partial = ManagedZoneInfo.builder(NAME).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ManagedZoneInfo.builder(ID).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ManagedZoneInfo.builder(NAME).description(DESCRIPTION).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ManagedZoneInfo.builder(NAME).dnsName(DNS_NAME).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ManagedZoneInfo.builder(NAME).creationTimeMillis(CREATION_TIME_MILLIS).build();
    assertEquals(partial, partial.toBuilder().build());
    List<String> nameServers = new LinkedList<>();
    nameServers.add(NS1);
    partial = ManagedZoneInfo.builder(NAME).nameServers(nameServers).build();
    assertEquals(partial, partial.toBuilder().build());
    partial = ManagedZoneInfo.builder(NAME).nameServerSet(NAME_SERVER_SET).build();
    assertEquals(partial, partial.toBuilder().build());
  }

  @Test
  public void testToAndFromPb() {
    assertEquals(INFO, ManagedZoneInfo.fromPb(INFO.toPb()));
    ManagedZoneInfo partial = ManagedZoneInfo.builder(NAME).build();
    assertEquals(partial, ManagedZoneInfo.fromPb(partial.toPb()));
    partial = ManagedZoneInfo.builder(ID).build();
    assertEquals(partial, ManagedZoneInfo.fromPb(partial.toPb()));
    partial = ManagedZoneInfo.builder(NAME).description(DESCRIPTION).build();
    assertEquals(partial, ManagedZoneInfo.fromPb(partial.toPb()));
    partial = ManagedZoneInfo.builder(NAME).dnsName(DNS_NAME).build();
    assertEquals(partial, ManagedZoneInfo.fromPb(partial.toPb()));
    partial = ManagedZoneInfo.builder(NAME).creationTimeMillis(CREATION_TIME_MILLIS).build();
    assertEquals(partial, ManagedZoneInfo.fromPb(partial.toPb()));
    List<String> nameServers = new LinkedList<>();
    nameServers.add(NS1);
    partial = ManagedZoneInfo.builder(NAME).nameServers(nameServers).build();
    assertEquals(partial, ManagedZoneInfo.fromPb(partial.toPb()));
    partial = ManagedZoneInfo.builder(NAME).nameServerSet(NAME_SERVER_SET).build();
    assertEquals(partial, ManagedZoneInfo.fromPb(partial.toPb()));
  }

  @Test
  public void testEmptyNameServers() {
    ManagedZoneInfo clone = INFO.toBuilder().nameServers(new LinkedList<String>()).build();
    assertTrue(clone.nameServers().isEmpty());
    clone.toPb(); // test that this is allowed
  }

  @Test
  public void testDateParsing() {
    com.google.api.services.dns.model.ManagedZone pb = INFO.toPb();
    pb.setCreationTime("2016-01-19T18:00:12.854Z"); // a real value obtained from Google Cloud DNS
    ManagedZoneInfo mz = ManagedZoneInfo.fromPb(pb); // parses the string timestamp to millis
    com.google.api.services.dns.model.ManagedZone pbClone = mz.toPb(); // converts it back to string
    assertEquals(pb, pbClone);
    assertEquals(pb.getCreationTime(), pbClone.getCreationTime());
  }
}
