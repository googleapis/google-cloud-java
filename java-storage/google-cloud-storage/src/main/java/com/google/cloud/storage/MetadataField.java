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

import com.google.cloud.storage.Conversions.Codec;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Utility construct which allows defining a field name along with a codec for use in creating
 * typeful files in {@link BlobInfo#getMetadata()} or {@link BucketInfo#getLabels()}
 *
 * @param <T> The type of the value
 */
@SuppressWarnings("SameParameterValue")
final class MetadataField<T> {

  @SuppressWarnings("RedundantTypeArguments")
  private static final Codec<Long, String> CODEC_LONG =
      Codec.<Long, String>of(String::valueOf, Long::parseLong).nullable();

  private static final Codec<String, String> CODEC_STRING =
      Codec.<String, String>of(s -> s, s -> s).nullable();
  private final String key;
  private final Codec<T, String> codec;

  private MetadataField(String key, Codec<T, String> codec) {
    this.key = key;
    this.codec = codec;
  }

  void appendTo(@NonNull T t, ImmutableMap.Builder<String, String> b) {
    b.put(key, codec.encode(t));
  }

  @Nullable T readFrom(BlobInfo info) {
    Map<String, String> map = info.getMetadata();
    if (map != null) {
      return readFrom(map);
    }
    return null;
  }

  @VisibleForTesting
  @Nullable T readFrom(Map<String, String> m) {
    return codec.decode(m.get(key));
  }

  static MetadataField<Long> forLong(String key) {
    return of(key, CODEC_LONG);
  }

  static MetadataField<String> forString(String key) {
    return of(key, CODEC_STRING);
  }

  static MetadataField<PartRange> forPartRange(String key) {
    return of(key, PartRange.CODEC);
  }

  static final class PartRange {
    private static final Codec<PartRange, String> CODEC =
        Codec.of(PartRange::encode, PartRange::decode).nullable();
    static final Comparator<PartRange> COMP =
        Comparator.comparingLong(PartRange::getBegin).thenComparingLong(PartRange::getEnd);
    private final long begin;
    private final long end;

    private PartRange(long begin, long end) {
      this.begin = begin;
      this.end = end;
    }

    public long getBegin() {
      return begin;
    }

    public long getEnd() {
      return end;
    }

    String encode() {
      return String.format(Locale.US, "%04d-%04d", begin, end);
    }

    static PartRange decode(String s) {
      int splitPoint = s.indexOf("-");
      long being = Long.parseLong(s.substring(0, splitPoint));
      long end = Long.parseLong(s.substring(splitPoint + 1));
      return of(being, end);
    }

    static PartRange of(long begin) {
      return of(begin, begin);
    }

    static PartRange of(long begin, long end) {
      return new PartRange(begin, end);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof PartRange)) {
        return false;
      }
      PartRange partRange = (PartRange) o;
      return begin == partRange.begin && end == partRange.end;
    }

    @Override
    public int hashCode() {
      return Objects.hash(begin, end);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("begin", begin).add("end", end).toString();
    }
  }

  private static <T> MetadataField<T> of(String key, Codec<T, String> codec) {
    return new MetadataField<>(key, codec);
  }
}
