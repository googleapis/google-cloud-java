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

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.it.env.TestEnvRule;
import com.google.cloud.bigtable.data.v2.models.BulkMutationBatcher;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.common.collect.Lists;
import com.google.common.truth.Truth;
import com.google.protobuf.ByteString;
import java.util.List;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BulkMutationBatcherIT {
  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  @Test
  public void test() throws Exception {
    BigtableDataClient client = testEnvRule.env().getDataClient();
    String tableId = testEnvRule.env().getTableName().getTable();
    String family = testEnvRule.env().getFamilyId();
    String rowPrefix = testEnvRule.env().getRowPrefix();

    try (BulkMutationBatcher batcher = client.newBulkMutationBatcher()) {
      for (int i = 0; i < 10; i++) {
        batcher.add(
            RowMutation.create(tableId, rowPrefix + "-" + i).setCell(family, "q", 10_000, "value"));
      }
    }

    List<Row> expectedRows = Lists.newArrayList();
    for (int i = 0; i < 10; i++) {
      expectedRows.add(
          Row.create(
              ByteString.copyFromUtf8(rowPrefix + "-" + i),
              Lists.newArrayList(
                  RowCell.create(
                      family,
                      ByteString.copyFromUtf8("q"),
                      10_000,
                      Lists.<String>newArrayList(),
                      ByteString.copyFromUtf8("value")))));
    }
    ServerStream<Row> actualRows = client.readRows(Query.create(tableId).prefix(rowPrefix));

    Truth.assertThat(actualRows).containsExactlyElementsIn(expectedRows);
  }
}
