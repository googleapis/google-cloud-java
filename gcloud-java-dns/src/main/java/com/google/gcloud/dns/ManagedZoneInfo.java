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
package com.google.gcloud.dns;

/**
 * TODO: Implement.
 * TODO: Add documentation.
 */
public class ManagedZoneInfo {

  private final String name;
  private final Long id;

  public String name() {
    throw new UnsupportedOperationException("Not implemented yet.");
    // TODO: Implement
  }

  public Long id() {
    return id;
    // TODO: Implement
  }

  private ManagedZoneInfo() {
    name = null;
    id = null;
    throw new UnsupportedOperationException("Not implemented yet");
    // TODO: Implement
  }

}
