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

import com.google.api.core.InternalExtensionOnly;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;

/**
 * The data of a single {@code UploadPart} in a GCS XML MPU.
 *
 * <p>Instances of this class are thread-safe and immutable.
 *
 * @see <a
 *     href="https://cloud.google.com/storage/docs/multipart-uploads#upload_parts">https://cloud.google.com/storage/docs/multipart-uploads#upload_parts</a>
 */
@InternalExtensionOnly
public final class RequestBody {

  private final RewindableContent content;

  private RequestBody(RewindableContent content) {
    this.content = content;
  }

  RewindableContent getContent() {
    return content;
  }

  /** Create a new empty RequestBody. */
  public static RequestBody empty() {
    return new RequestBody(RewindableContent.empty());
  }

  /** Create a new RequestBody from the given {@link ByteBuffer}s. */
  public static RequestBody of(ByteBuffer... buffers) {
    return new RequestBody(RewindableContent.of(buffers));
  }

  /** Create a new RequestBody from the given {@link ByteBuffer}s. */
  public static RequestBody of(ByteBuffer[] srcs, int srcsOffset, int srcsLength) {
    return new RequestBody(RewindableContent.of(srcs, srcsOffset, srcsLength));
  }

  /** Create a new RequestBody from the given {@link Path}. */
  public static RequestBody of(Path path) throws IOException {
    return new RequestBody(RewindableContent.of(path));
  }
}
