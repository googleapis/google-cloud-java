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
import static com.google.common.truth.TruthJUnit.assume;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView;
import com.google.cloud.bigtable.admin.v2.models.CreateAuthorizedViewRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.SubsetView;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.KeyOffset;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SampleRowsIT {
  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  @Test
  public void test() throws InterruptedException, ExecutionException, TimeoutException {
    BigtableDataClient client = testEnvRule.env().getDataClient();
    String rowPrefix = UUID.randomUUID().toString();

    // Create some data so that sample row keys has something to show
    List<ApiFuture<?>> futures = Lists.newArrayList();
    for (int i = 0; i < 10; i++) {
      ApiFuture<Void> future =
          client.mutateRowAsync(
              RowMutation.create(testEnvRule.env().getTableId(), rowPrefix + "-" + i)
                  .setCell(testEnvRule.env().getFamilyId(), "", "value"));
      futures.add(future);
    }
    ApiFutures.allAsList(futures).get(1, TimeUnit.MINUTES);

    ApiFuture<List<KeyOffset>> future = client.sampleRowKeysAsync(testEnvRule.env().getTableId());

    List<KeyOffset> results = future.get(1, TimeUnit.MINUTES);

    assertThat(results).isNotEmpty();
    assertThat(results.get(results.size() - 1).getOffsetBytes()).isGreaterThan(0L);
  }

  @Test
  public void testOnAuthorizedView()
      throws InterruptedException, ExecutionException, TimeoutException {
    assume()
        .withMessage("AuthorizedView is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);
    AuthorizedView testAuthorizedView = createPreSplitTableAndAuthorizedView();

    BigtableDataClient client = testEnvRule.env().getDataClient();

    ApiFuture<List<KeyOffset>> future =
        client.sampleRowKeysAsync(
            AuthorizedViewId.of(testAuthorizedView.getTableId(), testAuthorizedView.getId()));

    List<KeyOffset> results = future.get(1, TimeUnit.MINUTES);

    List<ByteString> resultKeys = new ArrayList<>();
    for (KeyOffset keyOffset : results) {
      resultKeys.add(keyOffset.getKey());
    }

    assertThat(resultKeys)
        .containsExactly(
            ByteString.copyFromUtf8("food"),
            ByteString.copyFromUtf8("fool"),
            ByteString.copyFromUtf8("fop"));

    testEnvRule
        .env()
        .getTableAdminClient()
        .deleteAuthorizedView(testAuthorizedView.getTableId(), testAuthorizedView.getId());
  }

  private static AuthorizedView createPreSplitTableAndAuthorizedView() {
    String tableId = UUID.randomUUID().toString();
    String authorizedViewId = UUID.randomUUID().toString();

    testEnvRule
        .env()
        .getTableAdminClient()
        .createTable(
            CreateTableRequest.of(tableId)
                .addSplit(ByteString.copyFromUtf8("apple"))
                .addSplit(ByteString.copyFromUtf8("food"))
                .addSplit(ByteString.copyFromUtf8("fool"))
                .addSplit(ByteString.copyFromUtf8("good")));
    CreateAuthorizedViewRequest request =
        CreateAuthorizedViewRequest.of(tableId, authorizedViewId)
            .setAuthorizedViewType(SubsetView.create().addRowPrefix("foo"))
            .setDeletionProtection(false);
    return testEnvRule.env().getTableAdminClient().createAuthorizedView(request);
  }
}
