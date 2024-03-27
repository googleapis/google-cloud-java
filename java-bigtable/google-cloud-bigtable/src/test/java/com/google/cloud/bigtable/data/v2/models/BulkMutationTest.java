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
package com.google.cloud.bigtable.data.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.MutateRowsRequest;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.protobuf.ByteString;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat.ParseException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BulkMutationTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "fake-table";
  private static final String AUTHORIZED_VIEW_ID = "fake-authorized-view";
  private static final String APP_PROFILE = "fake-profile";
  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create(PROJECT_ID, INSTANCE_ID, APP_PROFILE);

  @Test
  public void test() throws ParseException {
    // Test BulkMutation on a table.
    BulkMutation m =
        BulkMutation.create(TABLE_ID)
            .add(
                "key-a",
                Mutation.create()
                    .setCell("fake-family1", "fake-qualifier1", 1_000, "fake-value1")
                    .setCell("fake-family2", "fake-qualifier2", 2_000, "fake-value2"))
            .add(
                ByteString.copyFromUtf8("key-b"),
                Mutation.create().setCell("fake-family3", "fake-qualifier3", 3_000, "fake-value3"));

    MutateRowsRequest actual = m.toProto(REQUEST_CONTEXT);

    MutateRowsRequest.Builder expected =
        MutateRowsRequest.newBuilder()
            .setTableName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
            .setAppProfileId(APP_PROFILE);
    TextFormat.merge(
        "entries {"
            + "  row_key: 'key-a'"
            + "  mutations {"
            + "    set_cell {"
            + "      family_name: 'fake-family1'"
            + "      column_qualifier: 'fake-qualifier1'"
            + "      timestamp_micros: 1000"
            + "      value: 'fake-value1'"
            + "    }"
            + "  }"
            + "  mutations {"
            + "    set_cell {"
            + "      family_name: 'fake-family2'"
            + "      column_qualifier: 'fake-qualifier2'"
            + "      timestamp_micros: 2000"
            + "      value: 'fake-value2'"
            + "    }"
            + "  }"
            + "}"
            + "entries {"
            + "  row_key: 'key-b'"
            + "  mutations {"
            + "    set_cell {"
            + "      family_name: 'fake-family3'"
            + "      column_qualifier: 'fake-qualifier3'"
            + "      timestamp_micros: 3000"
            + "      value: 'fake-value3'"
            + "    }"
            + "  }"
            + "}",
        expected);

    assertThat(actual).isEqualTo(expected.build());

    // Test BulkMutation on an authorized view.
    m =
        BulkMutation.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID))
            .add(
                "key-a",
                Mutation.create()
                    .setCell("fake-family1", "fake-qualifier1", 1_000, "fake-value1")
                    .setCell("fake-family2", "fake-qualifier2", 2_000, "fake-value2"))
            .add(
                ByteString.copyFromUtf8("key-b"),
                Mutation.create().setCell("fake-family3", "fake-qualifier3", 3_000, "fake-value3"));

    actual = m.toProto(REQUEST_CONTEXT);

    expected
        .clearTableName()
        .setAuthorizedViewName(
            NameUtil.formatAuthorizedViewName(
                PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID))
        .setAppProfileId(APP_PROFILE);

    assertThat(actual).isEqualTo(expected.build());
  }

  @Test
  public void serializationTest() throws IOException, ClassNotFoundException {
    // Test BulkMutation on a table.
    BulkMutation expected =
        BulkMutation.create(TABLE_ID)
            .add(
                "key-a",
                Mutation.create().setCell("fake-family1", "fake-qualifier1", 1_000, "fake-value1"));

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(expected);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

    BulkMutation actual = (BulkMutation) ois.readObject();
    assertThat(actual.toProto(REQUEST_CONTEXT)).isEqualTo(expected.toProto(REQUEST_CONTEXT));

    // Test BulkMutation on an authorized view.
    expected =
        BulkMutation.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID))
            .add(
                "key-a",
                Mutation.create().setCell("fake-family1", "fake-qualifier1", 1_000, "fake-value1"));

    bos = new ByteArrayOutputStream();
    oos = new ObjectOutputStream(bos);
    oos.writeObject(expected);
    oos.close();

    ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

    actual = (BulkMutation) ois.readObject();
    assertThat(actual.toProto(REQUEST_CONTEXT)).isEqualTo(expected.toProto(REQUEST_CONTEXT));
  }

  @Test
  public void cloneTest() {
    // Test BulkMutation on a table.
    BulkMutation originalTableBulkMutation =
        BulkMutation.create(TABLE_ID)
            .add(
                "test-rowKey",
                Mutation.create().setCell("fake-family1", "fake-qualifier1", 12345, "fake-value1"));

    MutateRowsRequest originalTableRequest = originalTableBulkMutation.toProto(REQUEST_CONTEXT);
    BulkMutation clonedTableMutation = originalTableBulkMutation.clone();
    MutateRowsRequest clonedTableRequest = clonedTableMutation.toProto(REQUEST_CONTEXT);

    // Both BulkMutations should be equals.
    assertThat(clonedTableRequest).isEqualTo(originalTableRequest);
    assertThat(clonedTableRequest.getTableName()).isEqualTo(originalTableRequest.getTableName());
    assertThat(clonedTableRequest.getAuthorizedViewName())
        .isEqualTo(originalTableRequest.getAuthorizedViewName());
    assertThat(clonedTableRequest.getEntriesList())
        .isEqualTo(originalTableRequest.getEntriesList());

    // Mutating cloned BulkMutation
    clonedTableMutation.add(
        "another-rowKey", Mutation.create().deleteCells("delete-family", "delete-qualifier"));
    assertThat(clonedTableMutation.toProto(REQUEST_CONTEXT)).isNotEqualTo(originalTableRequest);

    // Test BulkMutation on an authorized view.
    BulkMutation originalAuthorizedViewBulkMutation =
        BulkMutation.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID))
            .add(
                "test-rowKey",
                Mutation.create().setCell("fake-family1", "fake-qualifier1", 12345, "fake-value1"));

    MutateRowsRequest originalAuthorizedViewRequest =
        originalAuthorizedViewBulkMutation.toProto(REQUEST_CONTEXT);
    BulkMutation clonedAuthorizedViewMutation = originalAuthorizedViewBulkMutation.clone();
    MutateRowsRequest clonedAuthorizedViewRequest =
        clonedAuthorizedViewMutation.toProto(REQUEST_CONTEXT);

    // Both BulkMutations should be equals.
    assertThat(clonedAuthorizedViewRequest).isEqualTo(originalAuthorizedViewRequest);
    assertThat(clonedAuthorizedViewRequest.getTableName())
        .isEqualTo(originalAuthorizedViewRequest.getTableName());
    assertThat(clonedAuthorizedViewRequest.getAuthorizedViewName())
        .isEqualTo(originalAuthorizedViewRequest.getAuthorizedViewName());
    assertThat(clonedAuthorizedViewRequest.getEntriesList())
        .isEqualTo(originalAuthorizedViewRequest.getEntriesList());

    // Mutating cloned BulkMutation
    clonedAuthorizedViewMutation.add(
        "another-rowKey", Mutation.create().deleteCells("delete-family", "delete-qualifier"));
    assertThat(clonedAuthorizedViewMutation.toProto(REQUEST_CONTEXT))
        .isNotEqualTo(originalAuthorizedViewRequest);

    // BulkMutations on an authorized view is different from BulkMutations on a table.
    assertThat(originalAuthorizedViewRequest).isNotEqualTo(originalTableRequest);
    assertThat(clonedAuthorizedViewRequest).isNotEqualTo(clonedTableRequest);
  }

  @Test
  public void addRowMutationEntry() {
    RowMutationEntry entry =
        RowMutationEntry.create("test-rowKey")
            .setCell("fake-family1", "fake-qualifier1", "fake-value1");

    // Test BulkMutation on a table.
    BulkMutation bulkMutation = BulkMutation.create(TABLE_ID);
    bulkMutation.add(entry);
    assertThat(bulkMutation.toProto(REQUEST_CONTEXT).getEntriesList()).contains(entry.toProto());

    // Test BulkMutation on an authorized view.
    bulkMutation = BulkMutation.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID));
    bulkMutation.add(entry);
    assertThat(bulkMutation.toProto(REQUEST_CONTEXT).getEntriesList()).contains(entry.toProto());
  }

  @Test
  public void fromProtoTest() {
    // Test BulkMutation on a table.
    BulkMutation expected =
        BulkMutation.create(TABLE_ID)
            .add(
                "key",
                Mutation.create().setCell("fake-family", "fake-qualifier", 10_000L, "fake-value"));

    MutateRowsRequest protoRequest = expected.toProto(REQUEST_CONTEXT);
    BulkMutation actualBulkMutation = BulkMutation.fromProto(protoRequest);

    assertThat(actualBulkMutation.toProto(REQUEST_CONTEXT)).isEqualTo(protoRequest);

    String projectId = "fresh-project";
    String instanceId = "fresh-instance";
    String appProfile = "fresh-app-profile";
    MutateRowsRequest overriddenRequest =
        actualBulkMutation.toProto(RequestContext.create(projectId, instanceId, appProfile));

    assertThat(overriddenRequest).isNotEqualTo(protoRequest);
    assertThat(overriddenRequest.getTableName())
        .matches(NameUtil.formatTableName(projectId, instanceId, TABLE_ID));
    assertThat(overriddenRequest.getAuthorizedViewName()).isEmpty();
    assertThat(overriddenRequest.getAppProfileId()).matches(appProfile);

    // Test BulkMutation on an authorized view.
    expected =
        BulkMutation.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID))
            .add(
                "key",
                Mutation.create().setCell("fake-family", "fake-qualifier", 10_000L, "fake-value"));

    protoRequest = expected.toProto(REQUEST_CONTEXT);
    actualBulkMutation = BulkMutation.fromProto(protoRequest);

    assertThat(actualBulkMutation.toProto(REQUEST_CONTEXT)).isEqualTo(protoRequest);

    overriddenRequest =
        actualBulkMutation.toProto(RequestContext.create(projectId, instanceId, appProfile));

    assertThat(overriddenRequest).isNotEqualTo(protoRequest);
    assertThat(overriddenRequest.getTableName()).isEmpty();
    assertThat(overriddenRequest.getAuthorizedViewName())
        .matches(
            NameUtil.formatAuthorizedViewName(projectId, instanceId, TABLE_ID, AUTHORIZED_VIEW_ID));
    assertThat(overriddenRequest.getAppProfileId()).matches(appProfile);
  }

  @Test
  public void testManyMutations() {
    BulkMutation bulkMutation = BulkMutation.create(TABLE_ID);

    try {
      for (int i = 0; i < 3; i++) {
        String key = "key" + i;
        Mutation mutation = Mutation.create();
        for (int j = 0; j < 50000; j++) {
          mutation.setCell("f", "q" + j, "value");
        }
        bulkMutation.add(key, mutation);
      }
      Assert.fail("Test should fail with IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage()).contains("Too many mutations");
    }

    // we should be able to add 10000 mutations
    bulkMutation = BulkMutation.create(TABLE_ID);
    Mutation mutation = Mutation.create();
    for (int i = 0; i < 100000; i++) {
      mutation.setCell("f", "q" + i, "value");
    }
    bulkMutation.add("key", mutation);
  }
}
