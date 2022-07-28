/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.iam.admin.v1.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.iam.admin.v1.IAMClient;
import com.google.iam.admin.v1.ProjectName;
import com.google.iam.admin.v1.ServiceAccount;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {
  private static IAMClient client;
  private static String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");

  @BeforeClass
  public static void setUp() throws IOException {
    client = IAMClient.create();
  }

  @AfterClass
  public static void tearDown() {
    client.close();
  }

  @Test
  public void listServiceAccounts() {
    assertNotNull(PROJECT_ID);

    int count = 0;
    for (ServiceAccount serviceAccount :
        client.listServiceAccounts(ProjectName.of(PROJECT_ID)).iterateAll()) {
      assertEquals(PROJECT_ID, serviceAccount.getProjectId());
      count += 1;
    }
    assertTrue("Expected to get at least one service account", count > 0);
  }
}
