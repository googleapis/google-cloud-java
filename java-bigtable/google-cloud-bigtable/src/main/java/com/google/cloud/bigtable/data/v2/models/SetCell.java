/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.models;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.cloud.bigtable.data.v2.stub.changestream.ChangeStreamRecordMerger;
import com.google.protobuf.ByteString;
import java.io.Serializable;
import javax.annotation.Nonnull;

/**
 * Representation of a SetCell mod in a data change, whose value is concatenated by {@link
 * ChangeStreamRecordMerger} in case of SetCell value chunking.
 */
@InternalApi("Intended for use by the BigtableIO in apache/beam only.")
@AutoValue
public abstract class SetCell implements Entry, Serializable {
  private static final long serialVersionUID = 77123872266724154L;

  public static SetCell create(
      @Nonnull String familyName,
      @Nonnull ByteString qualifier,
      long timestamp,
      @Nonnull ByteString value) {
    return new AutoValue_SetCell(familyName, qualifier, timestamp, value);
  }

  /** Get the column family of the current SetCell. */
  @Nonnull
  public abstract String getFamilyName();

  /** Get the column qualifier of the current SetCell. */
  @Nonnull
  public abstract ByteString getQualifier();

  /** Get the timestamp of the current SetCell. */
  public abstract long getTimestamp();

  /** Get the value of the current SetCell. */
  @Nonnull
  public abstract ByteString getValue();
}
