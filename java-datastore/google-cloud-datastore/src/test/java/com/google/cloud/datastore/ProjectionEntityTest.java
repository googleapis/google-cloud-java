/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;







import com.google.cloud.Timestamp;
import org.junit.jupiter.api.Test;

class ProjectionEntityTest {

  private static final Key KEY = Key.newBuilder("ds1", "k1", "n1").build();
  private static final StringValue STRING_INDEX_VALUE =
      StringValue.newBuilder("foo").setMeaning(18).build();
  private static final BlobValue BLOB_VALUE = BlobValue.of(Blob.copyFrom(new byte[] {1}));
  private static final TimestampValue TIMESTAMP_VALUE = TimestampValue.of(Timestamp.now());
  private static final LongValue LONG_INDEX_VALUE =
      LongValue.newBuilder(
              TIMESTAMP_VALUE.get().getSeconds() * 1000000
                  + TIMESTAMP_VALUE.get().getNanos() / 1000)
          .setMeaning(18)
          .build();
  private static final ProjectionEntity ENTITY1 =
      new ProjectionEntity.Builder().setKey(KEY).set("a", "b").build();
  private static final ProjectionEntity ENTITY2 =
      new ProjectionEntity.Builder()
          .set("a", STRING_INDEX_VALUE)
          .set("b", BLOB_VALUE)
          .set("c", TIMESTAMP_VALUE)
          .set("d", LONG_INDEX_VALUE)
          .build();

  @Test
  void testHasKey() {
    assertTrue(ENTITY1.hasKey());
    assertFalse(ENTITY2.hasKey());
  }

  @Test
  void testKey() {
    assertEquals(KEY, ENTITY1.getKey());
    assertNull(ENTITY2.getKey());
  }

  @Test
  void testGetBlob() {
    assertArrayEquals(STRING_INDEX_VALUE.get().getBytes(), ENTITY2.getBlob("a").toByteArray());
    assertEquals(BLOB_VALUE.get(), ENTITY2.getBlob("b"));
  }

  @Test
  void testGetTimestamp() {
    assertEquals(TIMESTAMP_VALUE.get(), ENTITY2.getTimestamp("c"));
    assertEquals(TIMESTAMP_VALUE.get(), ENTITY2.getTimestamp("d"));
  }
}
