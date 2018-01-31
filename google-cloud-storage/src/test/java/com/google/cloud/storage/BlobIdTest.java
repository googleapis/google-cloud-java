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

package com.google.cloud.storage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BlobIdTest {

  private static final BlobId BLOB = BlobId.of("b", "n");

  @Test
  public void testOf() {
    BlobId blobId = BlobId.of("b", "n");
    assertEquals("b", blobId.getBucket());
    assertEquals("n", blobId.getName());
  }

  @Test
  public void testEquals() {
    compareBlobIds(BLOB, BlobId.of("b", "n"));
  }

  private void compareBlobIds(BlobId expected, BlobId value) {
    assertEquals(expected, value);
    assertEquals(expected.getBucket(), value.getBucket());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.hashCode(), value.hashCode());
  }

  @Test
  public void testToPbAndFromPb() {
    compareBlobIds(BLOB, BlobId.fromPb(BLOB.toPb()));
  }
}
