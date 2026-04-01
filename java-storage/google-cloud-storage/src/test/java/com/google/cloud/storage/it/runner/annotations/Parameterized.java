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

package com.google.cloud.storage.it.runner.annotations;

import com.google.common.collect.ImmutableList;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to signify a test should be ran in a parameterized fashion. The specified {@link
 * ParametersProvider} is able to define {@code @}{@link Inject}able fields which can be used when
 * {@link ParametersProvider#parameters()} is invoked.
 *
 * <p>The defined class of {@link ParametersProvider} must a public no-args constructor which will
 * be used to create a new instance.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Parameterized {

  Class<? extends ParametersProvider> value();

  @Target(ElementType.FIELD)
  @Retention(RetentionPolicy.RUNTIME)
  @interface Parameter {}

  interface ParametersProvider {
    ImmutableList<?> parameters();
  }
}
