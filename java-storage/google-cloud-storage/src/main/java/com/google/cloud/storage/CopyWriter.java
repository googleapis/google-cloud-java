/*
 * Copyright 2022 Google LLC
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

import com.google.cloud.Restorable;
import com.google.cloud.RestorableState;

/**
 * Google Storage blob copy writer. A {@code CopyWriter} object allows to copy both blob's data and
 * information. To override source blob's information supply a {@code BlobInfo} to the {@code
 * CopyRequest} using either {@link Storage.CopyRequest.Builder#setTarget(BlobInfo,
 * Storage.BlobTargetOption...)} or {@link Storage.CopyRequest.Builder#setTarget(BlobInfo,
 * Iterable)}.
 *
 * <p>This class holds the result of a copy request. If source and destination blobs share the same
 * location and storage class the copy is completed in one RPC call otherwise one or more {@link
 * #copyChunk} calls are necessary to complete the copy. In addition, {@link CopyWriter#getResult()}
 * can be used to automatically complete the copy and return information on the newly created blob.
 *
 * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/objects/rewrite">Rewrite</a>
 */
public abstract class CopyWriter implements Restorable<CopyWriter> {

  // keep this class only extendable within our package
  CopyWriter() {}

  /**
   * Returns the updated information for the written blob. Calling this method when {@code isDone()}
   * is {@code false} will block until all pending chunks are copied.
   *
   * <p>This method has the same effect of doing:
   *
   * <pre>{@code
   * while (!copyWriter.isDone()) {
   *    copyWriter.copyChunk();
   * }
   * }</pre>
   *
   * @throws StorageException upon failure
   */
  public abstract Blob getResult();

  /** Returns the size of the blob being copied. */
  public abstract long getBlobSize();

  /** Returns {@code true} if blob copy has finished, {@code false} otherwise. */
  public abstract boolean isDone();

  /** Returns the number of bytes copied. */
  public abstract long getTotalBytesCopied();

  /**
   * Copies the next chunk of the blob. An RPC is issued only if copy has not finished yet ({@link
   * #isDone} returns {@code false}).
   *
   * @throws StorageException upon failure
   */
  public abstract void copyChunk();

  @Override
  public abstract RestorableState<CopyWriter> capture();
}
