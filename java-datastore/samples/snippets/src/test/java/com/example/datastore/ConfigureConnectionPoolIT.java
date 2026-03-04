/*
 * Copyright 2025 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.datastore;

import com.rule.SystemsOutRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for ConfigureConnectionPool sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ConfigureConnectionPoolIT {

  @Rule public final SystemsOutRule systemsOutRule = new SystemsOutRule();

  @Test
  public void testConfigureConnectionPool() throws Exception {
    ConfigureConnectionPool.main();
    systemsOutRule.assertContains(
        "Connected with pool with InitialChannelCount: 10, MinChannelCount: 5, MaxChannelCount:"
            + " 200");
  }
}
