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

package com.google.cloud.firestore;

import com.google.api.core.BetaApi;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import javax.annotation.Nonnull;

/**
 * A wrapper object to access explain stats if explain or analyze was enabled for the Pipeline query
 * execution.
 */
@BetaApi
public final class ExplainStats {

  private final Any explainStatsData;

  /**
   * @hideconstructor
   * @param explainStatsData The raw proto message of the explain stats.
   */
  ExplainStats(@Nonnull Any explainStatsData) {
    this.explainStatsData = explainStatsData;
  }

  /**
   * Returns the explain stats in an encoded proto format, as returned from the Firestore backend.
   * The caller is responsible for unpacking this proto message.
   */
  @Nonnull
  public Any getRawData() {
    return explainStatsData;
  }

  private StringValue decode() {
    try {
      return explainStatsData.unpack(StringValue.class);
    } catch (InvalidProtocolBufferException e) {
      throw new RuntimeException(
          "Unable to decode explain stats. Did you request an output format that returns a string"
              + " value, such as 'text' or 'json'?",
          e);
    }
  }

  /**
   * When explain stats were requested with `outputFormat = 'text'`, this returns the explain stats
   * string verbatim as returned from the Firestore backend.
   *
   * <p>If explain stats were requested with `outputFormat = 'json'`, this returns the explain stats
   * as stringified JSON, which was returned from the Firestore backend.
   */
  @Nonnull
  public String getText() {
    return decode().getValue();
  }
}
