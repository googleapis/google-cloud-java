/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit tests for {@link com.google.cloud.spanner.SessionPoolOptions}
 */
@RunWith(JUnit4.class)
public class SessionPoolOptionsTest {
  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void minSessionsGreaterThanMaxSessions() {
    expectedException.expect(IllegalArgumentException.class);
    SessionPoolOptions.newBuilder()
        .setMinSessions(2)
        .setMaxSessions(1)
        .build();
  }

  @Test
  public void defaultBuilder() {
    SessionPoolOptions options = SessionPoolOptions.newBuilder().build();
    assertThat(options.getWriteSessionsFraction()).isWithin(0.0f).of(0.0f);
    assertThat(options.getMinSessions()).isEqualTo(0);
    assertThat(options.getMaxSessions()).isEqualTo(400);
    assertThat(options.getMaxIdleSessions()).isEqualTo(0);
    assertThat(options.getKeepAliveIntervalMinutes()).isEqualTo(30);
    assertThat(options.isBlockIfPoolExhausted()).isTrue();
    assertThat(options.isFailIfPoolExhausted()).isFalse();
  }
  
  @Test
  public void builder() {
    SessionPoolOptions options = SessionPoolOptions.newBuilder()
        .setMinSessions(1)
        .setMaxIdleSessions(2)
        .setMaxSessions(3)
        .setWriteSessionsFraction(0.2f)
        .setKeepAliveIntervalMinutes(10)
        .setFailIfPoolExhausted()
        .build();
    assertThat(options.getMinSessions()).isEqualTo(1);
    assertThat(options.getMaxIdleSessions()).isEqualTo(2);
    assertThat(options.getMaxSessions()).isEqualTo(3);
    assertThat(options.getWriteSessionsFraction()).isWithin(0.0f).of(0.2f);
    assertThat(options.getKeepAliveIntervalMinutes()).isEqualTo(10);
    assertThat(options.isFailIfPoolExhausted()).isTrue();
    assertThat(options.isBlockIfPoolExhausted()).isFalse();
  }
}
