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
package com.google.cloud.bigtable.data.v2;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BigtableDataSettingsTest {

  @Test
  public void testToString() {
    BigtableDataSettings settings =
        BigtableDataSettings.newBuilder()
            .setProjectId("our-project-2-12")
            .setInstanceId("our-instance-85")
            .setAppProfileId("our-appProfile-06")
            .build();
    EnhancedBigtableStubSettings stubSettings = settings.getStubSettings();
    assertThat(settings.toString())
        .isEqualTo("BigtableDataSettings{stubSettings=" + stubSettings.toString() + "}");
  }
}
