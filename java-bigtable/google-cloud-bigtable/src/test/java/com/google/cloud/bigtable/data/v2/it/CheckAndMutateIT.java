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
package com.google.cloud.bigtable.data.v2.it;

import static com.google.cloud.bigtable.data.v2.models.Filters.FILTERS;
import static com.google.cloud.bigtable.misc_utilities.AuthorizedViewTestHelper.AUTHORIZED_VIEW_COLUMN_QUALIFIER;
import static com.google.cloud.bigtable.misc_utilities.AuthorizedViewTestHelper.AUTHORIZED_VIEW_ROW_PREFIX;
import static com.google.cloud.bigtable.misc_utilities.AuthorizedViewTestHelper.createTestAuthorizedView;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.TruthJUnit.assume;
import static org.junit.Assert.fail;

import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.protobuf.ByteString;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CheckAndMutateIT {
  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  @Test
  public void test() throws Exception {
    String tableId = testEnvRule.env().getTableId();
    String familyId = testEnvRule.env().getFamilyId();
    String rowKey = UUID.randomUUID().toString();

    testEnvRule
        .env()
        .getDataClient()
        .mutateRowCallable()
        .call(
            RowMutation.create(tableId, rowKey)
                .setCell(familyId, "q1", "val1")
                .setCell(familyId, "q2", "val2"));

    testEnvRule
        .env()
        .getDataClient()
        .checkAndMutateRowAsync(
            ConditionalRowMutation.create(tableId, rowKey)
                .condition(FILTERS.qualifier().exactMatch("q1"))
                .then(Mutation.create().setCell(familyId, "q3", "q1")))
        .get(1, TimeUnit.MINUTES);

    Row row =
        testEnvRule
            .env()
            .getDataClient()
            .readRowsCallable()
            .first()
            .call(Query.create(tableId).rowKey(rowKey));

    assertThat(row.getCells()).hasSize(3);
    assertThat(row.getCells().get(2).getValue()).isEqualTo(ByteString.copyFromUtf8("q1"));
  }

  @Test
  public void testOnAuthorizedView() throws Exception {
    assume()
        .withMessage("AuthorizedView is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    AuthorizedView testAuthorizedView = createTestAuthorizedView(testEnvRule);

    String tableId = testEnvRule.env().getTableId();
    String familyId = testEnvRule.env().getFamilyId();
    String rowKey = AUTHORIZED_VIEW_ROW_PREFIX + UUID.randomUUID();
    BigtableDataClient dataClient = testEnvRule.env().getDataClient();

    dataClient
        .mutateRowCallable()
        .call(
            RowMutation.create(AuthorizedViewId.of(tableId, testAuthorizedView.getId()), rowKey)
                .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER + "1", "val1")
                .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER + "2", "val2"));

    dataClient
        .checkAndMutateRowAsync(
            ConditionalRowMutation.create(
                    AuthorizedViewId.of(tableId, testAuthorizedView.getId()), rowKey)
                .condition(FILTERS.qualifier().exactMatch(AUTHORIZED_VIEW_COLUMN_QUALIFIER + "1"))
                .then(
                    Mutation.create()
                        .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER + "3", "q1")))
        .get(1, TimeUnit.MINUTES);

    Row row = dataClient.readRowsCallable().first().call(Query.create(tableId).rowKey(rowKey));

    assertThat(row.getCells()).hasSize(3);
    assertThat(row.getCells().get(2).getValue()).isEqualTo(ByteString.copyFromUtf8("q1"));

    // Conditional mutation for rows exist in the table but outside the authorized view
    String rowKeyOutsideAuthorizedView = UUID.randomUUID() + "-outside-authorized-view";
    dataClient
        .mutateRowCallable()
        .call(
            RowMutation.create(tableId, rowKeyOutsideAuthorizedView)
                .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER, "value"));
    try {
      dataClient
          .checkAndMutateRowAsync(
              ConditionalRowMutation.create(
                      AuthorizedViewId.of(tableId, testAuthorizedView.getId()),
                      rowKeyOutsideAuthorizedView)
                  .condition(FILTERS.qualifier().exactMatch(AUTHORIZED_VIEW_COLUMN_QUALIFIER))
                  .then(Mutation.create().setCell(familyId, "new_qualifier", "new-value")))
          .get(1, TimeUnit.MINUTES);
      fail("Should not be able to conditional mutate row outside authorized view");
    } catch (Exception e) {
      assertThat(e.getCause()).isInstanceOf(PermissionDeniedException.class);
    }

    // Column qualifier outside the authorized view
    try {
      dataClient
          .checkAndMutateRowAsync(
              ConditionalRowMutation.create(
                      AuthorizedViewId.of(tableId, testAuthorizedView.getId()), rowKey)
                  .condition(FILTERS.qualifier().exactMatch(AUTHORIZED_VIEW_COLUMN_QUALIFIER))
                  .then(Mutation.create().setCell(familyId, "new_qualifier", "new-value")))
          .get(1, TimeUnit.MINUTES);
      fail("Should not be able to perform mutations with cells outside the authorized view");
    } catch (Exception e) {
      assertThat(e.getCause()).isInstanceOf(PermissionDeniedException.class);
    }

    testEnvRule
        .env()
        .getTableAdminClient()
        .deleteAuthorizedView(testEnvRule.env().getTableId(), testAuthorizedView.getId());
  }
}
