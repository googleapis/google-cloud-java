/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.compute.v1.ForwardingRule;
import com.google.cloud.compute.v1.ForwardingRuleClient;
import com.google.cloud.compute.v1.ForwardingRuleSettings;
import com.google.cloud.compute.v1.ForwardingRulesScopedList;
import com.google.cloud.compute.v1.GlobalForwardingRuleClient;
import com.google.cloud.compute.v1.GlobalForwardingRuleSettings;
import com.google.cloud.compute.v1.InsertTargetPoolHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionForwardingRuleName;
import com.google.cloud.compute.v1.TargetPool;
import com.google.cloud.compute.v1.TargetPoolClient;
import com.google.cloud.compute.v1.TargetPoolSettings;
import com.google.cloud.compute.v1.TargetReference;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITForwardingRuleTest extends BaseTest {

  private static ForwardingRuleClient forwardingRuleClient;
  private static GlobalForwardingRuleClient globalForwardingRuleClient;
  private static TargetPoolClient targetPoolClient;

  private static final String FORWARDING_RULE_NAME =
      TestHelper.getTestUniqueName("forwarding-rule");
  private static final String FORWARDING_RULE_LINK =
      String.format("%s/forwardingRules/%s", REGION_LINK, FORWARDING_RULE_NAME);
  private static final ProjectRegionForwardingRuleName PROJECT_REGION_FORWARDING_RULE_NAME =
      ProjectRegionForwardingRuleName.of(FORWARDING_RULE_NAME, DEFAULT_PROJECT, REGION);
  private static final String SESSION_AFFINITY = "NONE";
  private static final String FORWARDING_RULE_TARGET_POOL_NAME =
      TestHelper.getTestUniqueName("forwarding-rule-target-pool");
  private static final String FORWARDING_RULE_TARGET_POOL_SELF_LINK =
      String.format("%s/targetPools/%s", REGION_LINK, FORWARDING_RULE_TARGET_POOL_NAME);

  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    TargetPoolSettings targetPoolSettings =
        TargetPoolSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    targetPoolClient = TargetPoolClient.create(targetPoolSettings);
    TargetPool targetPool =
        TargetPool.newBuilder()
            .setName(FORWARDING_RULE_TARGET_POOL_NAME)
            .setRegion(PROJECT_REGION_NAME.toString())
            .setSessionAffinity(SESSION_AFFINITY)
            .build();
    InsertTargetPoolHttpRequest request =
        InsertTargetPoolHttpRequest.newBuilder()
            .setTargetPoolResource(targetPool)
            .setRegion(PROJECT_REGION_NAME.toString())
            .setRequestId(TestHelper.getUid())
            .build();

    Operation completedOperation = waitForOperation(targetPoolClient.insertTargetPool(request));
    resourcesToCleanUp.put("forwarding-rule-target-pool", completedOperation.getTargetLink());

    ForwardingRuleSettings forwardingRuleSettings =
        ForwardingRuleSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    forwardingRuleClient = ForwardingRuleClient.create(forwardingRuleSettings);
    ForwardingRule forwardingRule =
        ForwardingRule.newBuilder()
            .setName(FORWARDING_RULE_NAME)
            .setTarget(FORWARDING_RULE_TARGET_POOL_SELF_LINK)
            .setIPProtocol(IP_PROTOCOL)
            .build();

    completedOperation =
        waitForOperation(
            forwardingRuleClient.insertForwardingRule(PROJECT_REGION_NAME, forwardingRule));
    resourcesToCleanUp.put("forwarding-rule", completedOperation.getTargetLink());

    GlobalForwardingRuleSettings globalForwardingRuleSettings =
        GlobalForwardingRuleSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .build();
    globalForwardingRuleClient = GlobalForwardingRuleClient.create(globalForwardingRuleSettings);
  }

  @AfterClass
  public static void tearDown() {
    for (String forwardingRule : resourcesToCleanUp.get("forwarding-rule")) {
      waitForOperation(forwardingRuleClient.deleteForwardingRule(forwardingRule));
    }
    for (String targetPool : resourcesToCleanUp.get("forwarding-rule-target-pool")) {
      waitForOperation(targetPoolClient.deleteTargetPool(targetPool));
    }

    forwardingRuleClient.close();
    globalForwardingRuleClient.close();
    targetPoolClient.close();
  }

  @Test
  public void getForwardingRuleTest() {
    ForwardingRule forwardingRule =
        forwardingRuleClient.getForwardingRule(PROJECT_REGION_FORWARDING_RULE_NAME);
    assertThat(forwardingRule.getIPProtocol()).isEqualTo(IP_PROTOCOL);
    assertThat(forwardingRule.getName()).isEqualTo(FORWARDING_RULE_NAME);
    assertThat(forwardingRule.getNetworkTier()).isEqualTo("PREMIUM");
    assertThat(forwardingRule.getRegion()).isEqualTo(REGION_LINK);
    assertThat(forwardingRule.getSelfLink()).isEqualTo(FORWARDING_RULE_LINK);
    assertThat(forwardingRule.getTarget()).isEqualTo(FORWARDING_RULE_TARGET_POOL_SELF_LINK);
  }

  @Test
  public void listForwardingRulesTest() {
    List<ForwardingRule> forwardingRules =
        Lists.newArrayList(
            forwardingRuleClient.listForwardingRules(PROJECT_REGION_NAME).iterateAll());
    for (ForwardingRule forwardingRule : forwardingRules) {
      if (FORWARDING_RULE_NAME.equals(forwardingRule.getName())) {
        assertThat(forwardingRule.getIPProtocol()).isEqualTo(IP_PROTOCOL);
        assertThat(forwardingRule.getName()).isEqualTo(FORWARDING_RULE_NAME);
        assertThat(forwardingRule.getNetworkTier()).isEqualTo("PREMIUM");
        assertThat(forwardingRule.getRegion()).isEqualTo(REGION_LINK);
        assertThat(forwardingRule.getSelfLink()).isEqualTo(FORWARDING_RULE_LINK);
        assertThat(forwardingRule.getTarget()).isEqualTo(FORWARDING_RULE_TARGET_POOL_SELF_LINK);
      }
    }
  }

  @Test
  public void setTargetForwardingRuleTest() throws Exception {
    TargetReference targetReferenceResource =
        TargetReference.newBuilder().setTarget(FORWARDING_RULE_TARGET_POOL_SELF_LINK).build();
    Operation setTargetForwardingRule =
        forwardingRuleClient.setTargetForwardingRule(
            PROJECT_REGION_FORWARDING_RULE_NAME, targetReferenceResource);
    assertThat(setTargetForwardingRule.getOperationType()).isEqualTo("SetTarget");
    assertThat(setTargetForwardingRule.getRegion()).isEqualTo(REGION_LINK);
    assertThat(setTargetForwardingRule.getTargetLink()).isEqualTo(FORWARDING_RULE_LINK);
  }

  @Test
  public void aggregatedListForwardingRulesTest() {
    List<ForwardingRulesScopedList> forwardingRulesScopedLists =
        Lists.newArrayList(
            forwardingRuleClient.aggregatedListForwardingRules(true, PROJECT_NAME).iterateAll());
    assertThat(forwardingRulesScopedLists).isNotNull();
    assertThat(forwardingRulesScopedLists.size()).isGreaterThan(0);
    assertThat(forwardingRulesScopedLists.contains(null)).isFalse();
  }

  @Test
  public void listGlobalForwardingRulesTest() {
    List<ForwardingRule> forwardingRules =
        Lists.newArrayList(
            globalForwardingRuleClient.listGlobalForwardingRules(PROJECT_NAME).iterateAll());
    assertThat(forwardingRules).isNotNull();
    assertThat(forwardingRules.size()).isEqualTo(0);
    assertThat(forwardingRules.contains(null)).isFalse();
  }
}
