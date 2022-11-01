/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.ReadRowsResponse.CellChunk;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RowMergerUtilTest extends TestCase {

  @Test
  public void testEmpty() {
    try (RowMergerUtil util = new RowMergerUtil()) {}

    try (RowMergerUtil util = new RowMergerUtil()) {
      util.parseReadRowsResponses(ImmutableList.of());
    }
  }

  @Test
  public void testSingle() {
    List<ReadRowsResponse> responses =
        ImmutableList.of(
            ReadRowsResponse.newBuilder()
                .addChunks(
                    CellChunk.newBuilder()
                        .setRowKey(ByteString.copyFromUtf8("key"))
                        .setFamilyName(StringValue.newBuilder().setValue("family"))
                        .setQualifier(
                            BytesValue.newBuilder().setValue(ByteString.copyFromUtf8("qualifier")))
                        .setTimestampMicros(1000)
                        .setValue(ByteString.copyFromUtf8("value"))
                        .setCommitRow(true))
                .build());
    try (RowMergerUtil util = new RowMergerUtil()) {
      List<Row> rows = util.parseReadRowsResponses(responses);
      assertThat(rows)
          .containsExactly(
              Row.create(
                  ByteString.copyFromUtf8("key"),
                  ImmutableList.of(
                      RowCell.create(
                          "family",
                          ByteString.copyFromUtf8("qualifier"),
                          1000,
                          ImmutableList.of(),
                          ByteString.copyFromUtf8("value")))));
    }
  }

  @Test
  public void testMultiple() {
    List<ReadRowsResponse> responses =
        ImmutableList.of(
            ReadRowsResponse.newBuilder()
                .addChunks(
                    CellChunk.newBuilder()
                        .setRowKey(ByteString.copyFromUtf8("key"))
                        .setFamilyName(StringValue.newBuilder().setValue("family"))
                        .setQualifier(
                            BytesValue.newBuilder().setValue(ByteString.copyFromUtf8("qualifier")))
                        .setTimestampMicros(1000)
                        .setValue(ByteString.copyFromUtf8("value"))
                        .setCommitRow(true))
                .build(),
            ReadRowsResponse.newBuilder()
                .addChunks(
                    CellChunk.newBuilder()
                        .setRowKey(ByteString.copyFromUtf8("key2"))
                        .setFamilyName(StringValue.newBuilder().setValue("family"))
                        .setQualifier(
                            BytesValue.newBuilder().setValue(ByteString.copyFromUtf8("qualifier")))
                        .setTimestampMicros(1000)
                        .setValue(ByteString.copyFromUtf8("value"))
                        .setCommitRow(true))
                .build());
    try (RowMergerUtil util = new RowMergerUtil()) {
      assertThat(util.parseReadRowsResponses(responses))
          .containsExactly(
              Row.create(
                  ByteString.copyFromUtf8("key"),
                  ImmutableList.of(
                      RowCell.create(
                          "family",
                          ByteString.copyFromUtf8("qualifier"),
                          1000,
                          ImmutableList.of(),
                          ByteString.copyFromUtf8("value")))),
              Row.create(
                  ByteString.copyFromUtf8("key2"),
                  ImmutableList.of(
                      RowCell.create(
                          "family",
                          ByteString.copyFromUtf8("qualifier"),
                          1000,
                          ImmutableList.of(),
                          ByteString.copyFromUtf8("value")))));
    }
  }

  @Test
  public void testPartial() {
    List<ReadRowsResponse> responses =
        ImmutableList.of(
            ReadRowsResponse.newBuilder()
                .addChunks(
                    CellChunk.newBuilder()
                        .setRowKey(ByteString.copyFromUtf8("key"))
                        .setFamilyName(StringValue.newBuilder().setValue("family"))
                        .setQualifier(
                            BytesValue.newBuilder().setValue(ByteString.copyFromUtf8("qualifier")))
                        .setTimestampMicros(1000)
                        .setValue(ByteString.copyFromUtf8("value"))
                        .setCommitRow(false))
                .build());

    RowMergerUtil util = new RowMergerUtil();
    util.parseReadRowsResponses(responses);
    Assert.assertThrows(IllegalStateException.class, util::close);
  }
}
