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

import com.google.common.collect.ImmutableList;
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
public class RowTest {
  @Test
  public void compareTest() {
    Row row1 =
        Row.create(
            ByteString.copyFromUtf8("key1"),
            ImmutableList.of(
                RowCell.create(
                    "family",
                    ByteString.EMPTY,
                    1000,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("value"))));
    Row row2 =
        Row.create(
            ByteString.copyFromUtf8("key2"),
            ImmutableList.of(
                RowCell.create(
                    "family",
                    ByteString.EMPTY,
                    1000,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("value"))));
    Row row2b =
        Row.create(
            ByteString.copyFromUtf8("key2"),
            ImmutableList.of(
                RowCell.create(
                    "family2",
                    ByteString.EMPTY,
                    1000,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("value"))));

    assertThat(row1).isEqualTo(row1);
    assertThat(row1).isLessThan(row2);
    assertThat(row2).isGreaterThan(row1);

    // Comparator only cares about row keys
    assertThat(row2).isEquivalentAccordingToCompareTo(row2b);
  }

  @Test
  public void serializationTest() throws IOException, ClassNotFoundException {
    Row expected =
        Row.create(
            ByteString.copyFromUtf8("key1"),
            ImmutableList.of(
                RowCell.create(
                    "family",
                    ByteString.EMPTY,
                    1000,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("value"))));

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(expected);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
    assertThat(ois.readObject()).isEqualTo(expected);
  }
}
