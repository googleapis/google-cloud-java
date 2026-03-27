/*
 * Copyright 2021 Google LLC
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

package com.example.spanner.admin.archived;

import static org.junit.Assert.assertTrue;

import com.example.spanner.SampleRunner;
import com.example.spanner.SampleTestBase;
import org.junit.Test;

public class GetInstanceConfigSampleIT extends SampleTestBase {

  @Test
  public void testGetInstanceConfig() throws Exception {
    final String out = SampleRunner.runSample(() ->
        GetInstanceConfigSample.getInstanceConfig(projectId, instanceConfigName)
    );

    assertTrue(
        "Expected instance config " + instanceConfigName + " to contain at least one leader option."
            + " Output received was " + out,
        out.matches("(?s:.*\\[.+\\].*)")
    );
  }
}
