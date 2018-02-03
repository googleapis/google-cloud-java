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
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import com.google.protobuf.ByteString.Output;
import java.io.IOException;
import java.io.OutputStream;

@InternalApi
public final class RegexUtil {
  private static final byte[] NULL_BYTES = "\\x00".getBytes();

  private RegexUtil() {}

  public static String literalRegex(final String value) {
    return literalRegex(ByteString.copyFromUtf8(value)).toStringUtf8();
  }
  /** Converts the value to a quoted regular expression. */
  public static ByteString literalRegex(ByteString value) {
    Output output = ByteString.newOutput(value.size() * 2);

    ByteIterator it = value.iterator();
    try {
      writeLiteralRegex(it, output);
    } catch (IOException e) {
      throw new RuntimeException("Unexpected io error converting regex", e);
    }

    return output.toByteString();
  }

  // Extracted from: re2 QuoteMeta:
  // https://github.com/google/re2/blob/70f66454c255080a54a8da806c52d1f618707f8a/re2/re2.cc#L456
  private static void writeLiteralRegex(ByteIterator input, OutputStream output)
      throws IOException {
    while (input.hasNext()) {
      byte unquoted = input.nextByte();

      if ((unquoted < 'a' || unquoted > 'z')
          && (unquoted < 'A' || unquoted > 'Z')
          && (unquoted < '0' || unquoted > '9')
          && unquoted != '_'
          &&
          // If this is the part of a UTF8 or Latin1 character, we need
          // to copy this byte without escaping.  Experimentally this is
          // what works correctly with the regexp library.
          (unquoted & 128) == 0) {

        if (unquoted == '\0') { // Special handling for null chars.
          // Note that this special handling is not strictly required for RE2,
          // but this quoting is required for other regexp libraries such as
          // PCRE.
          // Can't use "\\0" since the next character might be a digit.
          output.write(NULL_BYTES, 0, NULL_BYTES.length);
          continue;
        }

        output.write('\\');
      }
      output.write(unquoted);
    }
  }
}
