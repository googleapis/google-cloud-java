/*
 * Copyright 2018 Google LLC
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

import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BigtableInstanceAdminClientTest {
  private BigtableInstanceAdminClient adminClient;
  @Mock
  private BigtableInstanceAdminStub mockStub;

  @Before
  public void setUp() {
    adminClient = BigtableInstanceAdminClient
        .create(ProjectName.of("[PROJECT]"), mockStub);
  }

  @Test
  public void testProjectName() {
    assertThat(adminClient.getProjectName()).isEqualTo(ProjectName.of("[PROJECT]"));
  }

  @Test
  public void testClose() {
    adminClient.close();
    Mockito.verify(mockStub).close();
  }
}
