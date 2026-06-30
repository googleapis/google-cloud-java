/*
 * Copyright 2022 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.nativeimage;

import static com.google.api.gax.nativeimage.NativeImageUtils.registerForReflectiveInstantiation;

import org.graalvm.nativeimage.hosted.Feature;

/** Registers reflection usage in OpenCensus libraries. */
final class OpenCensusFeature implements Feature {

  private static final String TAGS_COMPONENT_CLASS = "io.opencensus.impl.tags.TagsComponentImpl";
  private static final String STATS_COMPONENT_CLASS = "io.opencensus.impl.stats.StatsComponentImpl";

  @Override
  public void beforeAnalysis(BeforeAnalysisAccess access) {
    if (access.findClassByName(STATS_COMPONENT_CLASS) != null) {
      registerForReflectiveInstantiation(access, STATS_COMPONENT_CLASS);
    }
    if (access.findClassByName(TAGS_COMPONENT_CLASS) != null) {
      registerForReflectiveInstantiation(access, "io.opencensus.impl.metrics.MetricsComponentImpl");
      registerForReflectiveInstantiation(access, TAGS_COMPONENT_CLASS);
      registerForReflectiveInstantiation(access, "io.opencensus.impl.trace.TraceComponentImpl");
    }
  }
}
