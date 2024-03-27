/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.misc_utilities;

import com.google.cloud.bigtable.admin.v2.models.AuthorizedView;
import com.google.cloud.bigtable.admin.v2.models.CreateAuthorizedViewRequest;
import com.google.cloud.bigtable.admin.v2.models.FamilySubsets;
import com.google.cloud.bigtable.admin.v2.models.SubsetView;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import java.util.UUID;

public class AuthorizedViewTestHelper {
  public static String AUTHORIZED_VIEW_ROW_PREFIX = "row#";
  public static String AUTHORIZED_VIEW_COLUMN_QUALIFIER = "qualifier";

  public static AuthorizedView createTestAuthorizedView(TestEnvRule testEnvRule) {
    String tableId = testEnvRule.env().getTableId();
    String authorizedViewId = UUID.randomUUID().toString();
    CreateAuthorizedViewRequest request =
        CreateAuthorizedViewRequest.of(tableId, authorizedViewId)
            .setAuthorizedViewType(
                SubsetView.create()
                    .addRowPrefix(AUTHORIZED_VIEW_ROW_PREFIX)
                    .setFamilySubsets(
                        testEnvRule.env().getFamilyId(),
                        FamilySubsets.create()
                            .addQualifierPrefix(AUTHORIZED_VIEW_COLUMN_QUALIFIER)))
            .setDeletionProtection(false);
    return testEnvRule.env().getTableAdminClient().createAuthorizedView(request);
  }
}
