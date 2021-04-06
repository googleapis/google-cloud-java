/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.resourcemanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.services.cloudresourcemanager.model.RestoreDefault;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OrgPolicyInfoTest {

  private static final String CONSTRAINTS_NAME = "constraints/serviceuser.services";
  private static final String ETAG = "abcd12";
  private static final String UPDATE_TIME = "014-10-02T15:01:23.045123456Z";
  private static final Integer VERSION = 1;
  private static final OrgPolicyInfo.BoolPolicy BOOLEAN_POLICY = new OrgPolicyInfo.BoolPolicy(true);
  private static final OrgPolicyInfo.Policies LIST_POLICY =
      new OrgPolicyInfo.Policies(
          "allvaluse",
          Arrays.asList("allowedValue-1", "allowedValue-2"),
          Arrays.asList("deniedValue-1", "deniedValue-2"),
          true,
          "suggestedValue");

  private RestoreDefault restoreDefault;
  private OrgPolicyInfo orgPolicyInfo;

  @Before
  public void setUp() {
    restoreDefault = new RestoreDefault();
    restoreDefault.set("fields", String.class);
    orgPolicyInfo =
        OrgPolicyInfo.newBuilder()
            .setBoolPolicy(BOOLEAN_POLICY)
            .setConstraint(CONSTRAINTS_NAME)
            .setListPolicy(LIST_POLICY)
            .setRestoreDefault(restoreDefault)
            .setEtag(ETAG)
            .setUpdateTime(UPDATE_TIME)
            .setVersion(VERSION)
            .build();
  }

  @Test
  public void testBuilder() {
    assertEquals(CONSTRAINTS_NAME, orgPolicyInfo.getConstraint());
    assertEquals(BOOLEAN_POLICY, orgPolicyInfo.getBoolPolicy());
    assertEquals(LIST_POLICY, orgPolicyInfo.getPolicies());
    assertEquals(UPDATE_TIME, orgPolicyInfo.getUpdateTime());
    assertEquals(VERSION, orgPolicyInfo.getVersion());
    assertEquals(restoreDefault, orgPolicyInfo.getRestoreDefault());
  }

  @Test
  public void testToBuilder() {
    compareOrgPolicy(orgPolicyInfo, orgPolicyInfo.toBuilder().build());
  }

  @Test
  public void testToAndFromProtobuf() {
    assertTrue(orgPolicyInfo.toProtobuf().getUpdateTime().endsWith("Z"));
    compareOrgPolicy(orgPolicyInfo, orgPolicyInfo.fromProtobuf(orgPolicyInfo.toProtobuf()));
    assertNotNull(OrgPolicyInfo.TO_PROTOBUF_FUNCTION.apply(orgPolicyInfo));
    assertNotNull(
        OrgPolicyInfo.FROM_PROTOBUF_FUNCTION.apply(
            OrgPolicyInfo.TO_PROTOBUF_FUNCTION.apply(orgPolicyInfo)));
  }

  @Test
  public void testEquals() {
    compareOrgPolicy(
        orgPolicyInfo,
        OrgPolicyInfo.newBuilder()
            .setBoolPolicy(BOOLEAN_POLICY)
            .setConstraint(CONSTRAINTS_NAME)
            .setListPolicy(LIST_POLICY)
            .setRestoreDefault(restoreDefault)
            .setEtag(ETAG)
            .setUpdateTime(UPDATE_TIME)
            .setVersion(VERSION)
            .build());
    compareOrgPolicy(orgPolicyInfo, new OrgPolicyInfo.Builder(orgPolicyInfo).build());
  }

  @Test
  public void testToString() {
    assertTrue(BOOLEAN_POLICY.toString().contains("enforce=" + BOOLEAN_POLICY.getEnforce()));
  }

  @Test
  public void testListPolicyToAndFromProtobuf() {
    compareListPolicies(LIST_POLICY, LIST_POLICY.fromProtobuf(LIST_POLICY.toProtobuf()));
  }

  private void compareOrgPolicy(OrgPolicyInfo expected, OrgPolicyInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.getConstraint(), value.getConstraint());
    assertEquals(expected.getBoolPolicy(), value.getBoolPolicy());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getBoolPolicy().toString(), value.getBoolPolicy().toString());
    assertEquals(expected.getPolicies(), value.getPolicies());
    assertEquals(expected.getRestoreDefault(), value.getRestoreDefault());
    assertEquals(expected.getUpdateTime(), value.getUpdateTime());
    assertEquals(expected.getVersion(), value.getVersion());
  }

  private void compareListPolicies(OrgPolicyInfo.Policies expected, OrgPolicyInfo.Policies value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getAllowedValues(), value.getAllowedValues());
    assertEquals(expected.getAllValues(), value.getAllValues());
    assertEquals(expected.getDeniedValues(), value.getDeniedValues());
    assertEquals(expected.getInheritFromParent(), value.getInheritFromParent());
  }
}
