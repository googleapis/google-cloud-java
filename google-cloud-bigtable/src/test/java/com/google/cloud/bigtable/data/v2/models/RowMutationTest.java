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

import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RowMutationTest {
  private static final InstanceName INSTANCE_NAME =
      InstanceName.of("fake-project", "fake-instance");
  private static final String APP_PROFILE_ID = "fake-profile";
  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create(INSTANCE_NAME, APP_PROFILE_ID);

  @Test
  public void toProtoTest() {
    long timestampMin = System.currentTimeMillis() * 1_000;

    RowMutation rowMutation =
        RowMutation.create("fake-table", "fake-key")
            .setCell("fake-family", "fake-qualifier", "fake-value");

    MutateRowRequest actualRowMutation = rowMutation.toProto(REQUEST_CONTEXT);
    com.google.common.collect.Range<Long> timestampRange =
        com.google.common.collect.Range.closed(timestampMin, System.currentTimeMillis() * 1_000);

    assertThat(actualRowMutation.getTableName())
        .isEqualTo(
            TableName.of(INSTANCE_NAME.getProject(), INSTANCE_NAME.getInstance(), "fake-table")
                .toString());
    assertThat(actualRowMutation.getAppProfileId()).isEqualTo(APP_PROFILE_ID);
    assertThat(actualRowMutation.getMutationsList()).hasSize(1);
    assertThat(actualRowMutation.getMutations(0).getSetCell().getValue())
        .isEqualTo(ByteString.copyFromUtf8("fake-value"));
    assertThat(actualRowMutation.getMutations(0).getSetCell().getTimestampMicros())
        .isIn(timestampRange);
  }

  @Test
  public void toBulkProtoTest() {
    long timestampMin = System.currentTimeMillis() * 1_000;

    RowMutation rowMutation =
        RowMutation.create("fake-table", "fake-key")
            .setCell("fake-family", "fake-qualifier", "fake-value");

    MutateRowsRequest actualRowMutation = rowMutation.toBulkProto(REQUEST_CONTEXT);

    com.google.common.collect.Range<Long> timestampRange =
        com.google.common.collect.Range.closed(timestampMin, System.currentTimeMillis() * 1_000);

    assertThat(actualRowMutation.getTableName())
        .isEqualTo(
            TableName.of(INSTANCE_NAME.getProject(), INSTANCE_NAME.getInstance(), "fake-table")
                .toString());
    assertThat(actualRowMutation.getAppProfileId()).isEqualTo(APP_PROFILE_ID);
    assertThat(actualRowMutation.getEntriesList()).hasSize(1);
    assertThat(actualRowMutation.getEntries(0).getMutationsList()).hasSize(1);
    assertThat(actualRowMutation.getEntries(0).getMutations(0).getSetCell().getValue())
        .isEqualTo(ByteString.copyFromUtf8("fake-value"));

    assertThat(actualRowMutation.getEntries(0).getMutations(0).getSetCell().getTimestampMicros())
        .isIn(timestampRange);
  }

  @Test
  public void serializationTest() throws IOException, ClassNotFoundException {
    RowMutation expected =
        RowMutation.create("fake-table", "fake-key")
            .setCell("fake-family", "fake-qualifier", 10_000, "fake-value");

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(expected);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

    RowMutation actual = (RowMutation) ois.readObject();
    assertThat(actual.toProto(REQUEST_CONTEXT)).isEqualTo(expected.toProto(REQUEST_CONTEXT));
  }
}
