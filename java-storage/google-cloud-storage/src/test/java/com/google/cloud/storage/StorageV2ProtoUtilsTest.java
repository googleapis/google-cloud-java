/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.storage.ByteRangeSpec.relativeLength;
import static com.google.cloud.storage.StorageV2ProtoUtils.fmtProto;
import static com.google.cloud.storage.StorageV2ProtoUtils.seekReadObjectRequest;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.jqwik.StorageArbitraries;
import com.google.storage.v2.ObjectAccessControl;
import com.google.storage.v2.ReadObjectRequest;
import java.util.function.Predicate;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

public final class StorageV2ProtoUtilsTest {

  @Example
  void objectAclEntityIdOrAltEq() {
    String entity = "project-viewer-123123";
    Predicate<ObjectAccessControl> p = StorageV2ProtoUtils.objectAclEntityOrAltEq(entity);

    ObjectAccessControl inAlt =
        ObjectAccessControl.newBuilder().setEntity("something").setEntityAlt(entity).build();
    ObjectAccessControl inPrimary =
        ObjectAccessControl.newBuilder().setEntity(entity).setEntityAlt("something-else").build();

    assertThat(p.test(inAlt)).isTrue();
    assertThat(p.test(inPrimary)).isTrue();
  }

  @Property(tries = 100_000)
  void seek(@ForAll("seekCases") SeekCase srr) {
    Long offset = srr.offset;
    Long limit = srr.limit;
    ReadObjectRequest seek = seekReadObjectRequest(srr.req, relativeLength(offset, limit));

    // If both offset and limit are null, avoid allocating a new instance as we don't have any
    // meaningful change to apply
    if (offset == null && limit == null) {
      assertThat(seek).isSameInstanceAs(srr.req);
    } else {
      if (offset != null && offset != 0) {
        assertThat(seek.getReadOffset()).isEqualTo(offset);
      }
      if (limit != null && limit != Long.MAX_VALUE) {
        assertThat(seek.getReadLimit()).isEqualTo(limit);
      }
    }
  }

  @Provide("seekCases")
  Arbitrary<SeekCase> arbitrarySeekCase() {
    return Combinators.combine(
            StorageArbitraries.objects().name(),
            Arbitraries.longs().greaterOrEqual(0).injectNull(0.6),
            Arbitraries.longs().greaterOrEqual(0).injectNull(0.6),
            Arbitraries.longs().greaterOrEqual(0).injectNull(0.3),
            Arbitraries.longs().greaterOrEqual(0).injectNull(0.3))
        .as(SeekCase::of);
  }

  private static final class SeekCase {
    private final ReadObjectRequest req;
    private final Long offset;
    private final Long limit;

    public SeekCase(ReadObjectRequest req, Long offset, Long limit) {
      this.req = req;
      this.offset = offset;
      this.limit = limit;
    }

    @Override
    public String toString() {
      return "SeekCase{" + "req=" + fmtProto(req) + ", offset=" + offset + ", limit=" + limit + '}';
    }

    private static SeekCase of(
        String name, Long embedOffset, Long embedLimit, Long offset, Long limit) {
      ReadObjectRequest.Builder b = ReadObjectRequest.newBuilder().setObject(name);
      if (embedOffset != null) {
        b.setReadOffset(embedOffset);
      }
      if (embedLimit != null) {
        b.setReadLimit(embedLimit);
      }
      return new SeekCase(b.build(), offset, limit);
    }
  }
}
