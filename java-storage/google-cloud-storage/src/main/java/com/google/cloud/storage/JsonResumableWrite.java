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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.lock.qual.GuardedBy;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;

final class JsonResumableWrite implements Serializable {
  private static final long serialVersionUID = 7934407897802252292L;
  private static final Gson gson = new Gson();

  @MonotonicNonNull private transient StorageObject object;
  @MonotonicNonNull private transient Hasher hasher;
  @MonotonicNonNull private transient Crc32cValue<?> cumulativeCrc32c;
  @MonotonicNonNull private final Map<StorageRpc.Option, ?> options;

  @MonotonicNonNull private final String signedUrl;

  @NonNull private final String uploadId;
  private final long beginOffset;

  private volatile String objectJson;

  @GuardedBy("objectJson")
  private String base64CumulativeCrc32c;

  private JsonResumableWrite(
      StorageObject object,
      @MonotonicNonNull Hasher hasher,
      @MonotonicNonNull Crc32cValue<?> cumulativeCrc32c,
      Map<StorageRpc.Option, ?> options,
      String signedUrl,
      @NonNull String uploadId,
      long beginOffset) {
    this.object = object;
    this.hasher = hasher;
    this.cumulativeCrc32c = cumulativeCrc32c;
    this.options = options;
    this.signedUrl = signedUrl;
    this.uploadId = uploadId;
    this.beginOffset = beginOffset;
  }

  ImmutableMap<String, String> getExtraHeaders() {
    if (options != null) {
      Object tmp = options.get(StorageRpc.Option.EXTRA_HEADERS);
      if (tmp != null) {
        return (ImmutableMap<String, String>) tmp;
      }
    }
    return ImmutableMap.of();
  }

  public @NonNull String getUploadId() {
    return uploadId;
  }

  public long getBeginOffset() {
    return beginOffset;
  }

  public JsonResumableWrite withBeginOffset(long newBeginOffset) {
    checkArgument(
        newBeginOffset >= beginOffset,
        "New beginOffset must be >= existing beginOffset (%s >= %s)",
        newBeginOffset,
        beginOffset);
    return new JsonResumableWrite(
        object, hasher, cumulativeCrc32c, options, signedUrl, uploadId, newBeginOffset);
  }

  public @MonotonicNonNull Hasher getHasher() {
    return hasher;
  }

  public @MonotonicNonNull Crc32cValue<?> getCumulativeCrc32c() {
    return cumulativeCrc32c;
  }

  public void setCumulativeCrc32c(Crc32cValue<?> cumulativeCrc32c) {
    this.cumulativeCrc32c = cumulativeCrc32c;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof JsonResumableWrite)) {
      return false;
    }
    JsonResumableWrite that = (JsonResumableWrite) o;
    return beginOffset == that.beginOffset
        && Objects.equals(object, that.object)
        && Objects.equals(hasher, that.hasher)
        && cumulativeCrc32c.eqValue(that.cumulativeCrc32c)
        && Objects.equals(options, that.options)
        && Objects.equals(signedUrl, that.signedUrl)
        && Objects.equals(uploadId, that.uploadId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        object, hasher, cumulativeCrc32c.getValue(), options, signedUrl, uploadId, beginOffset);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("object", object)
        .add("hasher", hasher)
        .add("cumulativeCrc32c", cumulativeCrc32c)
        .add("options", options)
        .add("signedUrl", signedUrl)
        .add("uploadId", uploadId)
        .add("beginOffset", beginOffset)
        .toString();
  }

  private String getObjectJson() {
    if (objectJson == null) {
      synchronized (this) {
        if (objectJson == null) {
          objectJson = gson.toJson(object);
          base64CumulativeCrc32c = Utils.crc32cCodec.encode(cumulativeCrc32c.getValue());
        }
      }
    }
    return objectJson;
  }

  private void writeObject(ObjectOutputStream out) throws IOException {
    String ignore = getObjectJson();
    out.defaultWriteObject();
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    JsonReader jsonReader = gson.newJsonReader(new StringReader(this.objectJson));
    this.object = gson.fromJson(jsonReader, StorageObject.class);
    if (base64CumulativeCrc32c != null) {
      Integer decode = Utils.crc32cCodec.decode(base64CumulativeCrc32c);
      if (decode == 0) {
        this.cumulativeCrc32c = Crc32cValue.zero();
      } else {
        this.cumulativeCrc32c = Crc32cValue.of(decode);
      }
      this.hasher = Hasher.enabled();
    }
  }

  static JsonResumableWrite of(
      StorageObject req, Map<StorageRpc.Option, ?> options, String uploadId, long beginOffset) {
    return of(req, options, uploadId, beginOffset, Hasher.noop(), null);
  }

  static JsonResumableWrite of(
      StorageObject req,
      Map<StorageRpc.Option, ?> options,
      String uploadId,
      long beginOffset,
      Hasher hasher,
      Crc32cValue<?> initialValue) {
    return new JsonResumableWrite(req, hasher, initialValue, options, null, uploadId, beginOffset);
  }

  static JsonResumableWrite of(String signedUrl, String uploadId, long beginOffset) {
    Hasher hasher = Hasher.noop();
    if (beginOffset == 0) {
      hasher = Hasher.defaultHasher();
    }
    return new JsonResumableWrite(
        null, hasher, hasher.initialValue(), null, signedUrl, uploadId, beginOffset);
  }
}
