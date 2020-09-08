/*
 * Copyright 2019 Google LLC
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

import static com.google.common.truth.Truth.*;

import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RowCellTest {

  @Test
  public void compareTest() {
    ByteString col1 = ByteString.copyFromUtf8("col1");
    long timestamp1 = 1_000;
    List<String> labels1 = ImmutableList.of("label1");
    ByteString value1 = ByteString.copyFromUtf8("value1");

    ByteString col2 = ByteString.copyFromUtf8("col2");
    long timestamp2 = 2_000;
    List<String> labels2 = ImmutableList.of("label2");
    ByteString value2 = ByteString.copyFromUtf8("value2");

    Comparator<RowCell> c = RowCell.compareByNative();

    // equal
    assertThat(
            c.compare(
                RowCell.create("family1", col1, timestamp1, labels1, value1),
                RowCell.create("family1", col1, timestamp1, labels1, value1)))
        .isEqualTo(0);

    // equal ignores labels & values
    assertThat(
            c.compare(
                RowCell.create("family1", col1, timestamp1, labels1, value1),
                RowCell.create("family1", col1, timestamp1, labels2, value2)))
        .isEqualTo(0);

    // family lesser then
    assertThat(
            c.compare(
                RowCell.create("family1", col1, timestamp1, labels1, value1),
                RowCell.create("family2", col1, timestamp1, labels1, value1)))
        .isEqualTo(-1);

    // family greater then
    assertThat(
            c.compare(
                RowCell.create("family2", col1, timestamp1, labels1, value1),
                RowCell.create("family1", col1, timestamp1, labels1, value1)))
        .isEqualTo(1);

    // col lesser then
    assertThat(
            c.compare(
                RowCell.create("family1", col1, timestamp1, labels1, value1),
                RowCell.create("family1", col2, timestamp1, labels1, value1)))
        .isEqualTo(-1);

    // col greater then
    assertThat(
            c.compare(
                RowCell.create("family1", col2, timestamp1, labels1, value1),
                RowCell.create("family1", col1, timestamp1, labels1, value1)))
        .isEqualTo(1);

    // reverse timestamp lesser then
    assertThat(
            c.compare(
                RowCell.create("family1", col1, timestamp2, labels1, value1),
                RowCell.create("family1", col1, timestamp1, labels1, value1)))
        .isEqualTo(-1);

    // reverse timestamp greater then
    assertThat(
            c.compare(
                RowCell.create("family1", col1, timestamp1, labels1, value1),
                RowCell.create("family1", col1, timestamp2, labels1, value1)))
        .isEqualTo(1);
  }

  @Test
  public void testSerialization() throws IOException, ClassNotFoundException {
    LazyStringArrayList lazyList = new LazyStringArrayList();
    lazyList.add("lazy");
    lazyList.add("very lazy");
    List[] labelLists = {
      Arrays.asList("str1", "str2", "str3"),
      ImmutableList.of("string1", "string2"),
      new UnmodifiableLazyStringList(lazyList),
      new UnmodifiableLazyStringList(LazyStringArrayList.EMPTY)
    };

    for (int i = 0; i < labelLists.length; i++) {
      String family = "family_" + i;
      ByteString col = ByteString.copyFromUtf8("col_" + i);
      long timestamp = 1000L * (i + 1);
      List<String> labels = labelLists[i];
      ByteString value = ByteString.copyFromUtf8("value_" + i);
      RowCell cell = RowCell.create(family, col, timestamp, labels, value);
      RowCell deserialized = (RowCell) serializeDeserialize(cell);

      assertThat(cell.getFamily()).isEqualTo(deserialized.getFamily());
      assertThat(cell.getQualifier()).isEqualTo(deserialized.getQualifier());
      assertThat(cell.getTimestamp()).isEqualTo(deserialized.getTimestamp());
      assertThat(cell.getLabels()).isEqualTo(deserialized.getLabels());
      assertThat(cell.getValue()).isEqualTo(deserialized.getValue());
    }
  }

  private static Object serializeDeserialize(Object obj)
      throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try (ObjectOutputStream outStream = new ObjectOutputStream(bos)) {
      outStream.writeObject(obj);
    }

    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    try (ObjectInputStream inStream = new ObjectInputStream(bis)) {
      return inStream.readObject();
    }
  }
}
