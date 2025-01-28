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

package com.google.cloud.retail.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.BatchUpdateGenerativeQuestionConfigsRequest;
import com.google.cloud.retail.v2.BatchUpdateGenerativeQuestionConfigsResponse;
import com.google.cloud.retail.v2.GenerativeQuestionConfig;
import com.google.cloud.retail.v2.GenerativeQuestionsFeatureConfig;
import com.google.cloud.retail.v2.GetGenerativeQuestionsFeatureConfigRequest;
import com.google.cloud.retail.v2.ListGenerativeQuestionConfigsRequest;
import com.google.cloud.retail.v2.ListGenerativeQuestionConfigsResponse;
import com.google.cloud.retail.v2.UpdateGenerativeQuestionConfigRequest;
import com.google.cloud.retail.v2.UpdateGenerativeQuestionsFeatureConfigRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GenerativeQuestionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
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
