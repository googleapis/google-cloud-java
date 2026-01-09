/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.rules;

import java.util.TimeZone;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class TimeZoneRule implements TestRule {

  private final String timeZoneId;
  private final TimeZone defaultTimeZone;

  public TimeZoneRule(String timeZoneId) {
    this.timeZoneId = timeZoneId;
    defaultTimeZone = TimeZone.getDefault();
  }

  @Override
  public Statement apply(Statement base, Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        try {
          TimeZone.setDefault(TimeZone.getTimeZone(timeZoneId));
          base.evaluate();
        } finally {
          TimeZone.setDefault(defaultTimeZone);
        }
      }
    };
  }

  /**
   * Public method to enforce the rule from places like methods annotated with {@link
   * org.junit.runners.Parameterized.Parameters} annotation which gets executed before this rule is
   * applied.
   */
  public void enforce() {
    TimeZone.setDefault(TimeZone.getTimeZone(timeZoneId));
  }
}
