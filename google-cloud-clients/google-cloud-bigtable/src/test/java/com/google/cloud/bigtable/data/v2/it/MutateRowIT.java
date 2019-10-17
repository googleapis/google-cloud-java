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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
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
}
