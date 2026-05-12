/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.admin.v2;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class BigtableInstanceAdminClientV2Test {

  @Test
  public void testCreateWithStub() {
    BigtableInstanceAdminStub mockStub = Mockito.mock(BigtableInstanceAdminStub.class);
    BigtableInstanceAdminClientV2 client = BigtableInstanceAdminClientV2.create(mockStub);

    assertThat(client).isNotNull();
  }

  @Test
  public void testCreateClientWithSettings() throws Exception {
    BaseBigtableInstanceAdminSettings settings =
        BaseBigtableInstanceAdminSettings.newBuilder()
            .setCredentialsProvider(com.google.api.gax.core.NoCredentialsProvider.create())
            .build();
    try (BigtableInstanceAdminClientV2 settingsClient =
        BigtableInstanceAdminClientV2.create(settings)) {
      assertThat(settingsClient).isNotNull();
    }
  }
}
