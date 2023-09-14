/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.language.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.language.v2.AnalyzeEntitiesRequest;
import com.google.cloud.language.v2.AnalyzeEntitiesResponse;
import com.google.cloud.language.v2.AnalyzeSentimentRequest;
import com.google.cloud.language.v2.AnalyzeSentimentResponse;
import com.google.cloud.language.v2.AnnotateTextRequest;
import com.google.cloud.language.v2.AnnotateTextResponse;
import com.google.cloud.language.v2.ClassifyTextRequest;
import com.google.cloud.language.v2.ClassifyTextResponse;
import com.google.cloud.language.v2.ModerateTextRequest;
import com.google.cloud.language.v2.ModerateTextResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LanguageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LanguageServiceStub implements BackgroundResource {

  public UnaryCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentCallable() {
    throw new UnsupportedOperationException("Not implemented: analyzeSentimentCallable()");
  }

  public UnaryCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse> analyzeEntitiesCallable() {
    throw new UnsupportedOperationException("Not implemented: analyzeEntitiesCallable()");
  }

  public UnaryCallable<ClassifyTextRequest, ClassifyTextResponse> classifyTextCallable() {
    throw new UnsupportedOperationException("Not implemented: classifyTextCallable()");
  }

  public UnaryCallable<ModerateTextRequest, ModerateTextResponse> moderateTextCallable() {
    throw new UnsupportedOperationException("Not implemented: moderateTextCallable()");
  }

  public UnaryCallable<AnnotateTextRequest, AnnotateTextResponse> annotateTextCallable() {
    throw new UnsupportedOperationException("Not implemented: annotateTextCallable()");
  }

  @Override
  public abstract void close();
}
