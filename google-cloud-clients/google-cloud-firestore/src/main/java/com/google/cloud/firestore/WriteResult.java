/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.firestore;

import com.google.cloud.Timestamp;
import java.util.Objects;
import javax.annotation.Nonnull;

/** A WriteResult exposes the update time set by the server. */
public final class WriteResult {

  private final Timestamp updateTime;

  private WriteResult(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * The update time as exposed by the server. Can be used in {@link Precondition#updatedAt}.
   *
   * @return The update time of the corresponding write.
   */
  @Nonnull
  public Timestamp getUpdateTime() {
    return this.updateTime;
  }

  static WriteResult fromProto(
      com.google.firestore.v1beta1.WriteResult writeResult,
      com.google.protobuf.Timestamp commitTime) {
    Timestamp timestamp =
        Timestamp.fromProto(writeResult.hasUpdateTime() ? writeResult.getUpdateTime() : commitTime);
    return new WriteResult(timestamp);
  }

  /**
   * Returns true if this WriteResult is equal to the provided object.
   *
   * @param obj The object to compare against.
   * @return Whether this WriteResult is equal to the provided object.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    WriteResult that = (WriteResult) obj;
    return Objects.equals(updateTime, that.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updateTime);
  }
}
