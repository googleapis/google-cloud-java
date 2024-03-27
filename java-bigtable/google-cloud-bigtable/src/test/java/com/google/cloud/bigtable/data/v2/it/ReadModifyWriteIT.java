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
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.protobuf.ByteString;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadModifyWriteIT {
  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  @Test
  public void test() throws InterruptedException, ExecutionException, TimeoutException {
    String tableId = testEnvRule.env().getTableId();
    String family = testEnvRule.env().getFamilyId();
    String rowKey = UUID.randomUUID().toString();

    Row row =
        testEnvRule
            .env()
            .getDataClient()
            .readModifyWriteRowAsync(
                ReadModifyWriteRow.create(tableId, rowKey)
                    .append(family, "q1", "a")
                    .increment(family, "q2", 3)
                    .increment(family, "q3", 0x12345679))
            .get(1, TimeUnit.MINUTES);

    assertThat(row.getCells()).hasSize(3);
    assertThat(row.getCells().get(0).getValue()).isEqualTo(ByteString.copyFromUtf8("a"));
    assertThat(row.getCells().get(1).getValue())
        .isEqualTo(ByteString.copyFrom(new byte[] {0, 0, 0, 0, 0, 0, 0, 3}));
    assertThat(row.getCells().get(2).getValue())
        .isEqualTo(ByteString.copyFrom(new byte[] {0, 0, 0, 0, 0x12, 0x34, 0x56, 0x79}));
  }

  @Test
  public void testOnAuthorizedView()
      throws InterruptedException, ExecutionException, TimeoutException {
    assume()
        .withMessage("AuthorizedView is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    AuthorizedView testAuthorizedView = createTestAuthorizedView(testEnvRule);

    String tableId = testEnvRule.env().getTableId();
    String family = testEnvRule.env().getFamilyId();
    String rowKey = AUTHORIZED_VIEW_ROW_PREFIX + UUID.randomUUID();

    Row row =
        testEnvRule
            .env()
            .getDataClient()
            .readModifyWriteRowAsync(
                ReadModifyWriteRow.create(
                        AuthorizedViewId.of(tableId, testAuthorizedView.getId()), rowKey)
                    .append(family, AUTHORIZED_VIEW_COLUMN_QUALIFIER + "1", "a")
                    .increment(family, AUTHORIZED_VIEW_COLUMN_QUALIFIER + "2", 3)
                    .increment(family, AUTHORIZED_VIEW_COLUMN_QUALIFIER + "3", 0x12345679))
            .get(1, TimeUnit.MINUTES);

    assertThat(row.getCells()).hasSize(3);
    assertThat(row.getCells().get(0).getValue()).isEqualTo(ByteString.copyFromUtf8("a"));
    assertThat(row.getCells().get(1).getValue())
        .isEqualTo(ByteString.copyFrom(new byte[] {0, 0, 0, 0, 0, 0, 0, 3}));
    assertThat(row.getCells().get(2).getValue())
        .isEqualTo(ByteString.copyFrom(new byte[] {0, 0, 0, 0, 0x12, 0x34, 0x56, 0x79}));

    // Row key outside the authorized view
    String rowKeyOutsideAuthorizedView = UUID.randomUUID() + "-outside-authorized-view";
    try {
      testEnvRule
          .env()
          .getDataClient()
          .readModifyWriteRowAsync(
              ReadModifyWriteRow.create(
                      AuthorizedViewId.of(tableId, testAuthorizedView.getId()),
                      rowKeyOutsideAuthorizedView)
                  .append(family, AUTHORIZED_VIEW_COLUMN_QUALIFIER, "a"))
          .get(1, TimeUnit.MINUTES);
      fail("Should not be able to modify a row outside authorized view");
    } catch (Exception e) {
      assertThat(e.getCause()).isInstanceOf(PermissionDeniedException.class);
    }

    // Column qualifier outside the authorized view
    try {
      testEnvRule
          .env()
          .getDataClient()
          .readModifyWriteRowAsync(
              ReadModifyWriteRow.create(
                      AuthorizedViewId.of(tableId, testAuthorizedView.getId()), rowKey)
                  .append(family, "outside-authorized-view", "a"))
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
