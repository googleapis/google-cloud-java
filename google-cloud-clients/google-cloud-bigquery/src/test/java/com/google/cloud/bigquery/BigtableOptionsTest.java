/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

public class BigtableOptionsTest {

  private static final BigtableColumn COL1 = BigtableColumn.newBuilder()
      .setQualifierEncoded("aaa")
      .setFieldName("field1")
      .setOnlyReadLatest(true)
      .setEncoding("BINARY")
      .setType("BYTES")
      .build();
  private static final BigtableColumn COL2 = BigtableColumn.newBuilder()
      .setQualifierEncoded("bbb")
      .setFieldName("field2")
      .setOnlyReadLatest(true)
      .setEncoding("TEXT")
      .setType("STRING")
      .build();
  private static final BigtableColumnFamily TESTFAMILY = BigtableColumnFamily.newBuilder()
      .setFamilyID("fooFamily")
      .setEncoding("TEXT")
      .setOnlyReadLatest(true)
      .setType("INTEGER")
      .setColumns(ImmutableList.of(COL1, COL2))
      .build();
  private static final BigtableOptions OPTIONS = BigtableOptions.newBuilder()
      .setIgnoreUnspecifiedColumnFamilies(true)
      .setReadRowkeyAsString(true)
      .setColumnFamilies(ImmutableList.of(TESTFAMILY))
      .build();

  @Test
  public void testConstructors() {
    // column
    assertThat(COL1.getQualifierEncoded()).isEqualTo("aaa");
    assertThat(COL1.getFieldName()).isEqualTo("field1");
    assertThat(COL1.getOnlyReadLatest()).isEqualTo(true);
    assertThat(COL1.getEncoding()).isEqualTo("BINARY");
    assertThat(COL1.getType()).isEqualTo("BYTES");

    // family
    assertThat(TESTFAMILY.getFamilyID()).isEqualTo("fooFamily");
    assertThat(TESTFAMILY.getEncoding()).isEqualTo("TEXT");
    assertThat(TESTFAMILY.getOnlyReadLatest()).isEqualTo(true);
    assertThat(TESTFAMILY.getType()).isEqualTo("INTEGER");
    assertThat(TESTFAMILY.getColumns()).isEqualTo(ImmutableList.of(COL1, COL2));

    // options
    assertThat(OPTIONS.getIgnoreUnspecifiedColumnFamilies()).isEqualTo(true);
    assertThat(OPTIONS.getReadRowkeyAsString()).isEqualTo(true);
    assertThat(OPTIONS.getColumnFamilies()).isEqualTo(ImmutableList.of(TESTFAMILY));
  }

  @Test
  public void testToAndFromPb() {
    compareBigtableColumn(COL1, BigtableColumn.fromPb(COL1.toPb()));
    compareBigtableColumnFamily(TESTFAMILY, BigtableColumnFamily.fromPb(TESTFAMILY.toPb()));
    compareBigtableOptions(OPTIONS, BigtableOptions.fromPb(OPTIONS.toPb()));
  }

  @Test
  public void testEquals() {
    compareBigtableColumn(COL1, COL1);
    compareBigtableColumnFamily(TESTFAMILY, TESTFAMILY);
    compareBigtableOptions(OPTIONS, OPTIONS);
  }

  private void compareBigtableColumn(BigtableColumn expected, BigtableColumn value) {
    assertThat(expected).isEqualTo(value);
    assertThat(expected.getEncoding()).isEqualTo(value.getEncoding());
    assertThat(expected.getFieldName()).isEqualTo(value.getFieldName());
    assertThat(expected.getQualifierEncoded()).isEqualTo(value.getQualifierEncoded());
    assertThat(expected.getOnlyReadLatest()).isEqualTo(value.getOnlyReadLatest());
    assertThat(expected.getType()).isEqualTo(value.getType());
  }

  private void compareBigtableColumnFamily(BigtableColumnFamily expected,
      BigtableColumnFamily value) {
    assertThat(expected).isEqualTo(value);
    assertThat(expected.getFamilyID()).isEqualTo(value.getFamilyID());
    assertThat(expected.getOnlyReadLatest()).isEqualTo(value.getOnlyReadLatest());
    assertThat(expected.getColumns()).isEqualTo(value.getColumns());
    assertThat(expected.getEncoding()).isEqualTo(value.getEncoding());
    assertThat(expected.getType()).isEqualTo(value.getType());

  }

  private void compareBigtableOptions(BigtableOptions expected, BigtableOptions value) {
    assertThat(expected).isEqualTo(value);
    assertThat(expected.getIgnoreUnspecifiedColumnFamilies())
        .isEqualTo(value.getIgnoreUnspecifiedColumnFamilies());
    assertThat(expected.getReadRowkeyAsString()).isEqualTo(value.getReadRowkeyAsString());
    assertThat(expected.getColumnFamilies()).isEqualTo(value.getColumnFamilies());
  }
}