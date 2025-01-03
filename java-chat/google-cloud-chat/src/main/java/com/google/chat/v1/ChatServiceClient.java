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

package com.google.chat.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.chat.v1.stub.ChatServiceStub;
import com.google.chat.v1.stub.ChatServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Enables developers to build Chat apps and integrations on Google Chat
 * Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
 *   SpaceName parent = SpaceName.of("[SPACE]");
 *   Message message = Message.newBuilder().build();
 *   String messageId = "messageId-1440013438";
 *   Message response = chatServiceClient.createMessage(parent, message, messageId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ChatServiceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMessage</td>
 *      <td><p> Creates a message in a Google Chat space. For an example, see [Send a message](https://developers.google.com/workspace/chat/create-messages).
 * <p>  The `create()` method requires either [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) or [app authentication](https://developers.google.com/workspace/chat/authorize-import). Chat attributes the message sender differently depending on the type of authentication that you use in your request.
 * <p>  The following image shows how Chat attributes a message when you use app authentication. Chat displays the Chat app as the message sender. The content of the message can contain text (`text`), cards (`cardsV2`), and accessory widgets (`accessoryWidgets`).
 * <p>  ![Message sent with app authentication](https://developers.google.com/workspace/chat/images/message-app-auth.svg)
 * <p>  The following image shows how Chat attributes a message when you use user authentication. Chat displays the user as the message sender and attributes the Chat app to the message by displaying its name. The content of message can only contain text (`text`).
 * <p>  ![Message sent with user authentication](https://developers.google.com/workspace/chat/images/message-user-auth.svg)
 * <p>  The maximum message size, including the message contents, is 32,000 bytes.
 * <p>  For [webhook](https://developers.google.com/workspace/chat/quickstart/webhooks) requests, the response doesn't contain the full message. The response only populates the `name` and `thread.name` fields in addition to the information that was in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMessage(CreateMessageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createMessage(SpaceName parent, Message message, String messageId)
 *           <li><p> createMessage(String parent, Message message, String messageId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMessageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMessages</td>
 *      <td><p> Lists messages in a space that the caller is a member of, including messages from blocked members and spaces. If you list messages from a space with no messages, the response is an empty object. When using a REST/HTTP interface, the response contains an empty JSON object, `{}`. For an example, see [List messages](https://developers.google.com/workspace/chat/api/guides/v1/messages/list).
 * <p>  Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMessages(ListMessagesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMessages(SpaceName parent)
 *           <li><p> listMessages(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMessagesPagedCallable()
 *           <li><p> listMessagesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMemberships</td>
 *      <td><p> Lists memberships in a space. For an example, see [List users and Google Chat apps in a space](https://developers.google.com/workspace/chat/list-members). Listing memberships with [app authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app) lists memberships in spaces that the Chat app has access to, but excludes Chat app memberships, including its own. Listing memberships with [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) lists memberships in spaces that the authenticated user has access to.
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) You can authenticate and authorize this method with administrator privileges by setting the `use_admin_access` field in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMemberships(ListMembershipsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMemberships(SpaceName parent)
 *           <li><p> listMemberships(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMembershipsPagedCallable()
 *           <li><p> listMembershipsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMembership</td>
 *      <td><p> Returns details about a membership. For an example, see [Get details about a user's or Google Chat app's membership](https://developers.google.com/workspace/chat/get-members).
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) You can authenticate and authorize this method with administrator privileges by setting the `use_admin_access` field in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMembership(GetMembershipRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMembership(MembershipName name)
 *           <li><p> getMembership(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMembershipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMessage</td>
 *      <td><p> Returns details about a message. For an example, see [Get details about a message](https://developers.google.com/workspace/chat/get-messages).
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
 * <p>  Note: Might return a message from a blocked member or space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMessage(GetMessageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMessage(MessageName name)
 *           <li><p> getMessage(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMessageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMessage</td>
 *      <td><p> Updates a message. There's a difference between the `patch` and `update` methods. The `patch` method uses a `patch` request while the `update` method uses a `put` request. We recommend using the `patch` method. For an example, see [Update a message](https://developers.google.com/workspace/chat/update-messages).
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
 * <p>  When using app authentication, requests can only update messages created by the calling Chat app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMessage(UpdateMessageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateMessage(Message message, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMessageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMessage</td>
 *      <td><p> Deletes a message. For an example, see [Delete a message](https://developers.google.com/workspace/chat/delete-messages).
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
 * <p>  When using app authentication, requests can only delete messages created by the calling Chat app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMessage(DeleteMessageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteMessage(MessageName name)
 *           <li><p> deleteMessage(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMessageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAttachment</td>
 *      <td><p> Gets the metadata of a message attachment. The attachment data is fetched using the [media API](https://developers.google.com/workspace/chat/api/reference/rest/v1/media/download). For an example, see [Get metadata about a message attachment](https://developers.google.com/workspace/chat/get-media-attachments). Requires [app authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAttachment(GetAttachmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAttachment(AttachmentName name)
 *           <li><p> getAttachment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UploadAttachment</td>
 *      <td><p> Uploads an attachment. For an example, see [Upload media as a file attachment](https://developers.google.com/workspace/chat/upload-media-attachments).
 * <p>  Requires user [authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
 * <p>  You can upload attachments up to 200 MB. Certain file types aren't supported. For details, see [File types blocked by Google Chat](https://support.google.com/chat/answer/7651457?&amp;co=GENIE.Platform%3DDesktop#File%20types%20blocked%20in%20Google%20Chat).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> uploadAttachment(UploadAttachmentRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> uploadAttachmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSpaces</td>
 *      <td><p> Lists spaces the caller is a member of. Group chats and DMs aren't listed until the first message is sent. For an example, see [List spaces](https://developers.google.com/workspace/chat/list-spaces).
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
 * <p>  To list all named spaces by Google Workspace organization, use the [`spaces.search()`](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces/search) method using Workspace administrator privileges instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSpaces(ListSpacesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSpaces()
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSpacesPagedCallable()
 *           <li><p> listSpacesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchSpaces</td>
 *      <td><p> Returns a list of spaces in a Google Workspace organization based on an administrator's search.
 * <p>  Requires [user authentication with administrator privileges](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user#admin-privileges). In the request, set `use_admin_access` to `true`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchSpaces(SearchSpacesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchSpaces()
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchSpacesPagedCallable()
 *           <li><p> searchSpacesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSpace</td>
 *      <td><p> Returns details about a space. For an example, see [Get details about a space](https://developers.google.com/workspace/chat/get-spaces).
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) You can authenticate and authorize this method with administrator privileges by setting the `use_admin_access` field in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSpace(GetSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSpace(SpaceName name)
 *           <li><p> getSpace(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSpace</td>
 *      <td><p> Creates a space with no members. Can be used to create a named space, or a group chat in `Import mode`. For an example, see [Create a space](https://developers.google.com/workspace/chat/create-spaces).
 * <p>   If you receive the error message `ALREADY_EXISTS` when creating  a space, try a different `displayName`. An existing space within  the Google Workspace organization might already use this display name.
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app) with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer Preview](https://developers.google.com/workspace/preview)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
 * <p>  When authenticating as an app, the `space.customer` field must be set in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSpace(CreateSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSpace(Space space)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetUpSpace</td>
 *      <td><p> Creates a space and adds specified users to it. The calling user is automatically added to the space, and shouldn't be specified as a membership in the request. For an example, see [Set up a space with initial members](https://developers.google.com/workspace/chat/set-up-spaces).
 * <p>  To specify the human members to add, add memberships with the appropriate `membership.member.name`. To add a human user, use `users/{user}`, where `{user}` can be the email address for the user. For users in the same Workspace organization `{user}` can also be the `id` for the person from the People API, or the `id` for the user in the Directory API. For example, if the People API Person profile ID for `user{@literal @}example.com` is `123456789`, you can add the user to the space by setting the `membership.member.name` to `users/user{@literal @}example.com` or `users/123456789`.
 * <p>  To specify the Google groups to add, add memberships with the appropriate `membership.group_member.name`. To add or invite a Google group, use `groups/{group}`, where `{group}` is the `id` for the group from the Cloud Identity Groups API. For example, you can use [Cloud Identity Groups lookup API](https://cloud.google.com/identity/docs/reference/rest/v1/groups/lookup) to retrieve the ID `123456789` for group email `group{@literal @}example.com`, then you can add the group to the space by setting the `membership.group_member.name` to `groups/123456789`. Group email is not supported, and Google groups can only be added as members in named spaces.
 * <p>  For a named space or group chat, if the caller blocks, or is blocked by some members, or doesn't have permission to add some members, then those members aren't added to the created space.
 * <p>  To create a direct message (DM) between the calling user and another human user, specify exactly one membership to represent the human user. If one user blocks the other, the request fails and the DM isn't created.
 * <p>  To create a DM between the calling user and the calling app, set `Space.singleUserBotDm` to `true` and don't specify any memberships. You can only use this method to set up a DM with the calling app. To add the calling app as a member of a space or an existing DM between two human users, see [Invite or add a user or app to a space](https://developers.google.com/workspace/chat/create-members).
 * <p>  If a DM already exists between two users, even when one user blocks the other at the time a request is made, then the existing DM is returned.
 * <p>  Spaces with threaded replies aren't supported. If you receive the error message `ALREADY_EXISTS` when setting up a space, try a different `displayName`. An existing space within the Google Workspace organization might already use this display name.
 * <p>  Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setUpSpace(SetUpSpaceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setUpSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSpace</td>
 *      <td><p> Updates a space. For an example, see [Update a space](https://developers.google.com/workspace/chat/update-spaces).
 * <p>  If you're updating the `displayName` field and receive the error message `ALREADY_EXISTS`, try a different display name.. An existing space within the Google Workspace organization might already use this display name.
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app) with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer Preview](https://developers.google.com/workspace/preview)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) You can authenticate and authorize this method with administrator privileges by setting the `use_admin_access` field in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSpace(UpdateSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSpace(Space space, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSpace</td>
 *      <td><p> Deletes a named space. Always performs a cascading delete, which means that the space's child resources—like messages posted in the space and memberships in the space—are also deleted. For an example, see [Delete a space](https://developers.google.com/workspace/chat/delete-spaces).
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app) with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer Preview](https://developers.google.com/workspace/preview)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) You can authenticate and authorize this method with administrator privileges by setting the `use_admin_access` field in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSpace(DeleteSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSpace(SpaceName name)
 *           <li><p> deleteSpace(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CompleteImportSpace</td>
 *      <td><p> Completes the [import process](https://developers.google.com/workspace/chat/import-data) for the specified space and makes it visible to users.
 * <p>  Requires [app authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app) and domain-wide delegation. For more information, see [Authorize Google Chat apps to import data](https://developers.google.com/workspace/chat/authorize-import).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> completeImportSpace(CompleteImportSpaceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> completeImportSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FindDirectMessage</td>
 *      <td><p> Returns the existing direct message with the specified user. If no direct message space is found, returns a `404 NOT_FOUND` error. For an example, see [Find a direct message](/chat/api/guides/v1/spaces/find-direct-message).
 * <p>  With [app authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app), returns the direct message space between the specified user and the calling Chat app.
 * <p>  With [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user), returns the direct message space between the specified user and the authenticated user.
 * <p>  // Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> findDirectMessage(FindDirectMessageRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> findDirectMessageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMembership</td>
 *      <td><p> Creates a membership for the calling Chat app, a user, or a Google Group. Creating memberships for other Chat apps isn't supported. When creating a membership, if the specified member has their auto-accept policy turned off, then they're invited, and must accept the space invitation before joining. Otherwise, creating a membership adds the member directly to the specified space.
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app) with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer Preview](https://developers.google.com/workspace/preview)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) You can authenticate and authorize this method with administrator privileges by setting the `use_admin_access` field in the request.
 * <p>  For example usage, see:
 * <p>  - [Invite or add a user to a space](https://developers.google.com/workspace/chat/create-members#create-user-membership).
 * <p>  - [Invite or add a Google Group to a space](https://developers.google.com/workspace/chat/create-members#create-group-membership).
 * <p>  - [Add the Chat app to a space](https://developers.google.com/workspace/chat/create-members#create-membership-calling-api).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMembership(CreateMembershipRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createMembership(SpaceName parent, Membership membership)
 *           <li><p> createMembership(String parent, Membership membership)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMembershipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMembership</td>
 *      <td><p> Updates a membership. For an example, see [Update a user's membership in a space](https://developers.google.com/workspace/chat/update-members).
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app) with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer Preview](https://developers.google.com/workspace/preview)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) You can authenticate and authorize this method with administrator privileges by setting the `use_admin_access` field in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMembership(UpdateMembershipRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateMembership(Membership membership, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMembershipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMembership</td>
 *      <td><p> Deletes a membership. For an example, see [Remove a user or a Google Chat app from a space](https://developers.google.com/workspace/chat/delete-members).
 * <p>  Supports the following types of [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
 * <p>  - [App authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app) with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer Preview](https://developers.google.com/workspace/preview)
 * <p>  - [User authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) You can authenticate and authorize this method with administrator privileges by setting the `use_admin_access` field in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMembership(DeleteMembershipRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteMembership(MembershipName name)
 *           <li><p> deleteMembership(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMembershipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateReaction</td>
 *      <td><p> Creates a reaction and adds it to a message. Only unicode emojis are supported. For an example, see [Add a reaction to a message](https://developers.google.com/workspace/chat/create-reactions).
 * <p>  Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReaction(CreateReactionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createReaction(MessageName parent, Reaction reaction)
 *           <li><p> createReaction(String parent, Reaction reaction)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReactionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReactions</td>
 *      <td><p> Lists reactions to a message. For an example, see [List reactions for a message](https://developers.google.com/workspace/chat/list-reactions).
 * <p>  Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReactions(ListReactionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReactions(MessageName parent)
 *           <li><p> listReactions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReactionsPagedCallable()
 *           <li><p> listReactionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteReaction</td>
 *      <td><p> Deletes a reaction to a message. Only unicode emojis are supported. For an example, see [Delete a reaction](https://developers.google.com/workspace/chat/delete-reactions).
 * <p>  Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteReaction(DeleteReactionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteReaction(ReactionName name)
 *           <li><p> deleteReaction(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteReactionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSpaceReadState</td>
 *      <td><p> Returns details about a user's read state within a space, used to identify read and unread messages. For an example, see [Get details about a user's space read state](https://developers.google.com/workspace/chat/get-space-read-state).
 * <p>  Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSpaceReadState(GetSpaceReadStateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSpaceReadState(SpaceReadStateName name)
 *           <li><p> getSpaceReadState(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSpaceReadStateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSpaceReadState</td>
 *      <td><p> Updates a user's read state within a space, used to identify read and unread messages. For an example, see [Update a user's space read state](https://developers.google.com/workspace/chat/update-space-read-state).
 * <p>  Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSpaceReadState(UpdateSpaceReadStateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSpaceReadState(SpaceReadState spaceReadState, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSpaceReadStateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetThreadReadState</td>
 *      <td><p> Returns details about a user's read state within a thread, used to identify read and unread messages. For an example, see [Get details about a user's thread read state](https://developers.google.com/workspace/chat/get-thread-read-state).
 * <p>  Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getThreadReadState(GetThreadReadStateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getThreadReadState(ThreadReadStateName name)
 *           <li><p> getThreadReadState(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getThreadReadStateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSpaceEvent</td>
 *      <td><p> Returns an event from a Google Chat space. The [event payload](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.oneof_payload) contains the most recent version of the resource that changed. For example, if you request an event about a new message but the message was later updated, the server returns the updated `Message` resource in the event payload.
 * <p>  Note: The `permissionSettings` field is not returned in the Space object of the Space event data for this request.
 * <p>  Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user). To get an event, the authenticated user must be a member of the space.
 * <p>  For an example, see [Get details about an event from a Google Chat space](https://developers.google.com/workspace/chat/get-space-event).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSpaceEvent(GetSpaceEventRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSpaceEvent(SpaceEventName name)
 *           <li><p> getSpaceEvent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSpaceEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSpaceEvents</td>
 *      <td><p> Lists events from a Google Chat space. For each event, the [payload](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.oneof_payload) contains the most recent version of the Chat resource. For example, if you list events about new space members, the server returns `Membership` resources that contain the latest membership details. If new members were removed during the requested period, the event payload contains an empty `Membership` resource.
 * <p>  Requires [user authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user). To list events, the authenticated user must be a member of the space.
 * <p>  For an example, see [List events from a Google Chat space](https://developers.google.com/workspace/chat/list-space-events).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSpaceEvents(ListSpaceEventsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSpaceEvents(SpaceName parent, String filter)
 *           <li><p> listSpaceEvents(String parent, String filter)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSpaceEventsPagedCallable()
 *           <li><p> listSpaceEventsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ChatServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ChatServiceSettings chatServiceSettings =
 *     ChatServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ChatServiceClient chatServiceClient = ChatServiceClient.create(chatServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ChatServiceSettings chatServiceSettings =
 *     ChatServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ChatServiceClient chatServiceClient = ChatServiceClient.create(chatServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ChatServiceSettings chatServiceSettings = ChatServiceSettings.newHttpJsonBuilder().build();
 * ChatServiceClient chatServiceClient = ChatServiceClient.create(chatServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ChatServiceClient implements BackgroundResource {
  private final ChatServiceSettings settings;
  private final ChatServiceStub stub;

  /** Constructs an instance of ChatServiceClient with default settings. */
  public static final ChatServiceClient create() throws IOException {
    return create(ChatServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ChatServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ChatServiceClient create(ChatServiceSettings settings) throws IOException {
    return new ChatServiceClient(settings);
  }

  /**
   * Constructs an instance of ChatServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ChatServiceSettings).
   */
  public static final ChatServiceClient create(ChatServiceStub stub) {
    return new ChatServiceClient(stub);
  }

  /**
   * Constructs an instance of ChatServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ChatServiceClient(ChatServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ChatServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ChatServiceClient(ChatServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ChatServiceSettings getSettings() {
    return settings;
  }

  public ChatServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a message in a Google Chat space. For an example, see [Send a
   * message](https://developers.google.com/workspace/chat/create-messages).
   *
   * <p>The `create()` method requires either [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * or [app authentication](https://developers.google.com/workspace/chat/authorize-import). Chat
   * attributes the message sender differently depending on the type of authentication that you use
   * in your request.
   *
   * <p>The following image shows how Chat attributes a message when you use app authentication.
   * Chat displays the Chat app as the message sender. The content of the message can contain text
   * (`text`), cards (`cardsV2`), and accessory widgets (`accessoryWidgets`).
   *
   * <p>![Message sent with app
   * authentication](https://developers.google.com/workspace/chat/images/message-app-auth.svg)
   *
   * <p>The following image shows how Chat attributes a message when you use user authentication.
   * Chat displays the user as the message sender and attributes the Chat app to the message by
   * displaying its name. The content of message can only contain text (`text`).
   *
   * <p>![Message sent with user
   * authentication](https://developers.google.com/workspace/chat/images/message-user-auth.svg)
   *
   * <p>The maximum message size, including the message contents, is 32,000 bytes.
   *
   * <p>For [webhook](https://developers.google.com/workspace/chat/quickstart/webhooks) requests,
   * the response doesn't contain the full message. The response only populates the `name` and
   * `thread.name` fields in addition to the information that was in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SpaceName parent = SpaceName.of("[SPACE]");
   *   Message message = Message.newBuilder().build();
   *   String messageId = "messageId-1440013438";
   *   Message response = chatServiceClient.createMessage(parent, message, messageId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the space in which to create a message.
   *     <p>Format: `spaces/{space}`
   * @param message Required. Message body.
   * @param messageId Optional. A custom ID for a message. Lets Chat apps get, update, or delete a
   *     message without needing to store the system-assigned ID in the message's resource name
   *     (represented in the message `name` field).
   *     <p>The value for this field must meet the following requirements:
   *     <ul>
   *       <li>Begins with `client-`. For example, `client-custom-name` is a valid custom ID, but
   *           `custom-name` is not.
   *       <li>Contains up to 63 characters and only lowercase letters, numbers, and hyphens.
   *       <li>Is unique within a space. A Chat app can't use the same custom ID for different
   *           messages.
   *     </ul>
   *     <p>For details, see [Name a
   *     message](https://developers.google.com/workspace/chat/create-messages#name_a_created_message).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Message createMessage(SpaceName parent, Message message, String messageId) {
    CreateMessageRequest request =
        CreateMessageRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMessage(message)
            .setMessageId(messageId)
            .build();
    return createMessage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a message in a Google Chat space. For an example, see [Send a
   * message](https://developers.google.com/workspace/chat/create-messages).
   *
   * <p>The `create()` method requires either [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * or [app authentication](https://developers.google.com/workspace/chat/authorize-import). Chat
   * attributes the message sender differently depending on the type of authentication that you use
   * in your request.
   *
   * <p>The following image shows how Chat attributes a message when you use app authentication.
   * Chat displays the Chat app as the message sender. The content of the message can contain text
   * (`text`), cards (`cardsV2`), and accessory widgets (`accessoryWidgets`).
   *
   * <p>![Message sent with app
   * authentication](https://developers.google.com/workspace/chat/images/message-app-auth.svg)
   *
   * <p>The following image shows how Chat attributes a message when you use user authentication.
   * Chat displays the user as the message sender and attributes the Chat app to the message by
   * displaying its name. The content of message can only contain text (`text`).
   *
   * <p>![Message sent with user
   * authentication](https://developers.google.com/workspace/chat/images/message-user-auth.svg)
   *
   * <p>The maximum message size, including the message contents, is 32,000 bytes.
   *
   * <p>For [webhook](https://developers.google.com/workspace/chat/quickstart/webhooks) requests,
   * the response doesn't contain the full message. The response only populates the `name` and
   * `thread.name` fields in addition to the information that was in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String parent = SpaceName.of("[SPACE]").toString();
   *   Message message = Message.newBuilder().build();
   *   String messageId = "messageId-1440013438";
   *   Message response = chatServiceClient.createMessage(parent, message, messageId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the space in which to create a message.
   *     <p>Format: `spaces/{space}`
   * @param message Required. Message body.
   * @param messageId Optional. A custom ID for a message. Lets Chat apps get, update, or delete a
   *     message without needing to store the system-assigned ID in the message's resource name
   *     (represented in the message `name` field).
   *     <p>The value for this field must meet the following requirements:
   *     <ul>
   *       <li>Begins with `client-`. For example, `client-custom-name` is a valid custom ID, but
   *           `custom-name` is not.
   *       <li>Contains up to 63 characters and only lowercase letters, numbers, and hyphens.
   *       <li>Is unique within a space. A Chat app can't use the same custom ID for different
   *           messages.
   *     </ul>
   *     <p>For details, see [Name a
   *     message](https://developers.google.com/workspace/chat/create-messages#name_a_created_message).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Message createMessage(String parent, Message message, String messageId) {
    CreateMessageRequest request =
        CreateMessageRequest.newBuilder()
            .setParent(parent)
            .setMessage(message)
            .setMessageId(messageId)
            .build();
    return createMessage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a message in a Google Chat space. For an example, see [Send a
   * message](https://developers.google.com/workspace/chat/create-messages).
   *
   * <p>The `create()` method requires either [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * or [app authentication](https://developers.google.com/workspace/chat/authorize-import). Chat
   * attributes the message sender differently depending on the type of authentication that you use
   * in your request.
   *
   * <p>The following image shows how Chat attributes a message when you use app authentication.
   * Chat displays the Chat app as the message sender. The content of the message can contain text
   * (`text`), cards (`cardsV2`), and accessory widgets (`accessoryWidgets`).
   *
   * <p>![Message sent with app
   * authentication](https://developers.google.com/workspace/chat/images/message-app-auth.svg)
   *
   * <p>The following image shows how Chat attributes a message when you use user authentication.
   * Chat displays the user as the message sender and attributes the Chat app to the message by
   * displaying its name. The content of message can only contain text (`text`).
   *
   * <p>![Message sent with user
   * authentication](https://developers.google.com/workspace/chat/images/message-user-auth.svg)
   *
   * <p>The maximum message size, including the message contents, is 32,000 bytes.
   *
   * <p>For [webhook](https://developers.google.com/workspace/chat/quickstart/webhooks) requests,
   * the response doesn't contain the full message. The response only populates the `name` and
   * `thread.name` fields in addition to the information that was in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   CreateMessageRequest request =
   *       CreateMessageRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setMessage(Message.newBuilder().build())
   *           .setThreadKey("threadKey-1562254347")
   *           .setRequestId("requestId693933066")
   *           .setMessageId("messageId-1440013438")
   *           .build();
   *   Message response = chatServiceClient.createMessage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Message createMessage(CreateMessageRequest request) {
    return createMessageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a message in a Google Chat space. For an example, see [Send a
   * message](https://developers.google.com/workspace/chat/create-messages).
   *
   * <p>The `create()` method requires either [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * or [app authentication](https://developers.google.com/workspace/chat/authorize-import). Chat
   * attributes the message sender differently depending on the type of authentication that you use
   * in your request.
   *
   * <p>The following image shows how Chat attributes a message when you use app authentication.
   * Chat displays the Chat app as the message sender. The content of the message can contain text
   * (`text`), cards (`cardsV2`), and accessory widgets (`accessoryWidgets`).
   *
   * <p>![Message sent with app
   * authentication](https://developers.google.com/workspace/chat/images/message-app-auth.svg)
   *
   * <p>The following image shows how Chat attributes a message when you use user authentication.
   * Chat displays the user as the message sender and attributes the Chat app to the message by
   * displaying its name. The content of message can only contain text (`text`).
   *
   * <p>![Message sent with user
   * authentication](https://developers.google.com/workspace/chat/images/message-user-auth.svg)
   *
   * <p>The maximum message size, including the message contents, is 32,000 bytes.
   *
   * <p>For [webhook](https://developers.google.com/workspace/chat/quickstart/webhooks) requests,
   * the response doesn't contain the full message. The response only populates the `name` and
   * `thread.name` fields in addition to the information that was in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   CreateMessageRequest request =
   *       CreateMessageRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setMessage(Message.newBuilder().build())
   *           .setThreadKey("threadKey-1562254347")
   *           .setRequestId("requestId693933066")
   *           .setMessageId("messageId-1440013438")
   *           .build();
   *   ApiFuture<Message> future = chatServiceClient.createMessageCallable().futureCall(request);
   *   // Do something.
   *   Message response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMessageRequest, Message> createMessageCallable() {
    return stub.createMessageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists messages in a space that the caller is a member of, including messages from blocked
   * members and spaces. If you list messages from a space with no messages, the response is an
   * empty object. When using a REST/HTTP interface, the response contains an empty JSON object,
   * `{}`. For an example, see [List
   * messages](https://developers.google.com/workspace/chat/api/guides/v1/messages/list).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SpaceName parent = SpaceName.of("[SPACE]");
   *   for (Message element : chatServiceClient.listMessages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the space to list messages from.
   *     <p>Format: `spaces/{space}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessagesPagedResponse listMessages(SpaceName parent) {
    ListMessagesRequest request =
        ListMessagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMessages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists messages in a space that the caller is a member of, including messages from blocked
   * members and spaces. If you list messages from a space with no messages, the response is an
   * empty object. When using a REST/HTTP interface, the response contains an empty JSON object,
   * `{}`. For an example, see [List
   * messages](https://developers.google.com/workspace/chat/api/guides/v1/messages/list).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String parent = SpaceName.of("[SPACE]").toString();
   *   for (Message element : chatServiceClient.listMessages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the space to list messages from.
   *     <p>Format: `spaces/{space}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessagesPagedResponse listMessages(String parent) {
    ListMessagesRequest request = ListMessagesRequest.newBuilder().setParent(parent).build();
    return listMessages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists messages in a space that the caller is a member of, including messages from blocked
   * members and spaces. If you list messages from a space with no messages, the response is an
   * empty object. When using a REST/HTTP interface, the response contains an empty JSON object,
   * `{}`. For an example, see [List
   * messages](https://developers.google.com/workspace/chat/api/guides/v1/messages/list).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListMessagesRequest request =
   *       ListMessagesRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   for (Message element : chatServiceClient.listMessages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMessagesPagedResponse listMessages(ListMessagesRequest request) {
    return listMessagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists messages in a space that the caller is a member of, including messages from blocked
   * members and spaces. If you list messages from a space with no messages, the response is an
   * empty object. When using a REST/HTTP interface, the response contains an empty JSON object,
   * `{}`. For an example, see [List
   * messages](https://developers.google.com/workspace/chat/api/guides/v1/messages/list).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListMessagesRequest request =
   *       ListMessagesRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Message> future = chatServiceClient.listMessagesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Message element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse>
      listMessagesPagedCallable() {
    return stub.listMessagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists messages in a space that the caller is a member of, including messages from blocked
   * members and spaces. If you list messages from a space with no messages, the response is an
   * empty object. When using a REST/HTTP interface, the response contains an empty JSON object,
   * `{}`. For an example, see [List
   * messages](https://developers.google.com/workspace/chat/api/guides/v1/messages/list).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListMessagesRequest request =
   *       ListMessagesRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListMessagesResponse response = chatServiceClient.listMessagesCallable().call(request);
   *     for (Message element : response.getMessagesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable() {
    return stub.listMessagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists memberships in a space. For an example, see [List users and Google Chat apps in a
   * space](https://developers.google.com/workspace/chat/list-members). Listing memberships with
   * [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * lists memberships in spaces that the Chat app has access to, but excludes Chat app memberships,
   * including its own. Listing memberships with [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * lists memberships in spaces that the authenticated user has access to.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SpaceName parent = SpaceName.of("[SPACE]");
   *   for (Membership element : chatServiceClient.listMemberships(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the space for which to fetch a membership list.
   *     <p>Format: spaces/{space}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipsPagedResponse listMemberships(SpaceName parent) {
    ListMembershipsRequest request =
        ListMembershipsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMemberships(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists memberships in a space. For an example, see [List users and Google Chat apps in a
   * space](https://developers.google.com/workspace/chat/list-members). Listing memberships with
   * [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * lists memberships in spaces that the Chat app has access to, but excludes Chat app memberships,
   * including its own. Listing memberships with [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * lists memberships in spaces that the authenticated user has access to.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String parent = SpaceName.of("[SPACE]").toString();
   *   for (Membership element : chatServiceClient.listMemberships(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the space for which to fetch a membership list.
   *     <p>Format: spaces/{space}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipsPagedResponse listMemberships(String parent) {
    ListMembershipsRequest request = ListMembershipsRequest.newBuilder().setParent(parent).build();
    return listMemberships(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists memberships in a space. For an example, see [List users and Google Chat apps in a
   * space](https://developers.google.com/workspace/chat/list-members). Listing memberships with
   * [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * lists memberships in spaces that the Chat app has access to, but excludes Chat app memberships,
   * including its own. Listing memberships with [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * lists memberships in spaces that the authenticated user has access to.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setShowGroups(true)
   *           .setShowInvited(true)
   *           .setUseAdminAccess(true)
   *           .build();
   *   for (Membership element : chatServiceClient.listMemberships(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMembershipsPagedResponse listMemberships(ListMembershipsRequest request) {
    return listMembershipsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists memberships in a space. For an example, see [List users and Google Chat apps in a
   * space](https://developers.google.com/workspace/chat/list-members). Listing memberships with
   * [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * lists memberships in spaces that the Chat app has access to, but excludes Chat app memberships,
   * including its own. Listing memberships with [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * lists memberships in spaces that the authenticated user has access to.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setShowGroups(true)
   *           .setShowInvited(true)
   *           .setUseAdminAccess(true)
   *           .build();
   *   ApiFuture<Membership> future =
   *       chatServiceClient.listMembershipsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Membership element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable() {
    return stub.listMembershipsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists memberships in a space. For an example, see [List users and Google Chat apps in a
   * space](https://developers.google.com/workspace/chat/list-members). Listing memberships with
   * [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * lists memberships in spaces that the Chat app has access to, but excludes Chat app memberships,
   * including its own. Listing memberships with [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * lists memberships in spaces that the authenticated user has access to.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListMembershipsRequest request =
   *       ListMembershipsRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setShowGroups(true)
   *           .setShowInvited(true)
   *           .setUseAdminAccess(true)
   *           .build();
   *   while (true) {
   *     ListMembershipsResponse response =
   *         chatServiceClient.listMembershipsCallable().call(request);
   *     for (Membership element : response.getMembershipsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsCallable() {
    return stub.listMembershipsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a membership. For an example, see [Get details about a user's or Google
   * Chat app's membership](https://developers.google.com/workspace/chat/get-members).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   MembershipName name = MembershipName.of("[SPACE]", "[MEMBER]");
   *   Membership response = chatServiceClient.getMembership(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the membership to retrieve.
   *     <p>To get the app's own membership [by using user
   *     authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user),
   *     you can optionally use `spaces/{space}/members/app`.
   *     <p>Format: `spaces/{space}/members/{member}` or `spaces/{space}/members/app`
   *     <p>You can use the user's email as an alias for `{member}`. For example,
   *     `spaces/{space}/members/example{@literal @}gmail.com` where `example{@literal @}gmail.com`
   *     is the email of the Google Chat user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership getMembership(MembershipName name) {
    GetMembershipRequest request =
        GetMembershipRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMembership(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a membership. For an example, see [Get details about a user's or Google
   * Chat app's membership](https://developers.google.com/workspace/chat/get-members).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String name = MembershipName.of("[SPACE]", "[MEMBER]").toString();
   *   Membership response = chatServiceClient.getMembership(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the membership to retrieve.
   *     <p>To get the app's own membership [by using user
   *     authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user),
   *     you can optionally use `spaces/{space}/members/app`.
   *     <p>Format: `spaces/{space}/members/{member}` or `spaces/{space}/members/app`
   *     <p>You can use the user's email as an alias for `{member}`. For example,
   *     `spaces/{space}/members/example{@literal @}gmail.com` where `example{@literal @}gmail.com`
   *     is the email of the Google Chat user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership getMembership(String name) {
    GetMembershipRequest request = GetMembershipRequest.newBuilder().setName(name).build();
    return getMembership(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a membership. For an example, see [Get details about a user's or Google
   * Chat app's membership](https://developers.google.com/workspace/chat/get-members).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetMembershipRequest request =
   *       GetMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[SPACE]", "[MEMBER]").toString())
   *           .setUseAdminAccess(true)
   *           .build();
   *   Membership response = chatServiceClient.getMembership(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership getMembership(GetMembershipRequest request) {
    return getMembershipCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a membership. For an example, see [Get details about a user's or Google
   * Chat app's membership](https://developers.google.com/workspace/chat/get-members).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetMembershipRequest request =
   *       GetMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[SPACE]", "[MEMBER]").toString())
   *           .setUseAdminAccess(true)
   *           .build();
   *   ApiFuture<Membership> future = chatServiceClient.getMembershipCallable().futureCall(request);
   *   // Do something.
   *   Membership response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    return stub.getMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a message. For an example, see [Get details about a
   * message](https://developers.google.com/workspace/chat/get-messages).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>Note: Might return a message from a blocked member or space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   MessageName name = MessageName.of("[SPACE]", "[MESSAGE]");
   *   Message response = chatServiceClient.getMessage(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the message.
   *     <p>Format: `spaces/{space}/messages/{message}`
   *     <p>If you've set a custom ID for your message, you can use the value from the
   *     `clientAssignedMessageId` field for `{message}`. For details, see [Name a message]
   *     (https://developers.google.com/workspace/chat/create-messages#name_a_created_message).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Message getMessage(MessageName name) {
    GetMessageRequest request =
        GetMessageRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMessage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a message. For an example, see [Get details about a
   * message](https://developers.google.com/workspace/chat/get-messages).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>Note: Might return a message from a blocked member or space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String name = MessageName.of("[SPACE]", "[MESSAGE]").toString();
   *   Message response = chatServiceClient.getMessage(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the message.
   *     <p>Format: `spaces/{space}/messages/{message}`
   *     <p>If you've set a custom ID for your message, you can use the value from the
   *     `clientAssignedMessageId` field for `{message}`. For details, see [Name a message]
   *     (https://developers.google.com/workspace/chat/create-messages#name_a_created_message).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Message getMessage(String name) {
    GetMessageRequest request = GetMessageRequest.newBuilder().setName(name).build();
    return getMessage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a message. For an example, see [Get details about a
   * message](https://developers.google.com/workspace/chat/get-messages).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>Note: Might return a message from a blocked member or space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetMessageRequest request =
   *       GetMessageRequest.newBuilder()
   *           .setName(MessageName.of("[SPACE]", "[MESSAGE]").toString())
   *           .build();
   *   Message response = chatServiceClient.getMessage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Message getMessage(GetMessageRequest request) {
    return getMessageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a message. For an example, see [Get details about a
   * message](https://developers.google.com/workspace/chat/get-messages).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>Note: Might return a message from a blocked member or space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetMessageRequest request =
   *       GetMessageRequest.newBuilder()
   *           .setName(MessageName.of("[SPACE]", "[MESSAGE]").toString())
   *           .build();
   *   ApiFuture<Message> future = chatServiceClient.getMessageCallable().futureCall(request);
   *   // Do something.
   *   Message response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMessageRequest, Message> getMessageCallable() {
    return stub.getMessageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a message. There's a difference between the `patch` and `update` methods. The `patch`
   * method uses a `patch` request while the `update` method uses a `put` request. We recommend
   * using the `patch` method. For an example, see [Update a
   * message](https://developers.google.com/workspace/chat/update-messages).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>When using app authentication, requests can only update messages created by the calling Chat
   * app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   Message message = Message.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Message response = chatServiceClient.updateMessage(message, updateMask);
   * }
   * }</pre>
   *
   * @param message Required. Message with fields updated.
   * @param updateMask Required. The field paths to update. Separate multiple values with commas or
   *     use `&#42;` to update all field paths.
   *     <p>Currently supported field paths:
   *     <p>- `text`
   *     <p>- `attachment`
   *     <p>- `cards` (Requires [app authentication](/chat/api/guides/auth/service-accounts).)
   *     <p>- `cards_v2` (Requires [app authentication](/chat/api/guides/auth/service-accounts).)
   *     <p>- `accessory_widgets` (Requires [app
   *     authentication](/chat/api/guides/auth/service-accounts).)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Message updateMessage(Message message, FieldMask updateMask) {
    UpdateMessageRequest request =
        UpdateMessageRequest.newBuilder().setMessage(message).setUpdateMask(updateMask).build();
    return updateMessage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a message. There's a difference between the `patch` and `update` methods. The `patch`
   * method uses a `patch` request while the `update` method uses a `put` request. We recommend
   * using the `patch` method. For an example, see [Update a
   * message](https://developers.google.com/workspace/chat/update-messages).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>When using app authentication, requests can only update messages created by the calling Chat
   * app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   UpdateMessageRequest request =
   *       UpdateMessageRequest.newBuilder()
   *           .setMessage(Message.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   Message response = chatServiceClient.updateMessage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Message updateMessage(UpdateMessageRequest request) {
    return updateMessageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a message. There's a difference between the `patch` and `update` methods. The `patch`
   * method uses a `patch` request while the `update` method uses a `put` request. We recommend
   * using the `patch` method. For an example, see [Update a
   * message](https://developers.google.com/workspace/chat/update-messages).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>When using app authentication, requests can only update messages created by the calling Chat
   * app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   UpdateMessageRequest request =
   *       UpdateMessageRequest.newBuilder()
   *           .setMessage(Message.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Message> future = chatServiceClient.updateMessageCallable().futureCall(request);
   *   // Do something.
   *   Message response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMessageRequest, Message> updateMessageCallable() {
    return stub.updateMessageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a message. For an example, see [Delete a
   * message](https://developers.google.com/workspace/chat/delete-messages).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>When using app authentication, requests can only delete messages created by the calling Chat
   * app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   MessageName name = MessageName.of("[SPACE]", "[MESSAGE]");
   *   chatServiceClient.deleteMessage(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the message.
   *     <p>Format: `spaces/{space}/messages/{message}`
   *     <p>If you've set a custom ID for your message, you can use the value from the
   *     `clientAssignedMessageId` field for `{message}`. For details, see [Name a message]
   *     (https://developers.google.com/workspace/chat/create-messages#name_a_created_message).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMessage(MessageName name) {
    DeleteMessageRequest request =
        DeleteMessageRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteMessage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a message. For an example, see [Delete a
   * message](https://developers.google.com/workspace/chat/delete-messages).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>When using app authentication, requests can only delete messages created by the calling Chat
   * app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String name = MessageName.of("[SPACE]", "[MESSAGE]").toString();
   *   chatServiceClient.deleteMessage(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the message.
   *     <p>Format: `spaces/{space}/messages/{message}`
   *     <p>If you've set a custom ID for your message, you can use the value from the
   *     `clientAssignedMessageId` field for `{message}`. For details, see [Name a message]
   *     (https://developers.google.com/workspace/chat/create-messages#name_a_created_message).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMessage(String name) {
    DeleteMessageRequest request = DeleteMessageRequest.newBuilder().setName(name).build();
    deleteMessage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a message. For an example, see [Delete a
   * message](https://developers.google.com/workspace/chat/delete-messages).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>When using app authentication, requests can only delete messages created by the calling Chat
   * app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   DeleteMessageRequest request =
   *       DeleteMessageRequest.newBuilder()
   *           .setName(MessageName.of("[SPACE]", "[MESSAGE]").toString())
   *           .setForce(true)
   *           .build();
   *   chatServiceClient.deleteMessage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMessage(DeleteMessageRequest request) {
    deleteMessageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a message. For an example, see [Delete a
   * message](https://developers.google.com/workspace/chat/delete-messages).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>When using app authentication, requests can only delete messages created by the calling Chat
   * app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   DeleteMessageRequest request =
   *       DeleteMessageRequest.newBuilder()
   *           .setName(MessageName.of("[SPACE]", "[MESSAGE]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = chatServiceClient.deleteMessageCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMessageRequest, Empty> deleteMessageCallable() {
    return stub.deleteMessageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata of a message attachment. The attachment data is fetched using the [media
   * API](https://developers.google.com/workspace/chat/api/reference/rest/v1/media/download). For an
   * example, see [Get metadata about a message
   * attachment](https://developers.google.com/workspace/chat/get-media-attachments). Requires [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   AttachmentName name = AttachmentName.of("[SPACE]", "[MESSAGE]", "[ATTACHMENT]");
   *   Attachment response = chatServiceClient.getAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the attachment, in the form
   *     `spaces/{space}/messages/{message}/attachments/{attachment}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attachment getAttachment(AttachmentName name) {
    GetAttachmentRequest request =
        GetAttachmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata of a message attachment. The attachment data is fetched using the [media
   * API](https://developers.google.com/workspace/chat/api/reference/rest/v1/media/download). For an
   * example, see [Get metadata about a message
   * attachment](https://developers.google.com/workspace/chat/get-media-attachments). Requires [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String name = AttachmentName.of("[SPACE]", "[MESSAGE]", "[ATTACHMENT]").toString();
   *   Attachment response = chatServiceClient.getAttachment(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the attachment, in the form
   *     `spaces/{space}/messages/{message}/attachments/{attachment}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attachment getAttachment(String name) {
    GetAttachmentRequest request = GetAttachmentRequest.newBuilder().setName(name).build();
    return getAttachment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata of a message attachment. The attachment data is fetched using the [media
   * API](https://developers.google.com/workspace/chat/api/reference/rest/v1/media/download). For an
   * example, see [Get metadata about a message
   * attachment](https://developers.google.com/workspace/chat/get-media-attachments). Requires [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetAttachmentRequest request =
   *       GetAttachmentRequest.newBuilder()
   *           .setName(AttachmentName.of("[SPACE]", "[MESSAGE]", "[ATTACHMENT]").toString())
   *           .build();
   *   Attachment response = chatServiceClient.getAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Attachment getAttachment(GetAttachmentRequest request) {
    return getAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata of a message attachment. The attachment data is fetched using the [media
   * API](https://developers.google.com/workspace/chat/api/reference/rest/v1/media/download). For an
   * example, see [Get metadata about a message
   * attachment](https://developers.google.com/workspace/chat/get-media-attachments). Requires [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetAttachmentRequest request =
   *       GetAttachmentRequest.newBuilder()
   *           .setName(AttachmentName.of("[SPACE]", "[MESSAGE]", "[ATTACHMENT]").toString())
   *           .build();
   *   ApiFuture<Attachment> future = chatServiceClient.getAttachmentCallable().futureCall(request);
   *   // Do something.
   *   Attachment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAttachmentRequest, Attachment> getAttachmentCallable() {
    return stub.getAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads an attachment. For an example, see [Upload media as a file
   * attachment](https://developers.google.com/workspace/chat/upload-media-attachments).
   *
   * <p>Requires user
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>You can upload attachments up to 200 MB. Certain file types aren't supported. For details,
   * see [File types blocked by Google
   * Chat](https://support.google.com/chat/answer/7651457?&amp;co=GENIE.Platform%3DDesktop#File%20types%20blocked%20in%20Google%20Chat).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   UploadAttachmentRequest request =
   *       UploadAttachmentRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setFilename("filename-734768633")
   *           .build();
   *   UploadAttachmentResponse response = chatServiceClient.uploadAttachment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadAttachmentResponse uploadAttachment(UploadAttachmentRequest request) {
    return uploadAttachmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads an attachment. For an example, see [Upload media as a file
   * attachment](https://developers.google.com/workspace/chat/upload-media-attachments).
   *
   * <p>Requires user
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>You can upload attachments up to 200 MB. Certain file types aren't supported. For details,
   * see [File types blocked by Google
   * Chat](https://support.google.com/chat/answer/7651457?&amp;co=GENIE.Platform%3DDesktop#File%20types%20blocked%20in%20Google%20Chat).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   UploadAttachmentRequest request =
   *       UploadAttachmentRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setFilename("filename-734768633")
   *           .build();
   *   ApiFuture<UploadAttachmentResponse> future =
   *       chatServiceClient.uploadAttachmentCallable().futureCall(request);
   *   // Do something.
   *   UploadAttachmentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UploadAttachmentRequest, UploadAttachmentResponse>
      uploadAttachmentCallable() {
    return stub.uploadAttachmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists spaces the caller is a member of. Group chats and DMs aren't listed until the first
   * message is sent. For an example, see [List
   * spaces](https://developers.google.com/workspace/chat/list-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>To list all named spaces by Google Workspace organization, use the
   * [`spaces.search()`](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces/search)
   * method using Workspace administrator privileges instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   for (Space element : chatServiceClient.listSpaces().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpacesPagedResponse listSpaces() {
    ListSpacesRequest request = ListSpacesRequest.newBuilder().build();
    return listSpaces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists spaces the caller is a member of. Group chats and DMs aren't listed until the first
   * message is sent. For an example, see [List
   * spaces](https://developers.google.com/workspace/chat/list-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>To list all named spaces by Google Workspace organization, use the
   * [`spaces.search()`](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces/search)
   * method using Workspace administrator privileges instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListSpacesRequest request =
   *       ListSpacesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Space element : chatServiceClient.listSpaces(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpacesPagedResponse listSpaces(ListSpacesRequest request) {
    return listSpacesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists spaces the caller is a member of. Group chats and DMs aren't listed until the first
   * message is sent. For an example, see [List
   * spaces](https://developers.google.com/workspace/chat/list-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>To list all named spaces by Google Workspace organization, use the
   * [`spaces.search()`](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces/search)
   * method using Workspace administrator privileges instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListSpacesRequest request =
   *       ListSpacesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Space> future = chatServiceClient.listSpacesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Space element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSpacesRequest, ListSpacesPagedResponse> listSpacesPagedCallable() {
    return stub.listSpacesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists spaces the caller is a member of. Group chats and DMs aren't listed until the first
   * message is sent. For an example, see [List
   * spaces](https://developers.google.com/workspace/chat/list-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>To list all named spaces by Google Workspace organization, use the
   * [`spaces.search()`](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces/search)
   * method using Workspace administrator privileges instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListSpacesRequest request =
   *       ListSpacesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListSpacesResponse response = chatServiceClient.listSpacesCallable().call(request);
   *     for (Space element : response.getSpacesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSpacesRequest, ListSpacesResponse> listSpacesCallable() {
    return stub.listSpacesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of spaces in a Google Workspace organization based on an administrator's search.
   *
   * <p>Requires [user authentication with administrator
   * privileges](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user#admin-privileges).
   * In the request, set `use_admin_access` to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   for (Space element : chatServiceClient.searchSpaces().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchSpacesPagedResponse searchSpaces() {
    SearchSpacesRequest request = SearchSpacesRequest.newBuilder().build();
    return searchSpaces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of spaces in a Google Workspace organization based on an administrator's search.
   *
   * <p>Requires [user authentication with administrator
   * privileges](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user#admin-privileges).
   * In the request, set `use_admin_access` to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SearchSpacesRequest request =
   *       SearchSpacesRequest.newBuilder()
   *           .setUseAdminAccess(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Space element : chatServiceClient.searchSpaces(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchSpacesPagedResponse searchSpaces(SearchSpacesRequest request) {
    return searchSpacesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of spaces in a Google Workspace organization based on an administrator's search.
   *
   * <p>Requires [user authentication with administrator
   * privileges](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user#admin-privileges).
   * In the request, set `use_admin_access` to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SearchSpacesRequest request =
   *       SearchSpacesRequest.newBuilder()
   *           .setUseAdminAccess(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Space> future = chatServiceClient.searchSpacesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Space element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchSpacesRequest, SearchSpacesPagedResponse>
      searchSpacesPagedCallable() {
    return stub.searchSpacesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of spaces in a Google Workspace organization based on an administrator's search.
   *
   * <p>Requires [user authentication with administrator
   * privileges](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user#admin-privileges).
   * In the request, set `use_admin_access` to `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SearchSpacesRequest request =
   *       SearchSpacesRequest.newBuilder()
   *           .setUseAdminAccess(true)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     SearchSpacesResponse response = chatServiceClient.searchSpacesCallable().call(request);
   *     for (Space element : response.getSpacesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchSpacesRequest, SearchSpacesResponse> searchSpacesCallable() {
    return stub.searchSpacesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a space. For an example, see [Get details about a
   * space](https://developers.google.com/workspace/chat/get-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SpaceName name = SpaceName.of("[SPACE]");
   *   Space response = chatServiceClient.getSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space, in the form `spaces/{space}`.
   *     <p>Format: `spaces/{space}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(SpaceName name) {
    GetSpaceRequest request =
        GetSpaceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a space. For an example, see [Get details about a
   * space](https://developers.google.com/workspace/chat/get-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String name = SpaceName.of("[SPACE]").toString();
   *   Space response = chatServiceClient.getSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space, in the form `spaces/{space}`.
   *     <p>Format: `spaces/{space}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(String name) {
    GetSpaceRequest request = GetSpaceRequest.newBuilder().setName(name).build();
    return getSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a space. For an example, see [Get details about a
   * space](https://developers.google.com/workspace/chat/get-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetSpaceRequest request =
   *       GetSpaceRequest.newBuilder()
   *           .setName(SpaceName.of("[SPACE]").toString())
   *           .setUseAdminAccess(true)
   *           .build();
   *   Space response = chatServiceClient.getSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(GetSpaceRequest request) {
    return getSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a space. For an example, see [Get details about a
   * space](https://developers.google.com/workspace/chat/get-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetSpaceRequest request =
   *       GetSpaceRequest.newBuilder()
   *           .setName(SpaceName.of("[SPACE]").toString())
   *           .setUseAdminAccess(true)
   *           .build();
   *   ApiFuture<Space> future = chatServiceClient.getSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    return stub.getSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space with no members. Can be used to create a named space, or a group chat in
   * `Import mode`. For an example, see [Create a
   * space](https://developers.google.com/workspace/chat/create-spaces).
   *
   * <p>If you receive the error message `ALREADY_EXISTS` when creating a space, try a different
   * `displayName`. An existing space within the Google Workspace organization might already use
   * this display name.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>When authenticating as an app, the `space.customer` field must be set in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   Space space = Space.newBuilder().build();
   *   Space response = chatServiceClient.createSpace(space);
   * }
   * }</pre>
   *
   * @param space Required. The `displayName` and `spaceType` fields must be populated. Only
   *     `SpaceType.SPACE` and `SpaceType.GROUP_CHAT` are supported. `SpaceType.GROUP_CHAT` can only
   *     be used if `importMode` is set to true.
   *     <p>If you receive the error message `ALREADY_EXISTS`, try a different `displayName`. An
   *     existing space within the Google Workspace organization might already use this display
   *     name.
   *     <p>The space `name` is assigned on the server so anything specified in this field will be
   *     ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space createSpace(Space space) {
    CreateSpaceRequest request = CreateSpaceRequest.newBuilder().setSpace(space).build();
    return createSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space with no members. Can be used to create a named space, or a group chat in
   * `Import mode`. For an example, see [Create a
   * space](https://developers.google.com/workspace/chat/create-spaces).
   *
   * <p>If you receive the error message `ALREADY_EXISTS` when creating a space, try a different
   * `displayName`. An existing space within the Google Workspace organization might already use
   * this display name.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>When authenticating as an app, the `space.customer` field must be set in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   CreateSpaceRequest request =
   *       CreateSpaceRequest.newBuilder()
   *           .setSpace(Space.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Space response = chatServiceClient.createSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space createSpace(CreateSpaceRequest request) {
    return createSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space with no members. Can be used to create a named space, or a group chat in
   * `Import mode`. For an example, see [Create a
   * space](https://developers.google.com/workspace/chat/create-spaces).
   *
   * <p>If you receive the error message `ALREADY_EXISTS` when creating a space, try a different
   * `displayName`. An existing space within the Google Workspace organization might already use
   * this display name.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>When authenticating as an app, the `space.customer` field must be set in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   CreateSpaceRequest request =
   *       CreateSpaceRequest.newBuilder()
   *           .setSpace(Space.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Space> future = chatServiceClient.createSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    return stub.createSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space and adds specified users to it. The calling user is automatically added to the
   * space, and shouldn't be specified as a membership in the request. For an example, see [Set up a
   * space with initial members](https://developers.google.com/workspace/chat/set-up-spaces).
   *
   * <p>To specify the human members to add, add memberships with the appropriate
   * `membership.member.name`. To add a human user, use `users/{user}`, where `{user}` can be the
   * email address for the user. For users in the same Workspace organization `{user}` can also be
   * the `id` for the person from the People API, or the `id` for the user in the Directory API. For
   * example, if the People API Person profile ID for `user{@literal @}example.com` is `123456789`,
   * you can add the user to the space by setting the `membership.member.name` to
   * `users/user{@literal @}example.com` or `users/123456789`.
   *
   * <p>To specify the Google groups to add, add memberships with the appropriate
   * `membership.group_member.name`. To add or invite a Google group, use `groups/{group}`, where
   * `{group}` is the `id` for the group from the Cloud Identity Groups API. For example, you can
   * use [Cloud Identity Groups lookup
   * API](https://cloud.google.com/identity/docs/reference/rest/v1/groups/lookup) to retrieve the ID
   * `123456789` for group email `group{@literal @}example.com`, then you can add the group to the
   * space by setting the `membership.group_member.name` to `groups/123456789`. Group email is not
   * supported, and Google groups can only be added as members in named spaces.
   *
   * <p>For a named space or group chat, if the caller blocks, or is blocked by some members, or
   * doesn't have permission to add some members, then those members aren't added to the created
   * space.
   *
   * <p>To create a direct message (DM) between the calling user and another human user, specify
   * exactly one membership to represent the human user. If one user blocks the other, the request
   * fails and the DM isn't created.
   *
   * <p>To create a DM between the calling user and the calling app, set `Space.singleUserBotDm` to
   * `true` and don't specify any memberships. You can only use this method to set up a DM with the
   * calling app. To add the calling app as a member of a space or an existing DM between two human
   * users, see [Invite or add a user or app to a
   * space](https://developers.google.com/workspace/chat/create-members).
   *
   * <p>If a DM already exists between two users, even when one user blocks the other at the time a
   * request is made, then the existing DM is returned.
   *
   * <p>Spaces with threaded replies aren't supported. If you receive the error message
   * `ALREADY_EXISTS` when setting up a space, try a different `displayName`. An existing space
   * within the Google Workspace organization might already use this display name.
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SetUpSpaceRequest request =
   *       SetUpSpaceRequest.newBuilder()
   *           .setSpace(Space.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .addAllMemberships(new ArrayList<Membership>())
   *           .build();
   *   Space response = chatServiceClient.setUpSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space setUpSpace(SetUpSpaceRequest request) {
    return setUpSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space and adds specified users to it. The calling user is automatically added to the
   * space, and shouldn't be specified as a membership in the request. For an example, see [Set up a
   * space with initial members](https://developers.google.com/workspace/chat/set-up-spaces).
   *
   * <p>To specify the human members to add, add memberships with the appropriate
   * `membership.member.name`. To add a human user, use `users/{user}`, where `{user}` can be the
   * email address for the user. For users in the same Workspace organization `{user}` can also be
   * the `id` for the person from the People API, or the `id` for the user in the Directory API. For
   * example, if the People API Person profile ID for `user{@literal @}example.com` is `123456789`,
   * you can add the user to the space by setting the `membership.member.name` to
   * `users/user{@literal @}example.com` or `users/123456789`.
   *
   * <p>To specify the Google groups to add, add memberships with the appropriate
   * `membership.group_member.name`. To add or invite a Google group, use `groups/{group}`, where
   * `{group}` is the `id` for the group from the Cloud Identity Groups API. For example, you can
   * use [Cloud Identity Groups lookup
   * API](https://cloud.google.com/identity/docs/reference/rest/v1/groups/lookup) to retrieve the ID
   * `123456789` for group email `group{@literal @}example.com`, then you can add the group to the
   * space by setting the `membership.group_member.name` to `groups/123456789`. Group email is not
   * supported, and Google groups can only be added as members in named spaces.
   *
   * <p>For a named space or group chat, if the caller blocks, or is blocked by some members, or
   * doesn't have permission to add some members, then those members aren't added to the created
   * space.
   *
   * <p>To create a direct message (DM) between the calling user and another human user, specify
   * exactly one membership to represent the human user. If one user blocks the other, the request
   * fails and the DM isn't created.
   *
   * <p>To create a DM between the calling user and the calling app, set `Space.singleUserBotDm` to
   * `true` and don't specify any memberships. You can only use this method to set up a DM with the
   * calling app. To add the calling app as a member of a space or an existing DM between two human
   * users, see [Invite or add a user or app to a
   * space](https://developers.google.com/workspace/chat/create-members).
   *
   * <p>If a DM already exists between two users, even when one user blocks the other at the time a
   * request is made, then the existing DM is returned.
   *
   * <p>Spaces with threaded replies aren't supported. If you receive the error message
   * `ALREADY_EXISTS` when setting up a space, try a different `displayName`. An existing space
   * within the Google Workspace organization might already use this display name.
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SetUpSpaceRequest request =
   *       SetUpSpaceRequest.newBuilder()
   *           .setSpace(Space.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .addAllMemberships(new ArrayList<Membership>())
   *           .build();
   *   ApiFuture<Space> future = chatServiceClient.setUpSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetUpSpaceRequest, Space> setUpSpaceCallable() {
    return stub.setUpSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a space. For an example, see [Update a
   * space](https://developers.google.com/workspace/chat/update-spaces).
   *
   * <p>If you're updating the `displayName` field and receive the error message `ALREADY_EXISTS`,
   * try a different display name.. An existing space within the Google Workspace organization might
   * already use this display name.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   Space space = Space.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Space response = chatServiceClient.updateSpace(space, updateMask);
   * }
   * }</pre>
   *
   * @param space Required. Space with fields to be updated. `Space.name` must be populated in the
   *     form of `spaces/{space}`. Only fields specified by `update_mask` are updated.
   * @param updateMask Required. The updated field paths, comma separated if there are multiple.
   *     <p>You can update the following fields for a space:
   *     <p>`space_details`: Updates the space's description. Supports up to 150 characters.
   *     <p>`display_name`: Only supports updating the display name for spaces where `spaceType`
   *     field is `SPACE`. If you receive the error message `ALREADY_EXISTS`, try a different value.
   *     An existing space within the Google Workspace organization might already use this display
   *     name.
   *     <p>`space_type`: Only supports changing a `GROUP_CHAT` space type to `SPACE`. Include
   *     `display_name` together with `space_type` in the update mask and ensure that the specified
   *     space has a non-empty display name and the `SPACE` space type. Including the `space_type`
   *     mask and the `SPACE` type in the specified space when updating the display name is optional
   *     if the existing space already has the `SPACE` type. Trying to update the space type in
   *     other ways results in an invalid argument error. `space_type` is not supported with
   *     `useAdminAccess`.
   *     <p>`space_history_state`: Updates [space history
   *     settings](https://support.google.com/chat/answer/7664687) by turning history on or off for
   *     the space. Only supported if history settings are enabled for the Google Workspace
   *     organization. To update the space history state, you must omit all other field masks in
   *     your request. `space_history_state` is not supported with `useAdminAccess`.
   *     <p>`access_settings.audience`: Updates the [access
   *     setting](https://support.google.com/chat/answer/11971020) of who can discover the space,
   *     join the space, and preview the messages in named space where `spaceType` field is `SPACE`.
   *     If the existing space has a target audience, you can remove the audience and restrict space
   *     access by omitting a value for this field mask. To update access settings for a space, the
   *     authenticating user must be a space manager and omit all other field masks in your request.
   *     You can't update this field if the space is in [import
   *     mode](https://developers.google.com/workspace/chat/import-data-overview). To learn more,
   *     see [Make a space discoverable to specific
   *     users](https://developers.google.com/workspace/chat/space-target-audience).
   *     `access_settings.audience` is not supported with `useAdminAccess`.
   *     <p>`permission_settings`: Supports changing the [permission
   *     settings](https://support.google.com/chat/answer/13340792) of a space. When updating
   *     permission settings, you can only specify `permissionSettings` field masks; you cannot
   *     update other field masks at the same time. `permissionSettings` is not supported with
   *     `useAdminAccess`. The supported field masks include:
   *     <p>- `permission_settings.manageMembersAndGroups` -
   *     `permission_settings.modifySpaceDetails` - `permission_settings.toggleHistory` -
   *     `permission_settings.useAtMentionAll` - `permission_settings.manageApps` -
   *     `permission_settings.manageWebhooks` - `permission_settings.replyMessages`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space updateSpace(Space space, FieldMask updateMask) {
    UpdateSpaceRequest request =
        UpdateSpaceRequest.newBuilder().setSpace(space).setUpdateMask(updateMask).build();
    return updateSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a space. For an example, see [Update a
   * space](https://developers.google.com/workspace/chat/update-spaces).
   *
   * <p>If you're updating the `displayName` field and receive the error message `ALREADY_EXISTS`,
   * try a different display name.. An existing space within the Google Workspace organization might
   * already use this display name.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   UpdateSpaceRequest request =
   *       UpdateSpaceRequest.newBuilder()
   *           .setSpace(Space.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setUseAdminAccess(true)
   *           .build();
   *   Space response = chatServiceClient.updateSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space updateSpace(UpdateSpaceRequest request) {
    return updateSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a space. For an example, see [Update a
   * space](https://developers.google.com/workspace/chat/update-spaces).
   *
   * <p>If you're updating the `displayName` field and receive the error message `ALREADY_EXISTS`,
   * try a different display name.. An existing space within the Google Workspace organization might
   * already use this display name.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   UpdateSpaceRequest request =
   *       UpdateSpaceRequest.newBuilder()
   *           .setSpace(Space.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setUseAdminAccess(true)
   *           .build();
   *   ApiFuture<Space> future = chatServiceClient.updateSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    return stub.updateSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a named space. Always performs a cascading delete, which means that the space's child
   * resources—like messages posted in the space and memberships in the space—are also deleted. For
   * an example, see [Delete a space](https://developers.google.com/workspace/chat/delete-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SpaceName name = SpaceName.of("[SPACE]");
   *   chatServiceClient.deleteSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space to delete.
   *     <p>Format: `spaces/{space}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSpace(SpaceName name) {
    DeleteSpaceRequest request =
        DeleteSpaceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a named space. Always performs a cascading delete, which means that the space's child
   * resources—like messages posted in the space and memberships in the space—are also deleted. For
   * an example, see [Delete a space](https://developers.google.com/workspace/chat/delete-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String name = SpaceName.of("[SPACE]").toString();
   *   chatServiceClient.deleteSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space to delete.
   *     <p>Format: `spaces/{space}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSpace(String name) {
    DeleteSpaceRequest request = DeleteSpaceRequest.newBuilder().setName(name).build();
    deleteSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a named space. Always performs a cascading delete, which means that the space's child
   * resources—like messages posted in the space and memberships in the space—are also deleted. For
   * an example, see [Delete a space](https://developers.google.com/workspace/chat/delete-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   DeleteSpaceRequest request =
   *       DeleteSpaceRequest.newBuilder()
   *           .setName(SpaceName.of("[SPACE]").toString())
   *           .setUseAdminAccess(true)
   *           .build();
   *   chatServiceClient.deleteSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSpace(DeleteSpaceRequest request) {
    deleteSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a named space. Always performs a cascading delete, which means that the space's child
   * resources—like messages posted in the space and memberships in the space—are also deleted. For
   * an example, see [Delete a space](https://developers.google.com/workspace/chat/delete-spaces).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   DeleteSpaceRequest request =
   *       DeleteSpaceRequest.newBuilder()
   *           .setName(SpaceName.of("[SPACE]").toString())
   *           .setUseAdminAccess(true)
   *           .build();
   *   ApiFuture<Empty> future = chatServiceClient.deleteSpaceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSpaceRequest, Empty> deleteSpaceCallable() {
    return stub.deleteSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Completes the [import process](https://developers.google.com/workspace/chat/import-data) for
   * the specified space and makes it visible to users.
   *
   * <p>Requires [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * and domain-wide delegation. For more information, see [Authorize Google Chat apps to import
   * data](https://developers.google.com/workspace/chat/authorize-import).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   CompleteImportSpaceRequest request =
   *       CompleteImportSpaceRequest.newBuilder()
   *           .setName(SpaceName.of("[SPACE]").toString())
   *           .build();
   *   CompleteImportSpaceResponse response = chatServiceClient.completeImportSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompleteImportSpaceResponse completeImportSpace(CompleteImportSpaceRequest request) {
    return completeImportSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Completes the [import process](https://developers.google.com/workspace/chat/import-data) for
   * the specified space and makes it visible to users.
   *
   * <p>Requires [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * and domain-wide delegation. For more information, see [Authorize Google Chat apps to import
   * data](https://developers.google.com/workspace/chat/authorize-import).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   CompleteImportSpaceRequest request =
   *       CompleteImportSpaceRequest.newBuilder()
   *           .setName(SpaceName.of("[SPACE]").toString())
   *           .build();
   *   ApiFuture<CompleteImportSpaceResponse> future =
   *       chatServiceClient.completeImportSpaceCallable().futureCall(request);
   *   // Do something.
   *   CompleteImportSpaceResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CompleteImportSpaceRequest, CompleteImportSpaceResponse>
      completeImportSpaceCallable() {
    return stub.completeImportSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the existing direct message with the specified user. If no direct message space is
   * found, returns a `404 NOT_FOUND` error. For an example, see [Find a direct
   * message](/chat/api/guides/v1/spaces/find-direct-message).
   *
   * <p>With [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app),
   * returns the direct message space between the specified user and the calling Chat app.
   *
   * <p>With [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user),
   * returns the direct message space between the specified user and the authenticated user.
   *
   * <p>// Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   FindDirectMessageRequest request =
   *       FindDirectMessageRequest.newBuilder().setName("name3373707").build();
   *   Space response = chatServiceClient.findDirectMessage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space findDirectMessage(FindDirectMessageRequest request) {
    return findDirectMessageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the existing direct message with the specified user. If no direct message space is
   * found, returns a `404 NOT_FOUND` error. For an example, see [Find a direct
   * message](/chat/api/guides/v1/spaces/find-direct-message).
   *
   * <p>With [app
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app),
   * returns the direct message space between the specified user and the calling Chat app.
   *
   * <p>With [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user),
   * returns the direct message space between the specified user and the authenticated user.
   *
   * <p>// Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   FindDirectMessageRequest request =
   *       FindDirectMessageRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Space> future = chatServiceClient.findDirectMessageCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FindDirectMessageRequest, Space> findDirectMessageCallable() {
    return stub.findDirectMessageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a membership for the calling Chat app, a user, or a Google Group. Creating memberships
   * for other Chat apps isn't supported. When creating a membership, if the specified member has
   * their auto-accept policy turned off, then they're invited, and must accept the space invitation
   * before joining. Otherwise, creating a membership adds the member directly to the specified
   * space.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>For example usage, see:
   *
   * <p>- [Invite or add a user to a
   * space](https://developers.google.com/workspace/chat/create-members#create-user-membership).
   *
   * <p>- [Invite or add a Google Group to a
   * space](https://developers.google.com/workspace/chat/create-members#create-group-membership).
   *
   * <p>- [Add the Chat app to a
   * space](https://developers.google.com/workspace/chat/create-members#create-membership-calling-api).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SpaceName parent = SpaceName.of("[SPACE]");
   *   Membership membership = Membership.newBuilder().build();
   *   Membership response = chatServiceClient.createMembership(parent, membership);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the space for which to create the membership.
   *     <p>Format: spaces/{space}
   * @param membership Required. The membership relation to create.
   *     <p>The `memberType` field must contain a user with the `user.name` and `user.type` fields
   *     populated. The server will assign a resource name and overwrite anything specified.
   *     <p>When a Chat app creates a membership relation for a human user, it must use certain
   *     authorization scopes and set specific values for certain fields:
   *     <p>- When [authenticating as a
   *     user](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user), the
   *     `chat.memberships` authorization scope is required.
   *     <p>- When [authenticating as an
   *     app](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app), the
   *     `chat.app.memberships` authorization scope is required. Authenticating as an app is
   *     available in [Developer Preview](https://developers.google.com/workspace/preview).
   *     <p>- Set `user.type` to `HUMAN`, and set `user.name` with format `users/{user}`, where
   *     `{user}` can be the email address for the user. For users in the same Workspace
   *     organization `{user}` can also be the `id` of the
   *     [person](https://developers.google.com/people/api/rest/v1/people) from the People API, or
   *     the `id` for the user in the Directory API. For example, if the People API Person profile
   *     ID for `user{@literal @}example.com` is `123456789`, you can add the user to the space by
   *     setting the `membership.member.name` to `users/user{@literal @}example.com` or
   *     `users/123456789`.
   *     <p>Inviting users external to the Workspace organization that owns the space requires [user
   *     authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *     <p>When a Chat app creates a membership relation for itself, it must [authenticate as a
   *     user](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) and
   *     use the `chat.memberships.app` scope, set `user.type` to `BOT`, and set `user.name` to
   *     `users/app`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership createMembership(SpaceName parent, Membership membership) {
    CreateMembershipRequest request =
        CreateMembershipRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMembership(membership)
            .build();
    return createMembership(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a membership for the calling Chat app, a user, or a Google Group. Creating memberships
   * for other Chat apps isn't supported. When creating a membership, if the specified member has
   * their auto-accept policy turned off, then they're invited, and must accept the space invitation
   * before joining. Otherwise, creating a membership adds the member directly to the specified
   * space.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>For example usage, see:
   *
   * <p>- [Invite or add a user to a
   * space](https://developers.google.com/workspace/chat/create-members#create-user-membership).
   *
   * <p>- [Invite or add a Google Group to a
   * space](https://developers.google.com/workspace/chat/create-members#create-group-membership).
   *
   * <p>- [Add the Chat app to a
   * space](https://developers.google.com/workspace/chat/create-members#create-membership-calling-api).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String parent = SpaceName.of("[SPACE]").toString();
   *   Membership membership = Membership.newBuilder().build();
   *   Membership response = chatServiceClient.createMembership(parent, membership);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the space for which to create the membership.
   *     <p>Format: spaces/{space}
   * @param membership Required. The membership relation to create.
   *     <p>The `memberType` field must contain a user with the `user.name` and `user.type` fields
   *     populated. The server will assign a resource name and overwrite anything specified.
   *     <p>When a Chat app creates a membership relation for a human user, it must use certain
   *     authorization scopes and set specific values for certain fields:
   *     <p>- When [authenticating as a
   *     user](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user), the
   *     `chat.memberships` authorization scope is required.
   *     <p>- When [authenticating as an
   *     app](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app), the
   *     `chat.app.memberships` authorization scope is required. Authenticating as an app is
   *     available in [Developer Preview](https://developers.google.com/workspace/preview).
   *     <p>- Set `user.type` to `HUMAN`, and set `user.name` with format `users/{user}`, where
   *     `{user}` can be the email address for the user. For users in the same Workspace
   *     organization `{user}` can also be the `id` of the
   *     [person](https://developers.google.com/people/api/rest/v1/people) from the People API, or
   *     the `id` for the user in the Directory API. For example, if the People API Person profile
   *     ID for `user{@literal @}example.com` is `123456789`, you can add the user to the space by
   *     setting the `membership.member.name` to `users/user{@literal @}example.com` or
   *     `users/123456789`.
   *     <p>Inviting users external to the Workspace organization that owns the space requires [user
   *     authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *     <p>When a Chat app creates a membership relation for itself, it must [authenticate as a
   *     user](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user) and
   *     use the `chat.memberships.app` scope, set `user.type` to `BOT`, and set `user.name` to
   *     `users/app`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership createMembership(String parent, Membership membership) {
    CreateMembershipRequest request =
        CreateMembershipRequest.newBuilder().setParent(parent).setMembership(membership).build();
    return createMembership(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a membership for the calling Chat app, a user, or a Google Group. Creating memberships
   * for other Chat apps isn't supported. When creating a membership, if the specified member has
   * their auto-accept policy turned off, then they're invited, and must accept the space invitation
   * before joining. Otherwise, creating a membership adds the member directly to the specified
   * space.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>For example usage, see:
   *
   * <p>- [Invite or add a user to a
   * space](https://developers.google.com/workspace/chat/create-members#create-user-membership).
   *
   * <p>- [Invite or add a Google Group to a
   * space](https://developers.google.com/workspace/chat/create-members#create-group-membership).
   *
   * <p>- [Add the Chat app to a
   * space](https://developers.google.com/workspace/chat/create-members#create-membership-calling-api).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   CreateMembershipRequest request =
   *       CreateMembershipRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setMembership(Membership.newBuilder().build())
   *           .setUseAdminAccess(true)
   *           .build();
   *   Membership response = chatServiceClient.createMembership(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership createMembership(CreateMembershipRequest request) {
    return createMembershipCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a membership for the calling Chat app, a user, or a Google Group. Creating memberships
   * for other Chat apps isn't supported. When creating a membership, if the specified member has
   * their auto-accept policy turned off, then they're invited, and must accept the space invitation
   * before joining. Otherwise, creating a membership adds the member directly to the specified
   * space.
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>For example usage, see:
   *
   * <p>- [Invite or add a user to a
   * space](https://developers.google.com/workspace/chat/create-members#create-user-membership).
   *
   * <p>- [Invite or add a Google Group to a
   * space](https://developers.google.com/workspace/chat/create-members#create-group-membership).
   *
   * <p>- [Add the Chat app to a
   * space](https://developers.google.com/workspace/chat/create-members#create-membership-calling-api).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   CreateMembershipRequest request =
   *       CreateMembershipRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setMembership(Membership.newBuilder().build())
   *           .setUseAdminAccess(true)
   *           .build();
   *   ApiFuture<Membership> future =
   *       chatServiceClient.createMembershipCallable().futureCall(request);
   *   // Do something.
   *   Membership response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMembershipRequest, Membership> createMembershipCallable() {
    return stub.createMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a membership. For an example, see [Update a user's membership in a
   * space](https://developers.google.com/workspace/chat/update-members).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   Membership membership = Membership.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Membership response = chatServiceClient.updateMembership(membership, updateMask);
   * }
   * }</pre>
   *
   * @param membership Required. The membership to update. Only fields specified by `update_mask`
   *     are updated.
   * @param updateMask Required. The field paths to update. Separate multiple values with commas or
   *     use `&#42;` to update all field paths.
   *     <p>Currently supported field paths:
   *     <p>- `role`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership updateMembership(Membership membership, FieldMask updateMask) {
    UpdateMembershipRequest request =
        UpdateMembershipRequest.newBuilder()
            .setMembership(membership)
            .setUpdateMask(updateMask)
            .build();
    return updateMembership(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a membership. For an example, see [Update a user's membership in a
   * space](https://developers.google.com/workspace/chat/update-members).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   UpdateMembershipRequest request =
   *       UpdateMembershipRequest.newBuilder()
   *           .setMembership(Membership.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setUseAdminAccess(true)
   *           .build();
   *   Membership response = chatServiceClient.updateMembership(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership updateMembership(UpdateMembershipRequest request) {
    return updateMembershipCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a membership. For an example, see [Update a user's membership in a
   * space](https://developers.google.com/workspace/chat/update-members).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   UpdateMembershipRequest request =
   *       UpdateMembershipRequest.newBuilder()
   *           .setMembership(Membership.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setUseAdminAccess(true)
   *           .build();
   *   ApiFuture<Membership> future =
   *       chatServiceClient.updateMembershipCallable().futureCall(request);
   *   // Do something.
   *   Membership response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMembershipRequest, Membership> updateMembershipCallable() {
    return stub.updateMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a membership. For an example, see [Remove a user or a Google Chat app from a
   * space](https://developers.google.com/workspace/chat/delete-members).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   MembershipName name = MembershipName.of("[SPACE]", "[MEMBER]");
   *   Membership response = chatServiceClient.deleteMembership(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the membership to delete. Chat apps can delete human
   *     users' or their own memberships. Chat apps can't delete other apps' memberships.
   *     <p>When deleting a human membership, requires the `chat.memberships` scope and
   *     `spaces/{space}/members/{member}` format. You can use the email as an alias for `{member}`.
   *     For example, `spaces/{space}/members/example{@literal @}gmail.com` where
   *     `example{@literal @}gmail.com` is the email of the Google Chat user.
   *     <p>When deleting an app membership, requires the `chat.memberships.app` scope and
   *     `spaces/{space}/members/app` format.
   *     <p>Format: `spaces/{space}/members/{member}` or `spaces/{space}/members/app`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership deleteMembership(MembershipName name) {
    DeleteMembershipRequest request =
        DeleteMembershipRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteMembership(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a membership. For an example, see [Remove a user or a Google Chat app from a
   * space](https://developers.google.com/workspace/chat/delete-members).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String name = MembershipName.of("[SPACE]", "[MEMBER]").toString();
   *   Membership response = chatServiceClient.deleteMembership(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the membership to delete. Chat apps can delete human
   *     users' or their own memberships. Chat apps can't delete other apps' memberships.
   *     <p>When deleting a human membership, requires the `chat.memberships` scope and
   *     `spaces/{space}/members/{member}` format. You can use the email as an alias for `{member}`.
   *     For example, `spaces/{space}/members/example{@literal @}gmail.com` where
   *     `example{@literal @}gmail.com` is the email of the Google Chat user.
   *     <p>When deleting an app membership, requires the `chat.memberships.app` scope and
   *     `spaces/{space}/members/app` format.
   *     <p>Format: `spaces/{space}/members/{member}` or `spaces/{space}/members/app`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership deleteMembership(String name) {
    DeleteMembershipRequest request = DeleteMembershipRequest.newBuilder().setName(name).build();
    return deleteMembership(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a membership. For an example, see [Remove a user or a Google Chat app from a
   * space](https://developers.google.com/workspace/chat/delete-members).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   DeleteMembershipRequest request =
   *       DeleteMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[SPACE]", "[MEMBER]").toString())
   *           .setUseAdminAccess(true)
   *           .build();
   *   Membership response = chatServiceClient.deleteMembership(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Membership deleteMembership(DeleteMembershipRequest request) {
    return deleteMembershipCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a membership. For an example, see [Remove a user or a Google Chat app from a
   * space](https://developers.google.com/workspace/chat/delete-members).
   *
   * <p>Supports the following types of
   * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize):
   *
   * <p>- [App
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
   * with [administrator approval](https://support.google.com/a?p=chat-app-auth) in [Developer
   * Preview](https://developers.google.com/workspace/preview)
   *
   * <p>- [User
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
   * You can authenticate and authorize this method with administrator privileges by setting the
   * `use_admin_access` field in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   DeleteMembershipRequest request =
   *       DeleteMembershipRequest.newBuilder()
   *           .setName(MembershipName.of("[SPACE]", "[MEMBER]").toString())
   *           .setUseAdminAccess(true)
   *           .build();
   *   ApiFuture<Membership> future =
   *       chatServiceClient.deleteMembershipCallable().futureCall(request);
   *   // Do something.
   *   Membership response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMembershipRequest, Membership> deleteMembershipCallable() {
    return stub.deleteMembershipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a reaction and adds it to a message. Only unicode emojis are supported. For an example,
   * see [Add a reaction to a
   * message](https://developers.google.com/workspace/chat/create-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   MessageName parent = MessageName.of("[SPACE]", "[MESSAGE]");
   *   Reaction reaction = Reaction.newBuilder().build();
   *   Reaction response = chatServiceClient.createReaction(parent, reaction);
   * }
   * }</pre>
   *
   * @param parent Required. The message where the reaction is created.
   *     <p>Format: `spaces/{space}/messages/{message}`
   * @param reaction Required. The reaction to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reaction createReaction(MessageName parent, Reaction reaction) {
    CreateReactionRequest request =
        CreateReactionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReaction(reaction)
            .build();
    return createReaction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a reaction and adds it to a message. Only unicode emojis are supported. For an example,
   * see [Add a reaction to a
   * message](https://developers.google.com/workspace/chat/create-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String parent = MessageName.of("[SPACE]", "[MESSAGE]").toString();
   *   Reaction reaction = Reaction.newBuilder().build();
   *   Reaction response = chatServiceClient.createReaction(parent, reaction);
   * }
   * }</pre>
   *
   * @param parent Required. The message where the reaction is created.
   *     <p>Format: `spaces/{space}/messages/{message}`
   * @param reaction Required. The reaction to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reaction createReaction(String parent, Reaction reaction) {
    CreateReactionRequest request =
        CreateReactionRequest.newBuilder().setParent(parent).setReaction(reaction).build();
    return createReaction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a reaction and adds it to a message. Only unicode emojis are supported. For an example,
   * see [Add a reaction to a
   * message](https://developers.google.com/workspace/chat/create-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   CreateReactionRequest request =
   *       CreateReactionRequest.newBuilder()
   *           .setParent(MessageName.of("[SPACE]", "[MESSAGE]").toString())
   *           .setReaction(Reaction.newBuilder().build())
   *           .build();
   *   Reaction response = chatServiceClient.createReaction(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reaction createReaction(CreateReactionRequest request) {
    return createReactionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a reaction and adds it to a message. Only unicode emojis are supported. For an example,
   * see [Add a reaction to a
   * message](https://developers.google.com/workspace/chat/create-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   CreateReactionRequest request =
   *       CreateReactionRequest.newBuilder()
   *           .setParent(MessageName.of("[SPACE]", "[MESSAGE]").toString())
   *           .setReaction(Reaction.newBuilder().build())
   *           .build();
   *   ApiFuture<Reaction> future = chatServiceClient.createReactionCallable().futureCall(request);
   *   // Do something.
   *   Reaction response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReactionRequest, Reaction> createReactionCallable() {
    return stub.createReactionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reactions to a message. For an example, see [List reactions for a
   * message](https://developers.google.com/workspace/chat/list-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   MessageName parent = MessageName.of("[SPACE]", "[MESSAGE]");
   *   for (Reaction element : chatServiceClient.listReactions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The message users reacted to.
   *     <p>Format: `spaces/{space}/messages/{message}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReactionsPagedResponse listReactions(MessageName parent) {
    ListReactionsRequest request =
        ListReactionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReactions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reactions to a message. For an example, see [List reactions for a
   * message](https://developers.google.com/workspace/chat/list-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String parent = MessageName.of("[SPACE]", "[MESSAGE]").toString();
   *   for (Reaction element : chatServiceClient.listReactions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The message users reacted to.
   *     <p>Format: `spaces/{space}/messages/{message}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReactionsPagedResponse listReactions(String parent) {
    ListReactionsRequest request = ListReactionsRequest.newBuilder().setParent(parent).build();
    return listReactions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reactions to a message. For an example, see [List reactions for a
   * message](https://developers.google.com/workspace/chat/list-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListReactionsRequest request =
   *       ListReactionsRequest.newBuilder()
   *           .setParent(MessageName.of("[SPACE]", "[MESSAGE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Reaction element : chatServiceClient.listReactions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReactionsPagedResponse listReactions(ListReactionsRequest request) {
    return listReactionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reactions to a message. For an example, see [List reactions for a
   * message](https://developers.google.com/workspace/chat/list-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListReactionsRequest request =
   *       ListReactionsRequest.newBuilder()
   *           .setParent(MessageName.of("[SPACE]", "[MESSAGE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Reaction> future =
   *       chatServiceClient.listReactionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Reaction element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReactionsRequest, ListReactionsPagedResponse>
      listReactionsPagedCallable() {
    return stub.listReactionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reactions to a message. For an example, see [List reactions for a
   * message](https://developers.google.com/workspace/chat/list-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListReactionsRequest request =
   *       ListReactionsRequest.newBuilder()
   *           .setParent(MessageName.of("[SPACE]", "[MESSAGE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListReactionsResponse response = chatServiceClient.listReactionsCallable().call(request);
   *     for (Reaction element : response.getReactionsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReactionsRequest, ListReactionsResponse> listReactionsCallable() {
    return stub.listReactionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reaction to a message. Only unicode emojis are supported. For an example, see [Delete
   * a reaction](https://developers.google.com/workspace/chat/delete-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ReactionName name = ReactionName.of("[SPACE]", "[MESSAGE]", "[REACTION]");
   *   chatServiceClient.deleteReaction(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the reaction to delete.
   *     <p>Format: `spaces/{space}/messages/{message}/reactions/{reaction}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReaction(ReactionName name) {
    DeleteReactionRequest request =
        DeleteReactionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteReaction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reaction to a message. Only unicode emojis are supported. For an example, see [Delete
   * a reaction](https://developers.google.com/workspace/chat/delete-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String name = ReactionName.of("[SPACE]", "[MESSAGE]", "[REACTION]").toString();
   *   chatServiceClient.deleteReaction(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the reaction to delete.
   *     <p>Format: `spaces/{space}/messages/{message}/reactions/{reaction}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReaction(String name) {
    DeleteReactionRequest request = DeleteReactionRequest.newBuilder().setName(name).build();
    deleteReaction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reaction to a message. Only unicode emojis are supported. For an example, see [Delete
   * a reaction](https://developers.google.com/workspace/chat/delete-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   DeleteReactionRequest request =
   *       DeleteReactionRequest.newBuilder()
   *           .setName(ReactionName.of("[SPACE]", "[MESSAGE]", "[REACTION]").toString())
   *           .build();
   *   chatServiceClient.deleteReaction(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReaction(DeleteReactionRequest request) {
    deleteReactionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reaction to a message. Only unicode emojis are supported. For an example, see [Delete
   * a reaction](https://developers.google.com/workspace/chat/delete-reactions).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   DeleteReactionRequest request =
   *       DeleteReactionRequest.newBuilder()
   *           .setName(ReactionName.of("[SPACE]", "[MESSAGE]", "[REACTION]").toString())
   *           .build();
   *   ApiFuture<Empty> future = chatServiceClient.deleteReactionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReactionRequest, Empty> deleteReactionCallable() {
    return stub.deleteReactionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a user's read state within a space, used to identify read and unread
   * messages. For an example, see [Get details about a user's space read
   * state](https://developers.google.com/workspace/chat/get-space-read-state).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SpaceReadStateName name = SpaceReadStateName.of("[USER]", "[SPACE]");
   *   SpaceReadState response = chatServiceClient.getSpaceReadState(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space read state to retrieve.
   *     <p>Only supports getting read state for the calling user.
   *     <p>To refer to the calling user, set one of the following:
   *     <p>- The `me` alias. For example, `users/me/spaces/{space}/spaceReadState`.
   *     <p>- Their Workspace email address. For example,
   *     `users/user{@literal @}example.com/spaces/{space}/spaceReadState`.
   *     <p>- Their user id. For example, `users/123456789/spaces/{space}/spaceReadState`.
   *     <p>Format: users/{user}/spaces/{space}/spaceReadState
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpaceReadState getSpaceReadState(SpaceReadStateName name) {
    GetSpaceReadStateRequest request =
        GetSpaceReadStateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSpaceReadState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a user's read state within a space, used to identify read and unread
   * messages. For an example, see [Get details about a user's space read
   * state](https://developers.google.com/workspace/chat/get-space-read-state).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String name = SpaceReadStateName.of("[USER]", "[SPACE]").toString();
   *   SpaceReadState response = chatServiceClient.getSpaceReadState(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space read state to retrieve.
   *     <p>Only supports getting read state for the calling user.
   *     <p>To refer to the calling user, set one of the following:
   *     <p>- The `me` alias. For example, `users/me/spaces/{space}/spaceReadState`.
   *     <p>- Their Workspace email address. For example,
   *     `users/user{@literal @}example.com/spaces/{space}/spaceReadState`.
   *     <p>- Their user id. For example, `users/123456789/spaces/{space}/spaceReadState`.
   *     <p>Format: users/{user}/spaces/{space}/spaceReadState
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpaceReadState getSpaceReadState(String name) {
    GetSpaceReadStateRequest request = GetSpaceReadStateRequest.newBuilder().setName(name).build();
    return getSpaceReadState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a user's read state within a space, used to identify read and unread
   * messages. For an example, see [Get details about a user's space read
   * state](https://developers.google.com/workspace/chat/get-space-read-state).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetSpaceReadStateRequest request =
   *       GetSpaceReadStateRequest.newBuilder()
   *           .setName(SpaceReadStateName.of("[USER]", "[SPACE]").toString())
   *           .build();
   *   SpaceReadState response = chatServiceClient.getSpaceReadState(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpaceReadState getSpaceReadState(GetSpaceReadStateRequest request) {
    return getSpaceReadStateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a user's read state within a space, used to identify read and unread
   * messages. For an example, see [Get details about a user's space read
   * state](https://developers.google.com/workspace/chat/get-space-read-state).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetSpaceReadStateRequest request =
   *       GetSpaceReadStateRequest.newBuilder()
   *           .setName(SpaceReadStateName.of("[USER]", "[SPACE]").toString())
   *           .build();
   *   ApiFuture<SpaceReadState> future =
   *       chatServiceClient.getSpaceReadStateCallable().futureCall(request);
   *   // Do something.
   *   SpaceReadState response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSpaceReadStateRequest, SpaceReadState> getSpaceReadStateCallable() {
    return stub.getSpaceReadStateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user's read state within a space, used to identify read and unread messages. For an
   * example, see [Update a user's space read
   * state](https://developers.google.com/workspace/chat/update-space-read-state).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SpaceReadState spaceReadState = SpaceReadState.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SpaceReadState response = chatServiceClient.updateSpaceReadState(spaceReadState, updateMask);
   * }
   * }</pre>
   *
   * @param spaceReadState Required. The space read state and fields to update.
   *     <p>Only supports updating read state for the calling user.
   *     <p>To refer to the calling user, set one of the following:
   *     <p>- The `me` alias. For example, `users/me/spaces/{space}/spaceReadState`.
   *     <p>- Their Workspace email address. For example,
   *     `users/user{@literal @}example.com/spaces/{space}/spaceReadState`.
   *     <p>- Their user id. For example, `users/123456789/spaces/{space}/spaceReadState`.
   *     <p>Format: users/{user}/spaces/{space}/spaceReadState
   * @param updateMask Required. The field paths to update. Currently supported field paths:
   *     <p>- `last_read_time`
   *     <p>When the `last_read_time` is before the latest message create time, the space appears as
   *     unread in the UI.
   *     <p>To mark the space as read, set `last_read_time` to any value later (larger) than the
   *     latest message create time. The `last_read_time` is coerced to match the latest message
   *     create time. Note that the space read state only affects the read state of messages that
   *     are visible in the space's top-level conversation. Replies in threads are unaffected by
   *     this timestamp, and instead rely on the thread read state.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpaceReadState updateSpaceReadState(
      SpaceReadState spaceReadState, FieldMask updateMask) {
    UpdateSpaceReadStateRequest request =
        UpdateSpaceReadStateRequest.newBuilder()
            .setSpaceReadState(spaceReadState)
            .setUpdateMask(updateMask)
            .build();
    return updateSpaceReadState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user's read state within a space, used to identify read and unread messages. For an
   * example, see [Update a user's space read
   * state](https://developers.google.com/workspace/chat/update-space-read-state).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   UpdateSpaceReadStateRequest request =
   *       UpdateSpaceReadStateRequest.newBuilder()
   *           .setSpaceReadState(SpaceReadState.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SpaceReadState response = chatServiceClient.updateSpaceReadState(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpaceReadState updateSpaceReadState(UpdateSpaceReadStateRequest request) {
    return updateSpaceReadStateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user's read state within a space, used to identify read and unread messages. For an
   * example, see [Update a user's space read
   * state](https://developers.google.com/workspace/chat/update-space-read-state).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   UpdateSpaceReadStateRequest request =
   *       UpdateSpaceReadStateRequest.newBuilder()
   *           .setSpaceReadState(SpaceReadState.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SpaceReadState> future =
   *       chatServiceClient.updateSpaceReadStateCallable().futureCall(request);
   *   // Do something.
   *   SpaceReadState response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSpaceReadStateRequest, SpaceReadState>
      updateSpaceReadStateCallable() {
    return stub.updateSpaceReadStateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a user's read state within a thread, used to identify read and unread
   * messages. For an example, see [Get details about a user's thread read
   * state](https://developers.google.com/workspace/chat/get-thread-read-state).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ThreadReadStateName name = ThreadReadStateName.of("[USER]", "[SPACE]", "[THREAD]");
   *   ThreadReadState response = chatServiceClient.getThreadReadState(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the thread read state to retrieve.
   *     <p>Only supports getting read state for the calling user.
   *     <p>To refer to the calling user, set one of the following:
   *     <p>- The `me` alias. For example,
   *     `users/me/spaces/{space}/threads/{thread}/threadReadState`.
   *     <p>- Their Workspace email address. For example,
   *     `users/user{@literal @}example.com/spaces/{space}/threads/{thread}/threadReadState`.
   *     <p>- Their user id. For example,
   *     `users/123456789/spaces/{space}/threads/{thread}/threadReadState`.
   *     <p>Format: users/{user}/spaces/{space}/threads/{thread}/threadReadState
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ThreadReadState getThreadReadState(ThreadReadStateName name) {
    GetThreadReadStateRequest request =
        GetThreadReadStateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getThreadReadState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a user's read state within a thread, used to identify read and unread
   * messages. For an example, see [Get details about a user's thread read
   * state](https://developers.google.com/workspace/chat/get-thread-read-state).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String name = ThreadReadStateName.of("[USER]", "[SPACE]", "[THREAD]").toString();
   *   ThreadReadState response = chatServiceClient.getThreadReadState(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the thread read state to retrieve.
   *     <p>Only supports getting read state for the calling user.
   *     <p>To refer to the calling user, set one of the following:
   *     <p>- The `me` alias. For example,
   *     `users/me/spaces/{space}/threads/{thread}/threadReadState`.
   *     <p>- Their Workspace email address. For example,
   *     `users/user{@literal @}example.com/spaces/{space}/threads/{thread}/threadReadState`.
   *     <p>- Their user id. For example,
   *     `users/123456789/spaces/{space}/threads/{thread}/threadReadState`.
   *     <p>Format: users/{user}/spaces/{space}/threads/{thread}/threadReadState
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ThreadReadState getThreadReadState(String name) {
    GetThreadReadStateRequest request =
        GetThreadReadStateRequest.newBuilder().setName(name).build();
    return getThreadReadState(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a user's read state within a thread, used to identify read and unread
   * messages. For an example, see [Get details about a user's thread read
   * state](https://developers.google.com/workspace/chat/get-thread-read-state).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetThreadReadStateRequest request =
   *       GetThreadReadStateRequest.newBuilder()
   *           .setName(ThreadReadStateName.of("[USER]", "[SPACE]", "[THREAD]").toString())
   *           .build();
   *   ThreadReadState response = chatServiceClient.getThreadReadState(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ThreadReadState getThreadReadState(GetThreadReadStateRequest request) {
    return getThreadReadStateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns details about a user's read state within a thread, used to identify read and unread
   * messages. For an example, see [Get details about a user's thread read
   * state](https://developers.google.com/workspace/chat/get-thread-read-state).
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetThreadReadStateRequest request =
   *       GetThreadReadStateRequest.newBuilder()
   *           .setName(ThreadReadStateName.of("[USER]", "[SPACE]", "[THREAD]").toString())
   *           .build();
   *   ApiFuture<ThreadReadState> future =
   *       chatServiceClient.getThreadReadStateCallable().futureCall(request);
   *   // Do something.
   *   ThreadReadState response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetThreadReadStateRequest, ThreadReadState>
      getThreadReadStateCallable() {
    return stub.getThreadReadStateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns an event from a Google Chat space. The [event
   * payload](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.oneof_payload)
   * contains the most recent version of the resource that changed. For example, if you request an
   * event about a new message but the message was later updated, the server returns the updated
   * `Message` resource in the event payload.
   *
   * <p>Note: The `permissionSettings` field is not returned in the Space object of the Space event
   * data for this request.
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   * To get an event, the authenticated user must be a member of the space.
   *
   * <p>For an example, see [Get details about an event from a Google Chat
   * space](https://developers.google.com/workspace/chat/get-space-event).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SpaceEventName name = SpaceEventName.of("[SPACE]", "[SPACE_EVENT]");
   *   SpaceEvent response = chatServiceClient.getSpaceEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the space event.
   *     <p>Format: `spaces/{space}/spaceEvents/{spaceEvent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpaceEvent getSpaceEvent(SpaceEventName name) {
    GetSpaceEventRequest request =
        GetSpaceEventRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSpaceEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns an event from a Google Chat space. The [event
   * payload](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.oneof_payload)
   * contains the most recent version of the resource that changed. For example, if you request an
   * event about a new message but the message was later updated, the server returns the updated
   * `Message` resource in the event payload.
   *
   * <p>Note: The `permissionSettings` field is not returned in the Space object of the Space event
   * data for this request.
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   * To get an event, the authenticated user must be a member of the space.
   *
   * <p>For an example, see [Get details about an event from a Google Chat
   * space](https://developers.google.com/workspace/chat/get-space-event).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String name = SpaceEventName.of("[SPACE]", "[SPACE_EVENT]").toString();
   *   SpaceEvent response = chatServiceClient.getSpaceEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the space event.
   *     <p>Format: `spaces/{space}/spaceEvents/{spaceEvent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpaceEvent getSpaceEvent(String name) {
    GetSpaceEventRequest request = GetSpaceEventRequest.newBuilder().setName(name).build();
    return getSpaceEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns an event from a Google Chat space. The [event
   * payload](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.oneof_payload)
   * contains the most recent version of the resource that changed. For example, if you request an
   * event about a new message but the message was later updated, the server returns the updated
   * `Message` resource in the event payload.
   *
   * <p>Note: The `permissionSettings` field is not returned in the Space object of the Space event
   * data for this request.
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   * To get an event, the authenticated user must be a member of the space.
   *
   * <p>For an example, see [Get details about an event from a Google Chat
   * space](https://developers.google.com/workspace/chat/get-space-event).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetSpaceEventRequest request =
   *       GetSpaceEventRequest.newBuilder()
   *           .setName(SpaceEventName.of("[SPACE]", "[SPACE_EVENT]").toString())
   *           .build();
   *   SpaceEvent response = chatServiceClient.getSpaceEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SpaceEvent getSpaceEvent(GetSpaceEventRequest request) {
    return getSpaceEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns an event from a Google Chat space. The [event
   * payload](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.oneof_payload)
   * contains the most recent version of the resource that changed. For example, if you request an
   * event about a new message but the message was later updated, the server returns the updated
   * `Message` resource in the event payload.
   *
   * <p>Note: The `permissionSettings` field is not returned in the Space object of the Space event
   * data for this request.
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   * To get an event, the authenticated user must be a member of the space.
   *
   * <p>For an example, see [Get details about an event from a Google Chat
   * space](https://developers.google.com/workspace/chat/get-space-event).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   GetSpaceEventRequest request =
   *       GetSpaceEventRequest.newBuilder()
   *           .setName(SpaceEventName.of("[SPACE]", "[SPACE_EVENT]").toString())
   *           .build();
   *   ApiFuture<SpaceEvent> future = chatServiceClient.getSpaceEventCallable().futureCall(request);
   *   // Do something.
   *   SpaceEvent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSpaceEventRequest, SpaceEvent> getSpaceEventCallable() {
    return stub.getSpaceEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists events from a Google Chat space. For each event, the
   * [payload](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.oneof_payload)
   * contains the most recent version of the Chat resource. For example, if you list events about
   * new space members, the server returns `Membership` resources that contain the latest membership
   * details. If new members were removed during the requested period, the event payload contains an
   * empty `Membership` resource.
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   * To list events, the authenticated user must be a member of the space.
   *
   * <p>For an example, see [List events from a Google Chat
   * space](https://developers.google.com/workspace/chat/list-space-events).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   SpaceName parent = SpaceName.of("[SPACE]");
   *   String filter = "filter-1274492040";
   *   for (SpaceEvent element : chatServiceClient.listSpaceEvents(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the [Google Chat
   *     space](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces) where the
   *     events occurred.
   *     <p>Format: `spaces/{space}`.
   * @param filter Required. A query filter.
   *     <p>You must specify at least one event type (`event_type`) using the has `:` operator. To
   *     filter by multiple event types, use the `OR` operator. Omit batch event types in your
   *     filter. The request automatically returns any related batch events. For example, if you
   *     filter by new reactions (`google.workspace.chat.reaction.v1.created`), the server also
   *     returns batch new reactions events (`google.workspace.chat.reaction.v1.batchCreated`). For
   *     a list of supported event types, see the [`SpaceEvents` reference
   *     documentation](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.event_type).
   *     <p>Optionally, you can also filter by start time (`start_time`) and end time (`end_time`):
   *     <ul>
   *       <li>`start_time`: Exclusive timestamp from which to start listing space events. You can
   *           list events that occurred up to 28 days ago. If unspecified, lists space events from
   *           the past 28 days.
   *       <li>`end_time`: Inclusive timestamp until which space events are listed. If unspecified,
   *           lists events up to the time of the request.
   *     </ul>
   *     <p>To specify a start or end time, use the equals `=` operator and format in
   *     [RFC-3339](https://www.rfc-editor.org/rfc/rfc3339). To filter by both `start_time` and
   *     `end_time`, use the `AND` operator.
   *     <p>For example, the following queries are valid:
   *     <p>``` start_time="2023-08-23T19:20:33+00:00" AND end_time="2023-08-23T19:21:54+00:00" ```
   *     ``` start_time="2023-08-23T19:20:33+00:00" AND
   *     (event_types:"google.workspace.chat.space.v1.updated" OR
   *     event_types:"google.workspace.chat.message.v1.created") ```
   *     <p>The following queries are invalid:
   *     <p>``` start_time="2023-08-23T19:20:33+00:00" OR end_time="2023-08-23T19:21:54+00:00" ```
   *     ``` event_types:"google.workspace.chat.space.v1.updated" AND
   *     event_types:"google.workspace.chat.message.v1.created" ```
   *     <p>Invalid queries are rejected by the server with an `INVALID_ARGUMENT` error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpaceEventsPagedResponse listSpaceEvents(SpaceName parent, String filter) {
    ListSpaceEventsRequest request =
        ListSpaceEventsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listSpaceEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists events from a Google Chat space. For each event, the
   * [payload](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.oneof_payload)
   * contains the most recent version of the Chat resource. For example, if you list events about
   * new space members, the server returns `Membership` resources that contain the latest membership
   * details. If new members were removed during the requested period, the event payload contains an
   * empty `Membership` resource.
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   * To list events, the authenticated user must be a member of the space.
   *
   * <p>For an example, see [List events from a Google Chat
   * space](https://developers.google.com/workspace/chat/list-space-events).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   String parent = SpaceName.of("[SPACE]").toString();
   *   String filter = "filter-1274492040";
   *   for (SpaceEvent element : chatServiceClient.listSpaceEvents(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the [Google Chat
   *     space](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces) where the
   *     events occurred.
   *     <p>Format: `spaces/{space}`.
   * @param filter Required. A query filter.
   *     <p>You must specify at least one event type (`event_type`) using the has `:` operator. To
   *     filter by multiple event types, use the `OR` operator. Omit batch event types in your
   *     filter. The request automatically returns any related batch events. For example, if you
   *     filter by new reactions (`google.workspace.chat.reaction.v1.created`), the server also
   *     returns batch new reactions events (`google.workspace.chat.reaction.v1.batchCreated`). For
   *     a list of supported event types, see the [`SpaceEvents` reference
   *     documentation](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.event_type).
   *     <p>Optionally, you can also filter by start time (`start_time`) and end time (`end_time`):
   *     <ul>
   *       <li>`start_time`: Exclusive timestamp from which to start listing space events. You can
   *           list events that occurred up to 28 days ago. If unspecified, lists space events from
   *           the past 28 days.
   *       <li>`end_time`: Inclusive timestamp until which space events are listed. If unspecified,
   *           lists events up to the time of the request.
   *     </ul>
   *     <p>To specify a start or end time, use the equals `=` operator and format in
   *     [RFC-3339](https://www.rfc-editor.org/rfc/rfc3339). To filter by both `start_time` and
   *     `end_time`, use the `AND` operator.
   *     <p>For example, the following queries are valid:
   *     <p>``` start_time="2023-08-23T19:20:33+00:00" AND end_time="2023-08-23T19:21:54+00:00" ```
   *     ``` start_time="2023-08-23T19:20:33+00:00" AND
   *     (event_types:"google.workspace.chat.space.v1.updated" OR
   *     event_types:"google.workspace.chat.message.v1.created") ```
   *     <p>The following queries are invalid:
   *     <p>``` start_time="2023-08-23T19:20:33+00:00" OR end_time="2023-08-23T19:21:54+00:00" ```
   *     ``` event_types:"google.workspace.chat.space.v1.updated" AND
   *     event_types:"google.workspace.chat.message.v1.created" ```
   *     <p>Invalid queries are rejected by the server with an `INVALID_ARGUMENT` error.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpaceEventsPagedResponse listSpaceEvents(String parent, String filter) {
    ListSpaceEventsRequest request =
        ListSpaceEventsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listSpaceEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists events from a Google Chat space. For each event, the
   * [payload](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.oneof_payload)
   * contains the most recent version of the Chat resource. For example, if you list events about
   * new space members, the server returns `Membership` resources that contain the latest membership
   * details. If new members were removed during the requested period, the event payload contains an
   * empty `Membership` resource.
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   * To list events, the authenticated user must be a member of the space.
   *
   * <p>For an example, see [List events from a Google Chat
   * space](https://developers.google.com/workspace/chat/list-space-events).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListSpaceEventsRequest request =
   *       ListSpaceEventsRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (SpaceEvent element : chatServiceClient.listSpaceEvents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSpaceEventsPagedResponse listSpaceEvents(ListSpaceEventsRequest request) {
    return listSpaceEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists events from a Google Chat space. For each event, the
   * [payload](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.oneof_payload)
   * contains the most recent version of the Chat resource. For example, if you list events about
   * new space members, the server returns `Membership` resources that contain the latest membership
   * details. If new members were removed during the requested period, the event payload contains an
   * empty `Membership` resource.
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   * To list events, the authenticated user must be a member of the space.
   *
   * <p>For an example, see [List events from a Google Chat
   * space](https://developers.google.com/workspace/chat/list-space-events).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListSpaceEventsRequest request =
   *       ListSpaceEventsRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<SpaceEvent> future =
   *       chatServiceClient.listSpaceEventsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SpaceEvent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSpaceEventsRequest, ListSpaceEventsPagedResponse>
      listSpaceEventsPagedCallable() {
    return stub.listSpaceEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists events from a Google Chat space. For each event, the
   * [payload](https://developers.google.com/workspace/chat/api/reference/rest/v1/spaces.spaceEvents#SpaceEvent.FIELDS.oneof_payload)
   * contains the most recent version of the Chat resource. For example, if you list events about
   * new space members, the server returns `Membership` resources that contain the latest membership
   * details. If new members were removed during the requested period, the event payload contains an
   * empty `Membership` resource.
   *
   * <p>Requires [user
   * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
   * To list events, the authenticated user must be a member of the space.
   *
   * <p>For an example, see [List events from a Google Chat
   * space](https://developers.google.com/workspace/chat/list-space-events).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChatServiceClient chatServiceClient = ChatServiceClient.create()) {
   *   ListSpaceEventsRequest request =
   *       ListSpaceEventsRequest.newBuilder()
   *           .setParent(SpaceName.of("[SPACE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListSpaceEventsResponse response =
   *         chatServiceClient.listSpaceEventsCallable().call(request);
   *     for (SpaceEvent element : response.getSpaceEventsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSpaceEventsRequest, ListSpaceEventsResponse>
      listSpaceEventsCallable() {
    return stub.listSpaceEventsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListMessagesPagedResponse
      extends AbstractPagedListResponse<
          ListMessagesRequest,
          ListMessagesResponse,
          Message,
          ListMessagesPage,
          ListMessagesFixedSizeCollection> {

    public static ApiFuture<ListMessagesPagedResponse> createAsync(
        PageContext<ListMessagesRequest, ListMessagesResponse, Message> context,
        ApiFuture<ListMessagesResponse> futureResponse) {
      ApiFuture<ListMessagesPage> futurePage =
          ListMessagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMessagesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMessagesPagedResponse(ListMessagesPage page) {
      super(page, ListMessagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMessagesPage
      extends AbstractPage<ListMessagesRequest, ListMessagesResponse, Message, ListMessagesPage> {

    private ListMessagesPage(
        PageContext<ListMessagesRequest, ListMessagesResponse, Message> context,
        ListMessagesResponse response) {
      super(context, response);
    }

    private static ListMessagesPage createEmptyPage() {
      return new ListMessagesPage(null, null);
    }

    @Override
    protected ListMessagesPage createPage(
        PageContext<ListMessagesRequest, ListMessagesResponse, Message> context,
        ListMessagesResponse response) {
      return new ListMessagesPage(context, response);
    }

    @Override
    public ApiFuture<ListMessagesPage> createPageAsync(
        PageContext<ListMessagesRequest, ListMessagesResponse, Message> context,
        ApiFuture<ListMessagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMessagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMessagesRequest,
          ListMessagesResponse,
          Message,
          ListMessagesPage,
          ListMessagesFixedSizeCollection> {

    private ListMessagesFixedSizeCollection(List<ListMessagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMessagesFixedSizeCollection createEmptyCollection() {
      return new ListMessagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMessagesFixedSizeCollection createCollection(
        List<ListMessagesPage> pages, int collectionSize) {
      return new ListMessagesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMembershipsPagedResponse
      extends AbstractPagedListResponse<
          ListMembershipsRequest,
          ListMembershipsResponse,
          Membership,
          ListMembershipsPage,
          ListMembershipsFixedSizeCollection> {

    public static ApiFuture<ListMembershipsPagedResponse> createAsync(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ApiFuture<ListMembershipsResponse> futureResponse) {
      ApiFuture<ListMembershipsPage> futurePage =
          ListMembershipsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMembershipsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMembershipsPagedResponse(ListMembershipsPage page) {
      super(page, ListMembershipsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMembershipsPage
      extends AbstractPage<
          ListMembershipsRequest, ListMembershipsResponse, Membership, ListMembershipsPage> {

    private ListMembershipsPage(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ListMembershipsResponse response) {
      super(context, response);
    }

    private static ListMembershipsPage createEmptyPage() {
      return new ListMembershipsPage(null, null);
    }

    @Override
    protected ListMembershipsPage createPage(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ListMembershipsResponse response) {
      return new ListMembershipsPage(context, response);
    }

    @Override
    public ApiFuture<ListMembershipsPage> createPageAsync(
        PageContext<ListMembershipsRequest, ListMembershipsResponse, Membership> context,
        ApiFuture<ListMembershipsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMembershipsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMembershipsRequest,
          ListMembershipsResponse,
          Membership,
          ListMembershipsPage,
          ListMembershipsFixedSizeCollection> {

    private ListMembershipsFixedSizeCollection(
        List<ListMembershipsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMembershipsFixedSizeCollection createEmptyCollection() {
      return new ListMembershipsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMembershipsFixedSizeCollection createCollection(
        List<ListMembershipsPage> pages, int collectionSize) {
      return new ListMembershipsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSpacesPagedResponse
      extends AbstractPagedListResponse<
          ListSpacesRequest,
          ListSpacesResponse,
          Space,
          ListSpacesPage,
          ListSpacesFixedSizeCollection> {

    public static ApiFuture<ListSpacesPagedResponse> createAsync(
        PageContext<ListSpacesRequest, ListSpacesResponse, Space> context,
        ApiFuture<ListSpacesResponse> futureResponse) {
      ApiFuture<ListSpacesPage> futurePage =
          ListSpacesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSpacesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSpacesPagedResponse(ListSpacesPage page) {
      super(page, ListSpacesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSpacesPage
      extends AbstractPage<ListSpacesRequest, ListSpacesResponse, Space, ListSpacesPage> {

    private ListSpacesPage(
        PageContext<ListSpacesRequest, ListSpacesResponse, Space> context,
        ListSpacesResponse response) {
      super(context, response);
    }

    private static ListSpacesPage createEmptyPage() {
      return new ListSpacesPage(null, null);
    }

    @Override
    protected ListSpacesPage createPage(
        PageContext<ListSpacesRequest, ListSpacesResponse, Space> context,
        ListSpacesResponse response) {
      return new ListSpacesPage(context, response);
    }

    @Override
    public ApiFuture<ListSpacesPage> createPageAsync(
        PageContext<ListSpacesRequest, ListSpacesResponse, Space> context,
        ApiFuture<ListSpacesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSpacesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSpacesRequest,
          ListSpacesResponse,
          Space,
          ListSpacesPage,
          ListSpacesFixedSizeCollection> {

    private ListSpacesFixedSizeCollection(List<ListSpacesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSpacesFixedSizeCollection createEmptyCollection() {
      return new ListSpacesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSpacesFixedSizeCollection createCollection(
        List<ListSpacesPage> pages, int collectionSize) {
      return new ListSpacesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchSpacesPagedResponse
      extends AbstractPagedListResponse<
          SearchSpacesRequest,
          SearchSpacesResponse,
          Space,
          SearchSpacesPage,
          SearchSpacesFixedSizeCollection> {

    public static ApiFuture<SearchSpacesPagedResponse> createAsync(
        PageContext<SearchSpacesRequest, SearchSpacesResponse, Space> context,
        ApiFuture<SearchSpacesResponse> futureResponse) {
      ApiFuture<SearchSpacesPage> futurePage =
          SearchSpacesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchSpacesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchSpacesPagedResponse(SearchSpacesPage page) {
      super(page, SearchSpacesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchSpacesPage
      extends AbstractPage<SearchSpacesRequest, SearchSpacesResponse, Space, SearchSpacesPage> {

    private SearchSpacesPage(
        PageContext<SearchSpacesRequest, SearchSpacesResponse, Space> context,
        SearchSpacesResponse response) {
      super(context, response);
    }

    private static SearchSpacesPage createEmptyPage() {
      return new SearchSpacesPage(null, null);
    }

    @Override
    protected SearchSpacesPage createPage(
        PageContext<SearchSpacesRequest, SearchSpacesResponse, Space> context,
        SearchSpacesResponse response) {
      return new SearchSpacesPage(context, response);
    }

    @Override
    public ApiFuture<SearchSpacesPage> createPageAsync(
        PageContext<SearchSpacesRequest, SearchSpacesResponse, Space> context,
        ApiFuture<SearchSpacesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchSpacesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchSpacesRequest,
          SearchSpacesResponse,
          Space,
          SearchSpacesPage,
          SearchSpacesFixedSizeCollection> {

    private SearchSpacesFixedSizeCollection(List<SearchSpacesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchSpacesFixedSizeCollection createEmptyCollection() {
      return new SearchSpacesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchSpacesFixedSizeCollection createCollection(
        List<SearchSpacesPage> pages, int collectionSize) {
      return new SearchSpacesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReactionsPagedResponse
      extends AbstractPagedListResponse<
          ListReactionsRequest,
          ListReactionsResponse,
          Reaction,
          ListReactionsPage,
          ListReactionsFixedSizeCollection> {

    public static ApiFuture<ListReactionsPagedResponse> createAsync(
        PageContext<ListReactionsRequest, ListReactionsResponse, Reaction> context,
        ApiFuture<ListReactionsResponse> futureResponse) {
      ApiFuture<ListReactionsPage> futurePage =
          ListReactionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReactionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReactionsPagedResponse(ListReactionsPage page) {
      super(page, ListReactionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReactionsPage
      extends AbstractPage<
          ListReactionsRequest, ListReactionsResponse, Reaction, ListReactionsPage> {

    private ListReactionsPage(
        PageContext<ListReactionsRequest, ListReactionsResponse, Reaction> context,
        ListReactionsResponse response) {
      super(context, response);
    }

    private static ListReactionsPage createEmptyPage() {
      return new ListReactionsPage(null, null);
    }

    @Override
    protected ListReactionsPage createPage(
        PageContext<ListReactionsRequest, ListReactionsResponse, Reaction> context,
        ListReactionsResponse response) {
      return new ListReactionsPage(context, response);
    }

    @Override
    public ApiFuture<ListReactionsPage> createPageAsync(
        PageContext<ListReactionsRequest, ListReactionsResponse, Reaction> context,
        ApiFuture<ListReactionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReactionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReactionsRequest,
          ListReactionsResponse,
          Reaction,
          ListReactionsPage,
          ListReactionsFixedSizeCollection> {

    private ListReactionsFixedSizeCollection(List<ListReactionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReactionsFixedSizeCollection createEmptyCollection() {
      return new ListReactionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReactionsFixedSizeCollection createCollection(
        List<ListReactionsPage> pages, int collectionSize) {
      return new ListReactionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSpaceEventsPagedResponse
      extends AbstractPagedListResponse<
          ListSpaceEventsRequest,
          ListSpaceEventsResponse,
          SpaceEvent,
          ListSpaceEventsPage,
          ListSpaceEventsFixedSizeCollection> {

    public static ApiFuture<ListSpaceEventsPagedResponse> createAsync(
        PageContext<ListSpaceEventsRequest, ListSpaceEventsResponse, SpaceEvent> context,
        ApiFuture<ListSpaceEventsResponse> futureResponse) {
      ApiFuture<ListSpaceEventsPage> futurePage =
          ListSpaceEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSpaceEventsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSpaceEventsPagedResponse(ListSpaceEventsPage page) {
      super(page, ListSpaceEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSpaceEventsPage
      extends AbstractPage<
          ListSpaceEventsRequest, ListSpaceEventsResponse, SpaceEvent, ListSpaceEventsPage> {

    private ListSpaceEventsPage(
        PageContext<ListSpaceEventsRequest, ListSpaceEventsResponse, SpaceEvent> context,
        ListSpaceEventsResponse response) {
      super(context, response);
    }

    private static ListSpaceEventsPage createEmptyPage() {
      return new ListSpaceEventsPage(null, null);
    }

    @Override
    protected ListSpaceEventsPage createPage(
        PageContext<ListSpaceEventsRequest, ListSpaceEventsResponse, SpaceEvent> context,
        ListSpaceEventsResponse response) {
      return new ListSpaceEventsPage(context, response);
    }

    @Override
    public ApiFuture<ListSpaceEventsPage> createPageAsync(
        PageContext<ListSpaceEventsRequest, ListSpaceEventsResponse, SpaceEvent> context,
        ApiFuture<ListSpaceEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSpaceEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSpaceEventsRequest,
          ListSpaceEventsResponse,
          SpaceEvent,
          ListSpaceEventsPage,
          ListSpaceEventsFixedSizeCollection> {

    private ListSpaceEventsFixedSizeCollection(
        List<ListSpaceEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSpaceEventsFixedSizeCollection createEmptyCollection() {
      return new ListSpaceEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSpaceEventsFixedSizeCollection createCollection(
        List<ListSpaceEventsPage> pages, int collectionSize) {
      return new ListSpaceEventsFixedSizeCollection(pages, collectionSize);
    }
  }
}
