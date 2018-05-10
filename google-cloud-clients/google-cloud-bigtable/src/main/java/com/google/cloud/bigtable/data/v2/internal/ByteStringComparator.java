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
import java.util.Comparator;

/** Compares {@link ByteString}s as unsigned byte arrays. */
@InternalApi
public class ByteStringComparator implements Comparator<ByteString> {
  public static final ByteStringComparator INSTANCE = new ByteStringComparator();

  @Override
  public int compare(ByteString o1, ByteString o2) {
    int sizeA = o1.size();
    int sizeB = o2.size();
    int shortestSize = Math.min(sizeA, sizeB);
    for (int i = 0; i < shortestSize; i++) {
      int byteA = o1.byteAt(i) & 0xff;
      int byteB = o2.byteAt(i) & 0xff;

      if (byteA != byteB) {
        return byteA < byteB ? -1 : 1;
      }
    }
    if (sizeA == sizeB) {
      return 0;
    }
    return sizeA < sizeB ? -1 : 1;
  }
}
