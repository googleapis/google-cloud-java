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
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TimeZoneRule
    implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

  private final String timeZoneId;
  private TimeZone defaultTimeZone;

  public TimeZoneRule(String timeZoneId) {
    this.timeZoneId = timeZoneId;
  }

  @Override
  public void beforeAll(ExtensionContext context) {
    defaultTimeZone = TimeZone.getDefault();
    TimeZone.setDefault(TimeZone.getTimeZone(timeZoneId));
  }

  @Override
  public void afterAll(ExtensionContext context) {
    TimeZone.setDefault(defaultTimeZone);
  }

  @Override
  public void beforeEach(ExtensionContext context) {
    if (defaultTimeZone == null) {
      defaultTimeZone = TimeZone.getDefault();
    }
    TimeZone.setDefault(TimeZone.getTimeZone(timeZoneId));
  }

  @Override
  public void afterEach(ExtensionContext context) {
    if (defaultTimeZone != null) {
      TimeZone.setDefault(defaultTimeZone);
    }
  }

  /** Public method to enforce the rule manually */
  public void enforce() {
    TimeZone.setDefault(TimeZone.getTimeZone(timeZoneId));
  }
}
