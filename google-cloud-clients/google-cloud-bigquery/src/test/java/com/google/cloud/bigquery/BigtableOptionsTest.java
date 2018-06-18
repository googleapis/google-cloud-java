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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

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
    assertEquals(COL1.getQualifierEncoded(), "aaa");
    assertEquals(COL1.getFieldName(), "field1");
    assertTrue(COL1.getOnlyReadLatest());
    assertEquals(COL1.getEncoding(), "BINARY");
    assertEquals(COL1.getType(), "BYTES");

    // family
    assertEquals(TESTFAMILY.getFamilyID(), "fooFamily");
    assertEquals(TESTFAMILY.getEncoding(), "TEXT");
    assertTrue(TESTFAMILY.getOnlyReadLatest());
    assertEquals(TESTFAMILY.getType(), "INTEGER");
    assertEquals(TESTFAMILY.getColumns(), ImmutableList.of(COL1, COL2));

    // options
    assertTrue(OPTIONS.getIgnoreUnspecifiedColumnFamilies());
    assertTrue(OPTIONS.getReadRowkeyAsString());
    assertEquals(OPTIONS.getColumnFamilies(), ImmutableList.of(TESTFAMILY));
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
    assertEquals(expected.getEncoding(), value.getEncoding());
    assertEquals(expected.getFieldName(), value.getFieldName());
    assertEquals(expected.getQualifierEncoded(), value.getQualifierEncoded());
    assertEquals(expected.getOnlyReadLatest(), value.getOnlyReadLatest());
    assertEquals(expected.getType(), value.getType());
  }

  private void compareBigtableColumnFamily(BigtableColumnFamily expected, BigtableColumnFamily value) {
    assertEquals(expected, value);
    assertEquals(expected.getFamilyID(), value.getFamilyID());
    assertEquals(expected.getOnlyReadLatest(), value.getOnlyReadLatest());
    assertEquals(expected.getColumns(), value.getColumns());
    assertEquals(expected.getEncoding(), value.getEncoding());
    assertEquals(expected.getType(), value.getType());
  }

  private void compareBigtableOptions(BigtableOptions expected, BigtableOptions value) {
    assertEquals(expected.getIgnoreUnspecifiedColumnFamilies(), value.getIgnoreUnspecifiedColumnFamilies());
    assertEquals(expected.getReadRowkeyAsString(), value.getReadRowkeyAsString());
    assertEquals(expected.getColumnFamilies(), value.getColumnFamilies());
  }
}