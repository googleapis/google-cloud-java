/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

/**
 * Annotation for JUnit {@link org.junit.experimental.categories.Category} that indicates a test is
 * flaky. These will be excluded from integration tests. Use this annotation sparingly: typically it
 * should only be used for a test where the flakiness is dependent on a fix in a module dependency
 * (for example, grpc-java) and cannot be addressed locally.
 */
public interface FlakyTest {}
