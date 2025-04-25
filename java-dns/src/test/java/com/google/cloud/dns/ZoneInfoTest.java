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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.services.dns.model.ManagedZone;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class ZoneInfoTest {

  private static final String NAME = "mz-example.com";
  private static final String GENERATED_ID = "123456";
  private static final Long CREATION_TIME_MILLIS = 1123468321321L;
  private static final String DNS_NAME = "example.com.";
  private static final String DESCRIPTION = "description for the zone";
  private static final String NAME_SERVER_SET = "some set";
  private static final String NS1 = "name server 1";
  private static final String NS2 = "name server 2";
  private static final String NS3 = "name server 3";
  private static final List<String> NAME_SERVERS = ImmutableList.of(NS1, NS2, NS3);
  private static final Map<String, String> LABELS =
      ImmutableMap.of("label1", "value1", "label2", "value2");
  private static final String ALGORITHM = "rsasha256";
  private static final String KEY_TYPE1 = "zoneSigning";
  private static final String KEY_TYPE2 = "keySigning";
  private static final String STATE = "off";
  private static final String NON_EXISTENCE = "nsec";
  private static final Long ZSK_KEY_LENGTH = 1024L;
  private static final Long KSK_KEY_LENGTH = 2048L;
  private static final ZoneInfo.KeySpec ZONE_SIGNING_KEY_SPEC =
      ZoneInfo.KeySpec.newBuilder()
          .setAlgorithm(ALGORITHM)
          .setKeyLength(ZSK_KEY_LENGTH)
          .setKeyType(KEY_TYPE1)
          .build();
  private static final ZoneInfo.KeySpec KEY_SIGNING_KEY_SPEC =
      ZoneInfo.KeySpec.newBuilder()
          .setAlgorithm(ALGORITHM)
          .setKeyLength(KSK_KEY_LENGTH)
          .setKeyType(KEY_TYPE2)
          .build();
  private static final List<ZoneInfo.KeySpec> DEFAULT_KEY_SPECS =
      ImmutableList.of(ZONE_SIGNING_KEY_SPEC, KEY_SIGNING_KEY_SPEC);
  private static final ZoneInfo.DnsSecConfig DNS_SEC_CONFIG =
      ZoneInfo.DnsSecConfig.newBuilder()
          .setDefaultKeySpecs(DEFAULT_KEY_SPECS)
          .setState(STATE)
          .setNonExistence(NON_EXISTENCE)
          .build();
  private static final ZoneInfo INFO =
      ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION)
          .toBuilder()
          .setCreationTimeMillis(CREATION_TIME_MILLIS)
          .setGeneratedId(GENERATED_ID)
          .setNameServerSet(NAME_SERVER_SET)
          .setNameServers(NAME_SERVERS)
          .setDnsSecConfig(DNS_SEC_CONFIG)
          .setLabels(LABELS)
          .build();

  @Test
  public void testOf() {
    ZoneInfo partial = ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION);
    assertTrue(partial.getNameServers().isEmpty());
    assertEquals(NAME, partial.getName());
    assertNull(partial.getGeneratedId());
    assertNull(partial.getCreationTimeMillis());
    assertNull(partial.getNameServerSet());
    assertEquals(DESCRIPTION, partial.getDescription());
    assertEquals(DNS_NAME, partial.getDnsName());
  }

  @Test
  public void testBuilder() {
    assertEquals(3, INFO.getNameServers().size());
    assertEquals(NS1, INFO.getNameServers().get(0));
    assertEquals(NS2, INFO.getNameServers().get(1));
    assertEquals(NS3, INFO.getNameServers().get(2));
    assertEquals(NAME, INFO.getName());
    assertEquals(GENERATED_ID, INFO.getGeneratedId());
    assertEquals(CREATION_TIME_MILLIS, INFO.getCreationTimeMillis());
    assertEquals(NAME_SERVER_SET, INFO.getNameServerSet());
    assertEquals(DESCRIPTION, INFO.getDescription());
    assertEquals(DNS_NAME, INFO.getDnsName());
    assertEquals(DNS_SEC_CONFIG, INFO.getDnsSecConfig());
    assertEquals(LABELS, INFO.getLabels());

    ZoneInfo.DnsSecConfig config = INFO.getDnsSecConfig();
    assertEquals(DEFAULT_KEY_SPECS, config.getDefaultKeySpecs());
    assertEquals(STATE, config.getState());
    assertEquals(NON_EXISTENCE, config.getNonExistence());

    List<ZoneInfo.KeySpec> keySpecs = config.getDefaultKeySpecs();
    ZoneInfo.KeySpec zoneSigningKeySpec = keySpecs.get(0);
    assertEquals(ALGORITHM, zoneSigningKeySpec.getAlgorithm());
    assertEquals(KEY_TYPE1, zoneSigningKeySpec.getKeyType());
    assertEquals(ZSK_KEY_LENGTH, zoneSigningKeySpec.getKeyLength());

    ZoneInfo.KeySpec keySigningKeySpec = keySpecs.get(1);
    assertEquals(ALGORITHM, keySigningKeySpec.getAlgorithm());
    assertEquals(KEY_TYPE2, keySigningKeySpec.getKeyType());
    assertEquals(KSK_KEY_LENGTH, keySigningKeySpec.getKeyLength());
  }

  @Test
  public void testEqualsAndNotEquals() {
    ZoneInfo clone = INFO.toBuilder().build();
    assertEquals(INFO, clone);
    List<String> moreServers = Lists.newLinkedList(NAME_SERVERS);
    moreServers.add(NS1);
    clone = INFO.toBuilder().setNameServers(moreServers).build();
    assertNotEquals(INFO, clone);
    String differentName = "totally different name";
    clone = INFO.toBuilder().setName(differentName).build();
    assertNotEquals(INFO, clone);
    clone = INFO.toBuilder().setCreationTimeMillis(INFO.getCreationTimeMillis() + 1).build();
    assertNotEquals(INFO, clone);
    clone = INFO.toBuilder().setDescription(INFO.getDescription() + "aaaa").build();
    assertNotEquals(INFO, clone);
    clone = INFO.toBuilder().setDnsName(differentName).build();
    assertNotEquals(INFO, clone);
    clone = INFO.toBuilder().setGeneratedId(INFO.getGeneratedId() + "1111").build();
    assertNotEquals(INFO, clone);
    clone = INFO.toBuilder().setNameServerSet(INFO.getNameServerSet() + "salt").build();
    assertNotEquals(INFO, clone);
    clone =
        INFO.toBuilder()
            .setDnsSecConfig(DNS_SEC_CONFIG.toBuilder().setNonExistence("nsec3").build())
            .build();
    assertNotEquals(INFO, clone);
  }

  @Test
  public void testSameHashCodeOnEquals() {
    int hash = INFO.hashCode();
    ZoneInfo clone = INFO.toBuilder().build();
    assertEquals(clone.hashCode(), hash);

    int dnsSecConfigHas = DNS_SEC_CONFIG.hashCode();
    ZoneInfo.DnsSecConfig dnsSecConfig = DNS_SEC_CONFIG.toBuilder().build();
    assertEquals(dnsSecConfig.hashCode(), dnsSecConfigHas);
  }

  @Test
  public void testToBuilder() {
    assertEquals(INFO, INFO.toBuilder().build());
    ZoneInfo partial = ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION);
    assertEquals(partial, partial.toBuilder().build());
    partial =
        ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION).toBuilder().setGeneratedId(GENERATED_ID).build();
    assertEquals(partial, partial.toBuilder().build());
    partial =
        ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION)
            .toBuilder()
            .setCreationTimeMillis(CREATION_TIME_MILLIS)
            .build();
    assertEquals(partial, partial.toBuilder().build());
    List<String> nameServers = new LinkedList<>();
    nameServers.add(NS1);
    partial =
        ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION).toBuilder().setNameServers(nameServers).build();
    assertEquals(partial, partial.toBuilder().build());
    partial =
        ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION)
            .toBuilder()
            .setNameServerSet(NAME_SERVER_SET)
            .build();
    assertEquals(partial, partial.toBuilder().build());

    assertEquals(DNS_SEC_CONFIG, DNS_SEC_CONFIG.toBuilder().build());
    ZoneInfo.DnsSecConfig partialDnsSecConfig = ZoneInfo.DnsSecConfig.newBuilder().build();
    assertEquals(partialDnsSecConfig, partialDnsSecConfig.toBuilder().build());
  }

  @Test
  public void testToAndFromPb() {
    assertEquals(INFO, ZoneInfo.fromPb(INFO.toPb()));
    ZoneInfo partial = ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION);
    assertEquals(partial, ZoneInfo.fromPb(partial.toPb()));
    partial =
        ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION).toBuilder().setGeneratedId(GENERATED_ID).build();
    assertEquals(partial, ZoneInfo.fromPb(partial.toPb()));
    partial =
        ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION)
            .toBuilder()
            .setCreationTimeMillis(CREATION_TIME_MILLIS)
            .build();
    assertEquals(partial, ZoneInfo.fromPb(partial.toPb()));
    List<String> nameServers = new LinkedList<>();
    nameServers.add(NS1);
    partial =
        ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION).toBuilder().setNameServers(nameServers).build();
    assertEquals(partial, ZoneInfo.fromPb(partial.toPb()));
    partial =
        ZoneInfo.of(NAME, DNS_NAME, DESCRIPTION)
            .toBuilder()
            .setNameServerSet(NAME_SERVER_SET)
            .build();
    assertEquals(partial, ZoneInfo.fromPb(partial.toPb()));
    assertEquals(DNS_SEC_CONFIG, ZoneInfo.DnsSecConfig.fromPb(DNS_SEC_CONFIG.toPb()));
    ZoneInfo.DnsSecConfig partialDnsSecConfig =
        ZoneInfo.DnsSecConfig.newBuilder().setState(STATE).setNonExistence(NON_EXISTENCE).build();
    assertEquals(partialDnsSecConfig, ZoneInfo.DnsSecConfig.fromPb(partialDnsSecConfig.toPb()));
  }

  @Test
  public void testEmptyNameServers() {
    ZoneInfo clone = INFO.toBuilder().setNameServers(new LinkedList<String>()).build();
    assertTrue(clone.getNameServers().isEmpty());
    clone.toPb(); // test that this is allowed
  }

  @Test
  public void testDateParsing() {
    ManagedZone pb = INFO.toPb();
    pb.setCreationTime("2016-01-19T18:00:12.854Z"); // a real value obtained from Google Cloud DNS
    ZoneInfo mz = ZoneInfo.fromPb(pb); // parses the string timestamp to millis
    ManagedZone pbClone = mz.toPb(); // converts it back to string
    assertEquals(pb, pbClone);
    assertEquals(pb.getCreationTime(), pbClone.getCreationTime());
  }
}
