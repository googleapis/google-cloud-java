/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.dlp.v2beta1;

import com.google.privacy.dlp.v2beta1.Color;

public class Colors {

  private Colors() {}

  public static final Color asDlpColor(java.awt.Color c) {
    return Color.newBuilder()
        .setBlue(c.getBlue())
        .setGreen(c.getGreen())
        .setRed(c.getRed())
        .build();
  }

  public static final java.awt.Color asAwtColor(Color c) {
    return new java.awt.Color(c.getRed() / 255, c.getGreen() / 255, c.getBlue() / 255);
  }
}
