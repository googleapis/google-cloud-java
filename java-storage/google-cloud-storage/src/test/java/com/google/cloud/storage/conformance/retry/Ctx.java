/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.storage.conformance.retry;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.conformance.retry.Functions.EConsumer;
import com.google.cloud.storage.conformance.retry.Functions.EFunction;
import com.google.errorprone.annotations.Immutable;

/**
 * A simple context object used to track an instance of {@link Storage} along with {@link State} and
 * provide some convenience methods for creating new instances.
 */
@Immutable
final class Ctx {

  private final Storage storage;
  private final State state;

  private Ctx(Storage s, State t) {
    this.storage = s;
    this.state = t;
  }

  /** Create a new instance of {@link Ctx} */
  static Ctx ctx(Storage storage, State state) {
    return new Ctx(storage, state);
  }

  public Storage getStorage() {
    return storage;
  }

  public State getState() {
    return state;
  }

  /**
   * Create a new instance of {@link Ctx} by first applying {@code f} to {@code this.storage}.
   * {@code this.state} is passed along unchanged.
   */
  public Ctx leftMap(EFunction<Storage, Storage> f) throws Throwable {
    return new Ctx(f.apply(storage), state);
  }

  /**
   * Create a new instance of {@link Ctx} by first applying {@code f} to {@code this.state}. {@code
   * this.storage} is passed along unchanged.
   */
  public Ctx map(EFunction<State, State> f) throws Throwable {
    return new Ctx(storage, f.apply(state));
  }

  /**
   * Apply {@code f} by providing {@code this.state}.
   *
   * <p>This method is provided as convenience for those methods which have void return. In general
   * {@link Ctx#map(EFunction)} should be used.
   */
  public Ctx peek(EConsumer<State> f) throws Throwable {
    f.consume(state);
    return this;
  }
}
