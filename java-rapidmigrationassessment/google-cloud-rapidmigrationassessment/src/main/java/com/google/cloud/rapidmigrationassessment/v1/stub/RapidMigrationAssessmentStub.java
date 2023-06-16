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

package com.google.cloud.rapidmigrationassessment.v1.stub;

import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListCollectorsPagedResponse;
import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.rapidmigrationassessment.v1.Annotation;
import com.google.cloud.rapidmigrationassessment.v1.Collector;
import com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest;
import com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest;
import com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest;
import com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse;
import com.google.cloud.rapidmigrationassessment.v1.OperationMetadata;
import com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RapidMigrationAssessment service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RapidMigrationAssessmentStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateCollectorRequest, Collector, OperationMetadata>
      createCollectorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createCollectorOperationCallable()");
  }

  public UnaryCallable<CreateCollectorRequest, Operation> createCollectorCallable() {
    throw new UnsupportedOperationException("Not implemented: createCollectorCallable()");
  }

  public OperationCallable<CreateAnnotationRequest, Annotation, OperationMetadata>
      createAnnotationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAnnotationOperationCallable()");
  }

  public UnaryCallable<CreateAnnotationRequest, Operation> createAnnotationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAnnotationCallable()");
  }

  public UnaryCallable<GetAnnotationRequest, Annotation> getAnnotationCallable() {
    throw new UnsupportedOperationException("Not implemented: getAnnotationCallable()");
  }

  public UnaryCallable<ListCollectorsRequest, ListCollectorsPagedResponse>
      listCollectorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCollectorsPagedCallable()");
  }

  public UnaryCallable<ListCollectorsRequest, ListCollectorsResponse> listCollectorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCollectorsCallable()");
  }

  public UnaryCallable<GetCollectorRequest, Collector> getCollectorCallable() {
    throw new UnsupportedOperationException("Not implemented: getCollectorCallable()");
  }

  public OperationCallable<UpdateCollectorRequest, Collector, OperationMetadata>
      updateCollectorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCollectorOperationCallable()");
  }

  public UnaryCallable<UpdateCollectorRequest, Operation> updateCollectorCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCollectorCallable()");
  }

  public OperationCallable<DeleteCollectorRequest, Collector, OperationMetadata>
      deleteCollectorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCollectorOperationCallable()");
  }

  public UnaryCallable<DeleteCollectorRequest, Operation> deleteCollectorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCollectorCallable()");
  }

  public OperationCallable<ResumeCollectorRequest, Collector, OperationMetadata>
      resumeCollectorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeCollectorOperationCallable()");
  }

  public UnaryCallable<ResumeCollectorRequest, Operation> resumeCollectorCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeCollectorCallable()");
  }

  public OperationCallable<RegisterCollectorRequest, Collector, OperationMetadata>
      registerCollectorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: registerCollectorOperationCallable()");
  }

  public UnaryCallable<RegisterCollectorRequest, Operation> registerCollectorCallable() {
    throw new UnsupportedOperationException("Not implemented: registerCollectorCallable()");
  }

  public OperationCallable<PauseCollectorRequest, Collector, OperationMetadata>
      pauseCollectorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: pauseCollectorOperationCallable()");
  }

  public UnaryCallable<PauseCollectorRequest, Operation> pauseCollectorCallable() {
    throw new UnsupportedOperationException("Not implemented: pauseCollectorCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
