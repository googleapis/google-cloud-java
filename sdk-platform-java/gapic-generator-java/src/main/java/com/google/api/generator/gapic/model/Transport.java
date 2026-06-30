// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.model;

public enum Transport {
  REST,
  GRPC,
  GRPC_REST;

  /**
   * Parse the input and return the corresponding Transport enum
   *
   * @param name Transport name
   * @return the {@code Transport} enum matching the name parameter
   */
  public static Transport parse(String name) {
    return valueOf(name.toLowerCase().replace('+', '_').toUpperCase());
  }
}
