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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.ByteString;
import java.io.Serializable;

/**
 * A Google Cloud Datastore cursor. The cursor can be used to as a starting point or an ending point
 * for a {@link Query}
 */
public final class Cursor implements Serializable {

  private static final long serialVersionUID = 4688656124180503551L;

  private final ByteString byteString;

  Cursor(ByteString byteString) {
    this.byteString = byteString;
  }

  @Override
  public int hashCode() {
    return byteString.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj instanceof Cursor && byteString.equals(((Cursor) obj).byteString);
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    StringBuilder stBuilder = new StringBuilder();
    for (int i = 0; i < byteString.size(); i++) {
      stBuilder.append(String.format("%02x", byteString.byteAt(i)));
    }
    return toStringHelper.add("bytes", stBuilder.toString()).toString();
  }

  ByteString getByteString() {
    return byteString;
  }

  /** Returns the cursor in an encoded form that can be used as part of a URL. */
  public String toUrlSafe() {
    return BaseEncoding.base64Url().encode(byteString.toByteArray());
  }

  /** Create a {@code Cursor} given its URL safe encoded form. */
  public static Cursor fromUrlSafe(String urlSafe) {
    try {
      return Cursor.copyFrom(BaseEncoding.base64Url().decode(urlSafe));
    } catch (IllegalArgumentException e) {
      throw new IllegalStateException("Unexpected decoding exception", e);
    }
  }

  public static Cursor copyFrom(byte[] bytes) {
    return new Cursor(ByteString.copyFrom(checkNotNull(bytes)));
  }

  com.google.datastore.v1.Value toPb() {
    return com.google.datastore.v1.Value.newBuilder().setBlobValue(byteString).build();
  }
}
