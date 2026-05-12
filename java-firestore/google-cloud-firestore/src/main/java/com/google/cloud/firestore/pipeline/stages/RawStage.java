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

package com.google.cloud.firestore.pipeline.stages;

import com.google.api.core.InternalApi;
import com.google.cloud.firestore.PipelineUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.firestore.v1.Value;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Adds a stage to the pipeline by specifying the stage name as an argument. This does not offer any
 * type safety on the stage params and requires the caller to know the order (and optionally names)
 * of parameters accepted by the stage.
 *
 * <p>This class provides a way to call stages that are supported by the Firestore backend but that
 * are not implemented in the SDK version being used.
 */
public final class RawStage extends Stage {

  private final List<Object> arguments;

  private RawStage(
      @Nonnull String name, @Nonnull List<Object> arguments, @Nonnull RawOptions options) {
    super(name, options.options);
    this.arguments = arguments;
  }

  /**
   * Specify name of stage
   *
   * @param name The unique name of the stage to add.
   * @return A new {@code RawStage} for the specified stage name.
   */
  @Nonnull
  public static RawStage ofName(@Nonnull String name) {
    return new RawStage(name, ImmutableList.of(), new RawOptions());
  }

  /**
   * Specify arguments to stage.
   *
   * @param arguments A list of ordered parameters to configure the stage's behavior.
   * @return {@code RawStage} with specified parameters.
   */
  @Nonnull
  public RawStage withArguments(@Nonnull Object... arguments) {
    return new RawStage(name, Arrays.asList(arguments), new RawOptions(options));
  }

  @Nonnull
  public RawStage withOptions(@Nonnull RawOptions options) {
    return new RawStage(name, arguments, options);
  }

  @Override
  @InternalApi
  Iterable<Value> toStageArgs() {
    return Iterables.transform(arguments, PipelineUtils::encodeValue);
  }
}
