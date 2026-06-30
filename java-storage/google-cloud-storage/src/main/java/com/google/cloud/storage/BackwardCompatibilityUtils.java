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

import static java.util.Objects.requireNonNull;

import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.cloud.storage.BucketInfo.AgeDeleteRule;
import com.google.cloud.storage.BucketInfo.CreatedBeforeDeleteRule;
import com.google.cloud.storage.BucketInfo.DeleteRule;
import com.google.cloud.storage.BucketInfo.IsLiveDeleteRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleCondition;
import com.google.cloud.storage.BucketInfo.NumNewerVersionsDeleteRule;
import com.google.cloud.storage.BucketInfo.RawDeleteRule;
import com.google.cloud.storage.Conversions.Codec;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * A collection of utilities that only exist to enable backward compatibility.
 *
 * <p>In general, the expectation is that any references to this class only come from @Deprecated
 * things.
 */
final class BackwardCompatibilityUtils {

  @SuppressWarnings("RedundantTypeArguments")
  // the <Long, OffsetDateTime> doesn't auto carry all the way through like intellij thinks it
  // would.
  static final Codec<@Nullable Long, @Nullable OffsetDateTime> millisOffsetDateTimeCodec =
      Codec.<Long, OffsetDateTime>of(
              l ->
                  Instant.ofEpochMilli(requireNonNull(l, "l must be non null"))
                      .atOffset(ZoneOffset.systemDefault().getRules().getOffset(Instant.now())),
              odt -> requireNonNull(odt, "odt must be non null").toInstant().toEpochMilli())
          .nullable();

  static final Codec<Long, OffsetDateTime> millisUtcCodec =
      Codec.of(
          l ->
              Instant.ofEpochMilli(requireNonNull(l, "l must be non null"))
                  .atOffset(ZoneOffset.UTC),
          odt -> requireNonNull(odt, "odt must be non null").toInstant().toEpochMilli());

  static final Codec<@Nullable Duration, @Nullable Long> nullableDurationSecondsCodec =
      Utils.durationSecondsCodec.nullable();

  @SuppressWarnings("deprecation")
  static final Codec<DeleteRule, LifecycleRule> deleteRuleCodec =
      Codec.of(
          BackwardCompatibilityUtils::deleteRuleEncode,
          BackwardCompatibilityUtils::deleteRuleDecode);

  private BackwardCompatibilityUtils() {}

  @SuppressWarnings("deprecation")
  private static LifecycleRule deleteRuleEncode(DeleteRule from) {
    if (from instanceof RawDeleteRule) {
      RawDeleteRule raw = (RawDeleteRule) from;
      Rule rule = raw.getRule();
      String msg =
          "The lifecycle condition "
              + resolveRuleActionType(from)
              + " is not currently supported. Please update to the latest version of"
              + " google-cloud-java. Also, use LifecycleRule rather than the deprecated"
              + " DeleteRule.";
      // manually construct a log record, so we maintain class name and method name
      // from the old implicit values.
      LogRecord record = new LogRecord(Level.WARNING, msg);
      record.setLoggerName(BucketInfo.RawDeleteRule.class.getName());
      record.setSourceClassName(BucketInfo.RawDeleteRule.class.getName());
      record.setSourceMethodName("populateCondition");
      BucketInfo.log.log(record);

      LifecycleCondition condition =
          Conversions.json().lifecycleCondition().decode(rule.getCondition());
      return new LifecycleRule(LifecycleAction.newDeleteAction(), condition);
    }
    LifecycleCondition.Builder condition = LifecycleCondition.newBuilder();
    if (from instanceof CreatedBeforeDeleteRule) {
      CreatedBeforeDeleteRule r = (CreatedBeforeDeleteRule) from;
      condition.setCreatedBeforeOffsetDateTime(r.getTime());
    } else if (from instanceof AgeDeleteRule) {
      AgeDeleteRule r = (AgeDeleteRule) from;
      condition.setAge(r.getDaysToLive());
    } else if (from instanceof NumNewerVersionsDeleteRule) {
      NumNewerVersionsDeleteRule r = (NumNewerVersionsDeleteRule) from;
      condition.setNumberOfNewerVersions(r.getNumNewerVersions());
    } else if (from instanceof IsLiveDeleteRule) {
      IsLiveDeleteRule r = (IsLiveDeleteRule) from;
      condition.setIsLive(r.isLive());
    } // else would be RawDeleteRule which is handled above
    return new LifecycleRule(LifecycleAction.newDeleteAction(), condition.build());
  }

  @SuppressWarnings("deprecation")
  private static DeleteRule deleteRuleDecode(LifecycleRule from) {
    if (from.getAction() != null
        && BucketInfo.DeleteRule.SUPPORTED_ACTION.endsWith(resolveRuleActionType(from))) {
      LifecycleCondition condition = from.getCondition();
      Integer age = condition.getAge();
      if (age != null) {
        return new BucketInfo.AgeDeleteRule(age);
      }
      OffsetDateTime createdBefore = condition.getCreatedBeforeOffsetDateTime();
      if (createdBefore != null) {
        return new BucketInfo.CreatedBeforeDeleteRule(createdBefore);
      }
      Integer numNewerVersions = condition.getNumberOfNewerVersions();
      if (numNewerVersions != null) {
        return new BucketInfo.NumNewerVersionsDeleteRule(numNewerVersions);
      }
      Boolean isLive = condition.getIsLive();
      if (isLive != null) {
        return new BucketInfo.IsLiveDeleteRule(isLive);
      }
    }
    return new RawDeleteRule(Conversions.json().lifecycleRule().encode(from));
  }

  @SuppressWarnings("deprecation")
  private static String resolveRuleActionType(DeleteRule deleteRule) {
    if (deleteRule != null && deleteRule.getType() != null) {
      return deleteRule.getType().name();
    } else {
      return null;
    }
  }

  private static String resolveRuleActionType(LifecycleRule rule) {
    if (rule != null && rule.getAction() != null) {
      return rule.getAction().getActionType();
    } else {
      return null;
    }
  }
}
