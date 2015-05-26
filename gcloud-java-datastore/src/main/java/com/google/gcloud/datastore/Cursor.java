/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.DatastoreV1.Value;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat.ParseException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * A Google Cloud Datastore cursor.
 * The cursor can be used to as a starting point or an ending point for a {@link Query}
 */
public final class Cursor extends Serializable<DatastoreV1.Value> {

  private static final long serialVersionUID = -1423744878777486541L;

  private final transient ByteString byteString;

  Cursor(ByteString byteString) {
    Preconditions.checkArgument(byteString.isValidUtf8(), "content is not a valid UTF-8");
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

  ByteString byteString() {
    return byteString;
  }

  /**
   * Returns the cursor in an encoded form that can be used as part of a URL.
   */
  public String toUrlSafe() {
    try {
      return URLEncoder.encode(TextFormat.printToString(toPb()), UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException("Unexpected encoding exception", e);
    }
  }

  /**
   * Create a {@code Cursor} given its URL safe encoded form.
   */
  public static Cursor fromUrlSafe(String urlSafe) {
    try {
      String utf8Str = URLDecoder.decode(urlSafe, UTF_8.name());
      DatastoreV1.Value.Builder builder = DatastoreV1.Value.newBuilder();
      TextFormat.merge(utf8Str, builder);
      return fromPb(builder.build());
    } catch (UnsupportedEncodingException | ParseException e) {
      throw new IllegalStateException("Unexpected decoding exception", e);
    }
  }

  public static Cursor copyFrom(byte[] bytes) {
    return new Cursor(ByteString.copyFrom(checkNotNull(bytes)));
  }

  @Override
  protected Value toPb() {
    return DatastoreV1.Value.newBuilder().setBlobValue(byteString).build();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Value.parseFrom(bytesPb));
  }

  static Cursor fromPb(DatastoreV1.Value valuePb) {
    return new Cursor(valuePb.getBlobValue());
  }
}
