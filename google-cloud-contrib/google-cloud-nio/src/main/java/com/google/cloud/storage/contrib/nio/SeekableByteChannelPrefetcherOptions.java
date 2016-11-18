/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.storage.contrib.nio;

/**
 * Options for the SeekableByteChannelPrefetcher. Mutating them after creating
 * the SeekableByteChannelPrefetcher has no effect.
 */
public class SeekableByteChannelPrefetcherOptions implements java.nio.file.OpenOption {
  // normal-case number of parallel reads.
  public int prefetchingThreads = 4;
  // in case the data we need isn't being prefetched, we can use up to this many
  // extra threads to fetch user-requested data.
  public int extraThreads = 1;
  // size in bytes for our buffer. Every fetcher grabs one buffer at a time.
  public int bufferSize = 50 * 1024 * 1024;
  // how many buffers we keep around. Should be at least prefetchingThreads + extraThreads.
  // bufferSize * bufferCount is how much memory this class'll allocate.
  public int bufferCount = 6;
}
