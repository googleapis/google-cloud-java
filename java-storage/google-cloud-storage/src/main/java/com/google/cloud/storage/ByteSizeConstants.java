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

final class ByteSizeConstants {

  static final int _1KiB = 1024;
  static final int _128KiB = 128 * _1KiB;
  static final int _256KiB = 256 * _1KiB;
  static final int _384KiB = 384 * _1KiB;
  static final int _512KiB = 512 * _1KiB;
  static final int _768KiB = 768 * _1KiB;
  static final int _1MiB = 1024 * _1KiB;
  static final int _2MiB = 2 * _1MiB;
  static final int _4MiB = 4 * _1MiB;
  static final int _16MiB = 16 * _1MiB;
  static final int _32MiB = 32 * _1MiB;
  static final long _1GiB = 1024 * _1MiB;
  static final long _1TiB = 1024 * _1GiB;
  static final long _5TiB = 5 * _1TiB;

  static final long _128KiBL = 131072L;
  static final long _256KiBL = 262144L;
  static final long _512KiBL = 524288L;
  static final long _768KiBL = 786432L;
  static final long _1MiBL = 1048576L;

  private ByteSizeConstants() {}
}
