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

import static com.google.cloud.bigtable.misc_utilities.AuthorizedViewTestHelper.AUTHORIZED_VIEW_COLUMN_QUALIFIER;
import static com.google.cloud.bigtable.misc_utilities.AuthorizedViewTestHelper.AUTHORIZED_VIEW_ROW_PREFIX;
import static com.google.cloud.bigtable.misc_utilities.AuthorizedViewTestHelper.createTestAuthorizedView;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.TruthJUnit.assume;
import static org.junit.Assert.fail;

import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
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
public class MutateRowIT {
  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  @Test
  public void test() throws Exception {
    String rowKey = UUID.randomUUID().toString();
    String familyId = testEnvRule.env().getFamilyId();

    testEnvRule
        .env()
        .getDataClient()
        .mutateRowAsync(
            RowMutation.create(testEnvRule.env().getTableId(), rowKey)
                .setCell(familyId, "q", "myVal")
                .setCell(familyId, "q2", "myVal2")
                .setCell(familyId, "q3", "myVal3")
                .setCell(familyId, "q4", 0x12345678))
        .get(1, TimeUnit.MINUTES);

    testEnvRule
        .env()
        .getDataClient()
        .mutateRowAsync(
            RowMutation.create(testEnvRule.env().getTableId(), rowKey).deleteCells(familyId, "q2"))
        .get(1, TimeUnit.MINUTES);

    Row row =
        testEnvRule
            .env()
            .getDataClient()
            .readRowsCallable()
            .first()
            .call(Query.create(testEnvRule.env().getTableId()).rowKey(rowKey));

    assertThat(row.getCells()).hasSize(3);
    assertThat(row.getCells().get(0).getValue()).isEqualTo(ByteString.copyFromUtf8("myVal"));
    assertThat(row.getCells().get(1).getValue()).isEqualTo(ByteString.copyFromUtf8("myVal3"));
    assertThat(row.getCells().get(2).getValue())
        .isEqualTo(ByteString.copyFrom(new byte[] {0, 0, 0, 0, 0x12, 0x34, 0x56, 0x78}));
  }

  @Test
  public void testOnAuthorizedView() throws Exception {
    assume()
        .withMessage("AuthorizedView is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    AuthorizedView testAuthorizedView = createTestAuthorizedView(testEnvRule);

    String rowKey = AUTHORIZED_VIEW_ROW_PREFIX + UUID.randomUUID();
    String familyId = testEnvRule.env().getFamilyId();

    testEnvRule
        .env()
        .getDataClient()
        .mutateRowAsync(
            RowMutation.create(
                    AuthorizedViewId.of(testEnvRule.env().getTableId(), testAuthorizedView.getId()),
                    rowKey)
                .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER, "myVal")
                .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER + "2", "myVal2")
                .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER + "3", "myVal3")
                .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER + "4", 0x12345678))
        .get(1, TimeUnit.MINUTES);

    testEnvRule
        .env()
        .getDataClient()
        .mutateRowAsync(
            RowMutation.create(
                    AuthorizedViewId.of(testEnvRule.env().getTableId(), testAuthorizedView.getId()),
                    rowKey)
                .deleteCells(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER + "2"))
        .get(1, TimeUnit.MINUTES);

    Row row =
        testEnvRule
            .env()
            .getDataClient()
            .readRowsCallable()
            .first()
            .call(Query.create(testEnvRule.env().getTableId()).rowKey(rowKey));

    assertThat(row.getCells()).hasSize(3);
    assertThat(row.getCells().get(0).getValue()).isEqualTo(ByteString.copyFromUtf8("myVal"));
    assertThat(row.getCells().get(1).getValue()).isEqualTo(ByteString.copyFromUtf8("myVal3"));
    assertThat(row.getCells().get(2).getValue())
        .isEqualTo(ByteString.copyFrom(new byte[] {0, 0, 0, 0, 0x12, 0x34, 0x56, 0x78}));

    // We should not be able to mutate a row outside the authorized view
    try {
      String rowKeyOutsideAuthorizedView = UUID.randomUUID() + "-outside-authorized-view";
      testEnvRule
          .env()
          .getDataClient()
          .mutateRowAsync(
              RowMutation.create(
                      AuthorizedViewId.of(
                          testEnvRule.env().getTableId(), testAuthorizedView.getId()),
                      rowKeyOutsideAuthorizedView)
                  .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER, "myVal"))
          .get(1, TimeUnit.MINUTES);
      fail("Should not be able to mutate row outside authorized view");
    } catch (Exception e) {
      assertThat(e.getCause()).isInstanceOf(PermissionDeniedException.class);
    }

    testEnvRule
        .env()
        .getTableAdminClient()
        .deleteAuthorizedView(testEnvRule.env().getTableId(), testAuthorizedView.getId());
  }
}
