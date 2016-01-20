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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.collect.Lists;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class ManagedZoneInfoTest {

  private static final String NAME = "mz-example.com";
  private static final Long ID = 123L;
  private static final Long CREATION_TIME_MILLIS = 1123468321321L;
  private static final String DNS_NAME = "example.com.";
  private static final String DESCRIPTION = "description for the zone";
  private static final String NAME_SERVER_SET = "some set";
  private static final String NS1 = "name server 1";
  private static final String NS2 = "name server 2";
  private static final String NS3 = "name server 3";
  private static List<String> nameServers = new LinkedList<>();
  private static ManagedZoneInfo info;

  @BeforeClass
  public static void setUp() {
    nameServers.add(NS1);
    nameServers.add(NS2);
    nameServers.add(NS3);
    assertEquals(3, nameServers.size());
    info = ManagedZoneInfo.builder(NAME, ID)
        .creationTimeMillis(CREATION_TIME_MILLIS)
        .dnsName(DNS_NAME)
        .description(DESCRIPTION)
        .nameServerSet(NAME_SERVER_SET)
        .nameServers(nameServers)
        .build();
    System.out.println(info);
  }

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
    assertEquals(3, info.nameServers().size());
    assertEquals(NS1, info.nameServers().get(0));
    assertEquals(NS2, info.nameServers().get(1));
    assertEquals(NS3, info.nameServers().get(2));
    assertEquals(NAME, info.name());
    assertEquals(ID, info.id());
    assertEquals(CREATION_TIME_MILLIS, info.creationTimeMillis());
    assertEquals(NAME_SERVER_SET, info.nameServerSet());
    assertEquals(DESCRIPTION, info.description());
    assertEquals(DNS_NAME, info.dnsName());
  }

  @Test
  public void testValidCreationTime() {
    try {
      ManagedZoneInfo.builder(NAME).creationTimeMillis(-1);
      fail("A negative value is not acceptable for creation time.");
    } catch (IllegalArgumentException e) {
      // expected
    }
    ManagedZoneInfo.builder(NAME).creationTimeMillis(0);
    ManagedZoneInfo.builder(NAME).creationTimeMillis(Long.MAX_VALUE);
  }

  @Test
  public void testEqualsAndNotEquals() {
    ManagedZoneInfo clone = info.toBuilder().build();
    assertEquals(clone, info);
    List<String> moreServers = Lists.newLinkedList(nameServers);
    moreServers.add(NS1);
    clone = info.toBuilder().nameServers(moreServers).build();
    assertNotEquals(clone, info);
    String differentName = "totally different name";
    clone = info.toBuilder().name(differentName).build();
    assertNotEquals(clone, info);
    clone = info.toBuilder().creationTimeMillis(info.creationTimeMillis() + 1).build();
    assertNotEquals(clone, info);
    clone = info.toBuilder().description(info.description() + "aaaa").build();
    assertNotEquals(clone, info);
    clone = info.toBuilder().dnsName(differentName).build();
    assertNotEquals(clone, info);
    clone = info.toBuilder().id(info.id() + 1).build();
    assertNotEquals(clone, info);
    clone = info.toBuilder().nameServerSet(info.nameServerSet() + "salt").build();
    assertNotEquals(clone, info);
  }

  @Test
  public void testSameHashCodeOnEquals() {
    int hash = info.hashCode();
    ManagedZoneInfo clone = info.toBuilder().build();
    assertEquals(clone.hashCode(), hash);
  }

  @Test
  public void testToBuilder() {
    assertEquals(info, info.toBuilder().build());
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
    assertEquals(info, ManagedZoneInfo.fromPb(info.toPb()));
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
  public void testClearNameServers() {
    ManagedZoneInfo clone = info.toBuilder().build();
    assertFalse(clone.nameServers().isEmpty());
    clone = clone.toBuilder().clearNameServers().build();
    assertTrue(clone.nameServers().isEmpty());
    clone.toPb(); // test that this is allowed
  }
}
