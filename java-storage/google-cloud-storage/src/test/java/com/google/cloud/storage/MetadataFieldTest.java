/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.MetadataField.PartRange;
import com.google.common.collect.ImmutableMap;
import java.util.function.Consumer;
import org.junit.Test;

public final class MetadataFieldTest {

  @Test
  public void appendTo_long_encode_works() {
    MetadataField<Long> l = MetadataField.forLong("long");
    ImmutableMap<String, String> map = mapFrom(b -> l.appendTo(37L, b));
    assertThat(map).containsEntry("long", "37");
  }

  @Test
  public void readFrom_long_decode_null() {
    ImmutableMap<String, String> map = ImmutableMap.of();
    MetadataField<Long> l = MetadataField.forLong("long");
    Long read = l.readFrom(map);
    assertThat(read).isNull();
  }

  @Test
  public void readFrom_long_decode_nonNull() {
    ImmutableMap<String, String> map = ImmutableMap.of("long", "37");
    MetadataField<Long> l = MetadataField.forLong("long");
    Long read = l.readFrom(map);
    assertThat(read).isNotNull();
    assertThat(read).isEqualTo(37L);
  }

  @Test
  public void readFrom_long_decode_blobInfo_null() {
    BlobInfo info = BlobInfo.newBuilder("b", "o").build();
    MetadataField<Long> l = MetadataField.forLong("long");
    Long read = l.readFrom(info);
    assertThat(read).isNull();
  }

  @Test
  public void readFrom_long_decode_blobInfo_nonNull() {
    ImmutableMap<String, String> map = ImmutableMap.of("long", "37");
    BlobInfo info = BlobInfo.newBuilder("b", "o").setMetadata(map).build();
    MetadataField<Long> l = MetadataField.forLong("long");
    Long read = l.readFrom(info);
    assertThat(read).isNotNull();
    assertThat(read).isEqualTo(37L);
  }

  @Test
  public void appendTo_string_encode_works() {
    MetadataField<String> l = MetadataField.forString("string");
    ImmutableMap<String, String> map = mapFrom(b -> l.appendTo("blah", b));
    assertThat(map).containsEntry("string", "blah");
  }

  @Test
  public void readFrom_string_decode_null() {
    ImmutableMap<String, String> map = ImmutableMap.of();
    MetadataField<String> l = MetadataField.forString("string");
    String read = l.readFrom(map);
    assertThat(read).isNull();
  }

  @Test
  public void readFrom_string_decode_nonNull() {
    ImmutableMap<String, String> map = ImmutableMap.of("string", "blah");
    MetadataField<String> l = MetadataField.forString("string");
    String read = l.readFrom(map);
    assertThat(read).isNotNull();
    assertThat(read).isEqualTo("blah");
  }

  @Test
  public void appendTo_partRange_encode_works() {
    MetadataField<PartRange> l = MetadataField.forPartRange("partRange");
    ImmutableMap<String, String> map = mapFrom(b -> l.appendTo(PartRange.of(37L), b));
    assertThat(map).containsEntry("partRange", "0037-0037");
  }

  @Test
  public void readFrom_partRange_decode_null() {
    ImmutableMap<String, String> map = ImmutableMap.of();
    MetadataField<PartRange> l = MetadataField.forPartRange("partRange");
    PartRange read = l.readFrom(map);
    assertThat(read).isNull();
  }

  @Test
  public void readFrom_partRange_decode_nonNull() {
    ImmutableMap<String, String> map = ImmutableMap.of("partRange", "0037-0037");
    MetadataField<PartRange> l = MetadataField.forPartRange("partRange");
    PartRange read = l.readFrom(map);
    assertThat(read).isNotNull();
    assertThat(read).isEqualTo(PartRange.of(37L));
  }

  @Test
  public void partRange_handlesNumbersWithMoreThanFourDigits_encode() {

    PartRange r = PartRange.of(0, 123456);

    String encode = r.encode();
    assertThat(encode).isEqualTo("0000-123456");
  }

  @Test
  public void partRange_handlesNumbersWithMoreThanFourDigits_decode() {

    PartRange expected = PartRange.of(0, 123456);

    PartRange decode = PartRange.decode("0000-123456");
    assertThat(decode).isEqualTo(expected);
  }

  private static ImmutableMap<String, String> mapFrom(
      Consumer<ImmutableMap.Builder<String, String>> f) {
    ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();
    f.accept(builder);
    return builder.build();
  }
}
