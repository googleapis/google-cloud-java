/*
 * Copyright 2021 Google LLC
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
package com.google.api.generator.gapic.composer.rest;

import com.google.api.generator.gapic.composer.common.AbstractServiceClientClassComposer;

public class ServiceClientClassComposer extends AbstractServiceClientClassComposer {
  private static final ServiceClientClassComposer INSTANCE = new ServiceClientClassComposer();

  protected ServiceClientClassComposer() {
    super(RestContext.instance());
  }

  public static ServiceClientClassComposer instance() {
    return INSTANCE;
  }
}
