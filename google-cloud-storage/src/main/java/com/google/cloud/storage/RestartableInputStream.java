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

package com.google.cloud.storage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
public class RestartableInputStream {

    InputStream inputStream;

    public RestartableInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        this.inputStream.mark(Integer.MAX_VALUE);
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public void restart() {
        try {
            this.inputStream.reset();
            this.inputStream.mark(Integer.MAX_VALUE);
        }
        catch (IOException e) {
            throw new IOExpection();
        }
    }
}