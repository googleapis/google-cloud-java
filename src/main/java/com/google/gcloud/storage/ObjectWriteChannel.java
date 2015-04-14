/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import java.io.Closeable;
import java.io.Serializable;
import java.nio.channels.WritableByteChannel;

/**
 * A channel for writing data to a Google Cloud Storage object.
 *
 * Implementations of this class may further buffer data internally to reduce remote calls.
 * Written data will only be visible after calling {@link #close()}.
 * This class is serializable, to allow incremental writes.
 */
public interface ObjectWriteChannel extends WritableByteChannel, Serializable, Closeable {

}
