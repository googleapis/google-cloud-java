/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PartitionIdTest {
  private static class TestObject implements Serializable {
    private final String id;

    TestObject(String id) {
      this.id = id;
    }

    public String getId() {
      return id;
    }
  }

  @Test
  public void testDeserializeInvalid() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (ObjectOutputStream objectOutputStream =
        new ObjectOutputStream(new GZIPOutputStream(byteArrayOutputStream))) {
      objectOutputStream.writeObject(new TestObject("foo"));
    }
    String base64 = Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());

    SpannerException exception =
        assertThrows(SpannerException.class, () -> PartitionId.decodeFromString(base64));
    assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
    assertEquals(
        ErrorCode.INVALID_ARGUMENT
            + ": The id does not contain a valid PartitionId instance; "
            + "com.google.cloud.spanner.connection.PartitionIdTest$TestObject",
        exception.getMessage());
  }
}
