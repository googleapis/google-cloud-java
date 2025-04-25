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

package com.google.cloud.datacatalog.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.datacatalog.v1.DataCatalogGrpc.DataCatalogImplBase;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockDataCatalogImpl extends DataCatalogImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataCatalogImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void searchCatalog(
      SearchCatalogRequest request, StreamObserver<SearchCatalogResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchCatalogResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchCatalogResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchCatalogResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEntryGroup(
      CreateEntryGroupRequest request, StreamObserver<EntryGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EntryGroup) {
      requests.add(request);
      responseObserver.onNext(((EntryGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEntryGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EntryGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEntryGroup(
      GetEntryGroupRequest request, StreamObserver<EntryGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EntryGroup) {
      requests.add(request);
      responseObserver.onNext(((EntryGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEntryGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EntryGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEntryGroup(
      UpdateEntryGroupRequest request, StreamObserver<EntryGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EntryGroup) {
      requests.add(request);
      responseObserver.onNext(((EntryGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateEntryGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EntryGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEntryGroup(
      DeleteEntryGroupRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteEntryGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEntryGroups(
      ListEntryGroupsRequest request, StreamObserver<ListEntryGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEntryGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEntryGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEntryGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEntryGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEntry(CreateEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext(((Entry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEntry(UpdateEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext(((Entry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEntry(DeleteEntryRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEntry(GetEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext(((Entry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void lookupEntry(LookupEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext(((Entry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method LookupEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEntries(
      ListEntriesRequest request, StreamObserver<ListEntriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEntriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEntriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEntries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEntriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void modifyEntryOverview(
      ModifyEntryOverviewRequest request, StreamObserver<EntryOverview> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EntryOverview) {
      requests.add(request);
      responseObserver.onNext(((EntryOverview) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ModifyEntryOverview, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EntryOverview.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void modifyEntryContacts(
      ModifyEntryContactsRequest request, StreamObserver<Contacts> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Contacts) {
      requests.add(request);
      responseObserver.onNext(((Contacts) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ModifyEntryContacts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Contacts.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTagTemplate(
      CreateTagTemplateRequest request, StreamObserver<TagTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TagTemplate) {
      requests.add(request);
      responseObserver.onNext(((TagTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTagTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TagTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTagTemplate(
      GetTagTemplateRequest request, StreamObserver<TagTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TagTemplate) {
      requests.add(request);
      responseObserver.onNext(((TagTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTagTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TagTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTagTemplate(
      UpdateTagTemplateRequest request, StreamObserver<TagTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TagTemplate) {
      requests.add(request);
      responseObserver.onNext(((TagTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTagTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TagTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTagTemplate(
      DeleteTagTemplateRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteTagTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTagTemplateField(
      CreateTagTemplateFieldRequest request, StreamObserver<TagTemplateField> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TagTemplateField) {
      requests.add(request);
      responseObserver.onNext(((TagTemplateField) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTagTemplateField, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TagTemplateField.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTagTemplateField(
      UpdateTagTemplateFieldRequest request, StreamObserver<TagTemplateField> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TagTemplateField) {
      requests.add(request);
      responseObserver.onNext(((TagTemplateField) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTagTemplateField, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TagTemplateField.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void renameTagTemplateField(
      RenameTagTemplateFieldRequest request, StreamObserver<TagTemplateField> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TagTemplateField) {
      requests.add(request);
      responseObserver.onNext(((TagTemplateField) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RenameTagTemplateField, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TagTemplateField.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void renameTagTemplateFieldEnumValue(
      RenameTagTemplateFieldEnumValueRequest request,
      StreamObserver<TagTemplateField> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TagTemplateField) {
      requests.add(request);
      responseObserver.onNext(((TagTemplateField) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RenameTagTemplateFieldEnumValue, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TagTemplateField.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTagTemplateField(
      DeleteTagTemplateFieldRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteTagTemplateField, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTag(CreateTagRequest request, StreamObserver<Tag> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tag) {
      requests.add(request);
      responseObserver.onNext(((Tag) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tag.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTag(UpdateTagRequest request, StreamObserver<Tag> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tag) {
      requests.add(request);
      responseObserver.onNext(((Tag) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tag.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTag(DeleteTagRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTags(ListTagsRequest request, StreamObserver<ListTagsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTagsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTagsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTags, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTagsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void reconcileTags(
      ReconcileTagsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReconcileTags, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void starEntry(
      StarEntryRequest request, StreamObserver<StarEntryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StarEntryResponse) {
      requests.add(request);
      responseObserver.onNext(((StarEntryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method StarEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StarEntryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void unstarEntry(
      UnstarEntryRequest request, StreamObserver<UnstarEntryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UnstarEntryResponse) {
      requests.add(request);
      responseObserver.onNext(((UnstarEntryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UnstarEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UnstarEntryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetIamPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIamPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TestIamPermissionsResponse) {
      requests.add(request);
      responseObserver.onNext(((TestIamPermissionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TestIamPermissions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TestIamPermissionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importEntries(
      ImportEntriesRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportEntries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setConfig(
      SetConfigRequest request, StreamObserver<MigrationConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MigrationConfig) {
      requests.add(request);
      responseObserver.onNext(((MigrationConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MigrationConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveConfig(
      RetrieveConfigRequest request, StreamObserver<OrganizationConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OrganizationConfig) {
      requests.add(request);
      responseObserver.onNext(((OrganizationConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  OrganizationConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveEffectiveConfig(
      RetrieveEffectiveConfigRequest request, StreamObserver<MigrationConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MigrationConfig) {
      requests.add(request);
      responseObserver.onNext(((MigrationConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveEffectiveConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MigrationConfig.class.getName(),
                  Exception.class.getName())));
    }
  }
}
