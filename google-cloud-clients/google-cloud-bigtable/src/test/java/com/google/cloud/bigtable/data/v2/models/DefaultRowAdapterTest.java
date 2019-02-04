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

import com.google.cloud.bigtable.data.v2.models.RowAdapter.RowBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DefaultRowAdapterTest {

  private final DefaultRowAdapter adapter = new DefaultRowAdapter();
  private RowBuilder<Row> rowBuilder;

  @Before
  public void setUp() {
    rowBuilder = adapter.createRowBuilder();
  }

  @Test
  public void singleCellRowTest() {
    ByteString value = ByteString.copyFromUtf8("my-value");
    rowBuilder.startRow(ByteString.copyFromUtf8("my-key"));
    rowBuilder.startCell(
        "my-family",
        ByteString.copyFromUtf8("my-qualifier"),
        100,
        ImmutableList.of("my-label"),
        value.size());
    rowBuilder.cellValue(value);
    rowBuilder.finishCell();

    assertThat(rowBuilder.finishRow())
        .isEqualTo(
            Row.create(
                ByteString.copyFromUtf8("my-key"),
                ImmutableList.of(
                    RowCell.create(
                        "my-family",
                        ByteString.copyFromUtf8("my-qualifier"),
                        100,
                        ImmutableList.of("my-label"),
                        value))));
  }

  @Test
  public void multiCellTest() {
    List<RowCell> expectedCells = Lists.newArrayList();

    rowBuilder.startRow(ByteString.copyFromUtf8("my-key"));

    for (int i = 0; i < 10; i++) {
      ByteString value = ByteString.copyFromUtf8("value-" + i);
      ByteString qualifier = ByteString.copyFromUtf8("qualifier-" + i);
      rowBuilder.startCell("family", qualifier, 1000, ImmutableList.of("my-label"), value.size());
      rowBuilder.cellValue(value);
      rowBuilder.finishCell();

      expectedCells.add(
          RowCell.create("family", qualifier, 1000, ImmutableList.of("my-label"), value));
    }

    assertThat(rowBuilder.finishRow())
        .isEqualTo(Row.create(ByteString.copyFromUtf8("my-key"), expectedCells));
  }

  @Test
  public void splitCellTest() {
    ByteString part1 = ByteString.copyFromUtf8("part1");
    ByteString part2 = ByteString.copyFromUtf8("part2");

    rowBuilder.startRow(ByteString.copyFromUtf8("my-key"));
    rowBuilder.startCell(
        "family",
        ByteString.copyFromUtf8("qualifier"),
        1000,
        ImmutableList.of("my-label"),
        part1.size() + part2.size());
    rowBuilder.cellValue(part1);
    rowBuilder.cellValue(part2);
    rowBuilder.finishCell();

    assertThat(rowBuilder.finishRow())
        .isEqualTo(
            Row.create(
                ByteString.copyFromUtf8("my-key"),
                ImmutableList.of(
                    RowCell.create(
                        "family",
                        ByteString.copyFromUtf8("qualifier"),
                        1000,
                        ImmutableList.of("my-label"),
                        ByteString.copyFromUtf8("part1part2")))));
  }

  @Test
  public void markerRowTest() {
    Row markerRow = rowBuilder.createScanMarkerRow(ByteString.copyFromUtf8("key"));
    assertThat(adapter.isScanMarkerRow(markerRow)).isTrue();

    ByteString value = ByteString.copyFromUtf8("value");
    rowBuilder.startRow(ByteString.copyFromUtf8("key"));
    rowBuilder.startCell(
        "family", ByteString.EMPTY, 1000, ImmutableList.<String>of(), value.size());
    rowBuilder.cellValue(value);
    rowBuilder.finishCell();

    assertThat(adapter.isScanMarkerRow(rowBuilder.finishRow())).isFalse();
  }

  @Test
  public void sortFamiliesAreSorted() {
    ByteString col1 = ByteString.copyFromUtf8("col1");
    ByteString col2 = ByteString.copyFromUtf8("col2");
    List<String> labels = ImmutableList.of();
    ByteString value1 = ByteString.copyFromUtf8("my-value1");
    ByteString value2 = ByteString.copyFromUtf8("my-value2");
    ByteString value3 = ByteString.copyFromUtf8("my-value3");
    ByteString value4 = ByteString.copyFromUtf8("my-value4");

    rowBuilder.startRow(ByteString.copyFromUtf8("key1"));

    // family2 with 2 cells is received before family1
    rowBuilder.startCell("family2", col1, 1000, labels, value1.size());
    rowBuilder.cellValue(value1);
    rowBuilder.finishCell();

    rowBuilder.startCell("family2", col2, 1000, labels, value2.size());
    rowBuilder.cellValue(value2);
    rowBuilder.finishCell();

    // family1 with 2 cells is received after family2 cells
    rowBuilder.startCell("family1", col1, 1000, ImmutableList.<String>of(), value3.size());
    rowBuilder.cellValue(value3);
    rowBuilder.finishCell();

    rowBuilder.startCell("family1", col2, 1000, ImmutableList.<String>of(), value4.size());
    rowBuilder.cellValue(value4);
    rowBuilder.finishCell();

    Row actualRow = rowBuilder.finishRow();

    // The resulting the cells will reorder family1 first
    assertThat(actualRow.getCells())
        .containsExactlyElementsIn(
            ImmutableList.of(
                RowCell.create("family1", col1, 1000, labels, value3),
                RowCell.create("family1", col2, 1000, labels, value4),
                RowCell.create("family2", col1, 1000, labels, value1),
                RowCell.create("family2", col2, 1000, labels, value2)))
        .inOrder();
  }
}
