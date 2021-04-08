/*
 * Copyright 2019 Google LLC
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

package com.example.bigtable;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Integration tests for {@link Quickstart}
 */
public class QuickstartTest extends BigtableBaseTest {

  private static final String TABLE_ID = "quickstart-table";

  @BeforeClass
  public static void beforeClass() {
    initializeVariables();
  }

  @Test
  public void testQuickstart() {
    Quickstart.quickstart(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output, CoreMatchers.containsString("Reading a single row by row key"));
    assertThat(output, CoreMatchers.containsString("Row: r1"));
    assertThat(
        output, CoreMatchers.containsString("Family: cf1    Qualifier: c1    Value: quickstart"));
  }
}
