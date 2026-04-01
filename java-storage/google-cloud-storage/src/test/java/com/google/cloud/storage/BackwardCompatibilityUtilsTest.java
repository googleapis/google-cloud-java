/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.cloud.storage.BucketInfo.AgeDeleteRule;
import com.google.cloud.storage.BucketInfo.CreatedBeforeDeleteRule;
import com.google.cloud.storage.BucketInfo.DeleteRule;
import com.google.cloud.storage.BucketInfo.IsLiveDeleteRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleAction;
import com.google.cloud.storage.BucketInfo.NumNewerVersionsDeleteRule;
import com.google.cloud.storage.BucketInfo.RawDeleteRule;
import com.google.cloud.storage.Conversions.Codec;
import org.junit.Test;

public final class BackwardCompatibilityUtilsTest {
  private static final Codec<DeleteRule, Rule> codec =
      BackwardCompatibilityUtils.deleteRuleCodec.andThen(Conversions.json().lifecycleRule());

  @Test
  public void testDeleteRules_conversionRoundTrip_age() {
    AgeDeleteRule ageRule = new AgeDeleteRule(10);
    assertEquals(10, ageRule.getDaysToLive());
    assertEquals(DeleteRule.Type.AGE, ageRule.getType());
    verifyConversionRoundTrip(ageRule);
  }

  @Test
  public void testDeleteRules_conversionRoundTrip_createBefore() {
    CreatedBeforeDeleteRule createBeforeRule = new CreatedBeforeDeleteRule(1);
    assertEquals(1, createBeforeRule.getTimeMillis());
    assertEquals(DeleteRule.Type.CREATE_BEFORE, createBeforeRule.getType());
    verifyConversionRoundTrip(createBeforeRule);
  }

  @Test
  public void testDeleteRules_conversionRoundTrip_numNewerVersions() {
    NumNewerVersionsDeleteRule versionsRule = new NumNewerVersionsDeleteRule(2);
    assertEquals(2, versionsRule.getNumNewerVersions());
    assertEquals(DeleteRule.Type.NUM_NEWER_VERSIONS, versionsRule.getType());
    verifyConversionRoundTrip(versionsRule);
  }

  @Test
  public void testDeleteRules_conversionRoundTrip_isLive() {
    IsLiveDeleteRule isLiveRule = new IsLiveDeleteRule(true);
    assertTrue(isLiveRule.isLive());
    assertEquals(DeleteRule.Type.IS_LIVE, isLiveRule.getType());
    verifyConversionRoundTrip(isLiveRule);
  }

  @Test
  public void testDeleteRules_conversionRoundTrip_rawRule() {
    Rule rule = new Rule().set("a", "b");
    RawDeleteRule rawRule = new RawDeleteRule(rule);
    verifyConversionRoundTrip(rawRule);
  }

  @Test
  public void testDeleteRules_conversionRoundTrip_unsupportedRule() {
    Rule unsupportedRule =
        new Rule().setAction(new Rule.Action().setType("This action doesn't exist"));
    // if this doesn't throw an exception, unsupported rules work
    codec.decode(unsupportedRule);
  }

  @Test
  public void testRuleMappingIsCorrect_setDeleteRules_nonEmpty() {
    DeleteRule deleteRule = new AgeDeleteRule(5);
    LifecycleRule lifecycleRule = BackwardCompatibilityUtils.deleteRuleCodec.encode(deleteRule);

    assertThat(lifecycleRule.getAction()).isEqualTo(LifecycleAction.newDeleteAction());
    assertThat(lifecycleRule.getCondition().getAge()).isEqualTo(5);
  }

  private void verifyConversionRoundTrip(DeleteRule delRule) {
    Rule encode = codec.encode(delRule);
    DeleteRule decode = codec.decode(encode);
    assertThat(decode).isEqualTo(delRule);
  }
}
