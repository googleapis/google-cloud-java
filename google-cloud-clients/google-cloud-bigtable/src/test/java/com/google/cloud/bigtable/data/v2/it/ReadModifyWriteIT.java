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

import com.google.cloud.bigtable.data.v2.it.env.TestEnvRule;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.protobuf.ByteString;
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
    String rowKey = testEnvRule.env().getRowPrefix();

    Row row =
        testEnvRule
            .env()
            .getDataClient()
            .readModifyWriteRowAsync(
                ReadModifyWriteRow.create(tableId, rowKey)
                    .append(family, "q1", "a")
                    .increment(family, "q2", 3))
            .get(1, TimeUnit.MINUTES);

    assertThat(row.getCells()).hasSize(2);
    assertThat(row.getCells().get(0).getValue()).isEqualTo(ByteString.copyFromUtf8("a"));
    assertThat(row.getCells().get(1).getValue())
        .isEqualTo(ByteString.copyFrom(new byte[] {0, 0, 0, 0, 0, 0, 0, 3}));
  }
}
