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

package com.google.cloud.bigquery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PolicyTagsTest {

  private static final List<String> POLICIES = ImmutableList.of("test/policy1", "test/policy2");
  private static final PolicyTags POLICY_TAGS = PolicyTags.newBuilder().setNames(POLICIES).build();

  @Test
  public void testToBuilder() {
    comparePolicyTags(POLICY_TAGS, POLICY_TAGS.toBuilder().build());
  }

  @Test
  public void testToBuilderIncomplete() {
    PolicyTags policyTags = PolicyTags.newBuilder().build();
    assertEquals(policyTags, policyTags);
    assertEquals(policyTags, policyTags.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(POLICIES, POLICY_TAGS.getNames());
    assertNotEquals(POLICY_TAGS, POLICIES);
  }

  @Test
  public void testWithoutNames() {
    com.google.api.services.bigquery.model.TableFieldSchema.PolicyTags PARTIALTAG =
        new com.google.api.services.bigquery.model.TableFieldSchema.PolicyTags();
    assertNull(PolicyTags.fromPb(PARTIALTAG));
  }

  @Test
  public void testFromAndPb() {
    assertEquals(POLICY_TAGS, PolicyTags.fromPb(POLICY_TAGS.toPb()));
  }

  private void comparePolicyTags(PolicyTags expected, PolicyTags value) {
    assertEquals(expected, value);
    assertEquals(expected.getNames(), value.getNames());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
