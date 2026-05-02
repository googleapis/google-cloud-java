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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;




import com.google.protobuf.ByteString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursorTest {

  private static final byte[] bytes1 = {1, 2, 3, '%', '<', '+'};
  private static final byte[] bytes2 = {10, 20, 30};
  private Cursor cursor1;
  private Cursor cursor2;

  @BeforeEach
  void setUp() {
    cursor1 = new Cursor(ByteString.copyFrom(bytes1));
    cursor2 = new Cursor(ByteString.copyFrom(bytes2));
  }

  @Test
  void testToFromUrlSafe() {
    String urlSafe = cursor1.toUrlSafe();
    assertEquals(cursor1, Cursor.fromUrlSafe(urlSafe));
  }

  @Test
  void testCopyFrom() {
    Cursor cursor = Cursor.copyFrom(bytes2);
    assertEquals(cursor2, cursor);
    assertNotEquals(cursor1, cursor);
  }
}
