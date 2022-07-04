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
package com.google.cloud.accessapproval.v1.it;

import static org.junit.Assert.assertNotNull;

import com.google.cloud.accessapproval.v1.AccessApprovalAdminClient;
import com.google.cloud.accessapproval.v1.ApprovalRequest;
import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITAccessApprovalTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");

  @BeforeClass
  public static void setUp() {
    assertNotNull("need to set GOOGLE_CLOUD_PROJECT env variable", PROJECT_ID);
  }

  @Test
  public void testList() throws IOException {
    try (AccessApprovalAdminClient client = AccessApprovalAdminClient.create()) {
      AccessApprovalAdminClient.ListApprovalRequestsPagedResponse response =
          client.listApprovalRequests("projects/" + PROJECT_ID);
      int total = 0;
      for (ApprovalRequest request : response.iterateAll()) {
        System.out.println(request.getName());
        total++;
      }
      if (total == 0) {
        System.out.println("No approval requests found");
      }
    }
  }
}
