/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.retail.v2alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsRequest;
import com.google.cloud.retail.v2alpha.BatchUpdateGenerativeQuestionConfigsResponse;
import com.google.cloud.retail.v2alpha.GenerativeQuestionConfig;
import com.google.cloud.retail.v2alpha.GenerativeQuestionsFeatureConfig;
import com.google.cloud.retail.v2alpha.GetGenerativeQuestionsFeatureConfigRequest;
import com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsRequest;
import com.google.cloud.retail.v2alpha.ListGenerativeQuestionConfigsResponse;
import com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionConfigRequest;
import com.google.cloud.retail.v2alpha.UpdateGenerativeQuestionsFeatureConfigRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GenerativeQuestionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class GenerativeQuestionServiceStub implements BackgroundResource {

  public UnaryCallable<
          UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      updateGenerativeQuestionsFeatureConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGenerativeQuestionsFeatureConfigCallable()");
  }

  public UnaryCallable<GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      getGenerativeQuestionsFeatureConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getGenerativeQuestionsFeatureConfigCallable()");
  }

  public UnaryCallable<ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
      listGenerativeQuestionConfigsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGenerativeQuestionConfigsCallable()");
  }

  public UnaryCallable<UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>
      updateGenerativeQuestionConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGenerativeQuestionConfigCallable()");
  }

  public UnaryCallable<
          BatchUpdateGenerativeQuestionConfigsRequest, BatchUpdateGenerativeQuestionConfigsResponse>
      batchUpdateGenerativeQuestionConfigsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateGenerativeQuestionConfigsCallable()");
  }

  @Override
  public abstract void close();
}
