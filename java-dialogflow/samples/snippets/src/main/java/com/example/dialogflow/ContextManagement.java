/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dialogflow;

// Imports the Google Cloud client library
import com.google.cloud.dialogflow.v2.Context;
import com.google.cloud.dialogflow.v2.ContextName;
import com.google.cloud.dialogflow.v2.ContextsClient;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.protobuf.Value;

import java.util.Map.Entry;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.MutuallyExclusiveGroup;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;


/**
 * DialogFlow API Context sample.
 */
public class ContextManagement {

  // [START dialogflow_list_contexts]
  /**
   * Lists contexts
   * @param sessionId Identifier of the DetectIntent session.
   * @param projectId Project/Agent Id.
   */
  public static void listContexts(String sessionId, String projectId) throws Exception {
    // Instantiates a client
    try (ContextsClient contextsClient = ContextsClient.create()) {
      // Set the session name using the sessionId (UUID) and projectId (my-project-id)
      SessionName session = SessionName.of(projectId, sessionId);

      // Performs the list contexts request
      System.out.format("Contexts for session %s:\n", session.toString());
      for (Context context : contextsClient.listContexts(session).iterateAll()) {
        System.out.format("Context name: %s\n", context.getName());
        System.out.format("Lifespan Count: %d\n", context.getLifespanCount());
        System.out.format("Fields:\n");
        for (Entry<String, Value> entry : context.getParameters().getFieldsMap().entrySet()) {
          if (entry.getValue().hasStructValue()) {
            System.out.format("\t%s: %s\n", entry.getKey(), entry.getValue());
          }
        }
      }
    }
  }
  // [END dialogflow_list_contexts]

  // [START dialogflow_create_context]
  /**
   * Create an entity type with the given display name
   * @param contextId  The Id of the context.
   * @param sessionId Identifier of the DetectIntent session.
   * @param lifespanCount The lifespan count of the context.
   * @param projectId Project/Agent Id.
   */
  public static void createContext(String contextId, String sessionId, String projectId,
      int lifespanCount) throws Exception {
    // Instantiates a client
    try (ContextsClient contextsClient = ContextsClient.create()) {
      // Set the session name using the sessionId (UUID) and projectID (my-project-id)
      SessionName session = SessionName.of(projectId, sessionId);

      // Create the context name with the projectId, sessionId, and contextId
      ContextName contextName = ContextName.newBuilder()
          .setProject(projectId)
          .setSession(sessionId)
          .setContext(contextId)
          .build();

      // Create the context with the context name and lifespan count
      Context context = Context.newBuilder()
          .setName(contextName.toString()) // The unique identifier of the context
          .setLifespanCount(lifespanCount) // Number of query requests before the context expires.
          .build();

      // Performs the create context request
      Context response = contextsClient.createContext(session, context);
      System.out.format("Context created: %s\n", response);
    }
  }
  // [END dialogflow_create_context]

  // [START dialogflow_delete_context]
  /**
   * Delete entity type with the given entity type name
   * @param contextId The Id of the context.
   * @param sessionId Identifier of the DetectIntent session.
   * @param projectId Project/Agent Id.
   */
  public static void deleteContext(String contextId, String sessionId, String projectId)
      throws Exception {
    // Instantiates a client
    try (ContextsClient contextsClient = ContextsClient.create()) {
      // Create the context name with the projectId, sessionId, and contextId
      ContextName contextName = ContextName.of(projectId, sessionId, contextId);
      // Performs the delete context request
      contextsClient.deleteContext(contextName);
    }
  }
  // [END dialogflow_delete_context]

  public static void main(String[] args) throws Exception {
    ArgumentParser parser =
        ArgumentParsers.newFor("ContextManagement")
            .build()
            .defaultHelp(true)
            .description("Create / List / Delete a context.");

    Subparsers subparsers = parser.addSubparsers().dest("command").title("Commands");

    Subparser listParser = subparsers.addParser("list")
        .help("mvn exec:java -DContextManagement -Dexec.args='list --sessionId SESSION_ID "
            + "--projectId PROJECT_ID'");
    listParser.addArgument("--sessionId")
        .help("Identifier of the DetectIntent session").required(true);
    listParser.addArgument("--projectId").help("Project/Agent Id").required(true);

    Subparser createParser = subparsers.addParser("create")
        .help("mvn exec:java -DContextManagement -Dexec.args='create --sessionId SESSION_ID "
            + "--projectId PROJECT_ID --contextId CONTEXT_ID'");
    createParser.addArgument("--sessionId")
        .help("Identifier of the DetectIntent session").required(true);
    createParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    createParser.addArgument("--contextId")
        .help("The Id of the context")
        .required(true);
    createParser.addArgument("--lifespanCount")
        .help("The lifespan count of the context (Default: 1)").setDefault(1);

    Subparser deleteParser = subparsers.addParser("delete")
        .help("mvn exec:java -DContextManagement -Dexec.args='delete --sessionId SESSION_ID "
            + "--projectId PROJECT_ID --contextId CONTEXT_ID'");
    deleteParser.addArgument("--sessionId")
        .help("Identifier of the DetectIntent session").required(true);
    deleteParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    deleteParser.addArgument("--contextId")
        .help("The Id of the context")
        .required(true);

    try {
      Namespace namespace = parser.parseArgs(args);

      if (namespace.get("command").equals("list")) {
        listContexts(namespace.get("sessionId"), namespace.get("projectId"));
      } else if (namespace.get("command").equals("create")) {
        createContext(namespace.get("contextId"), namespace.get("sessionId"),
            namespace.get("projectId"), namespace.get("lifespanCount"));
      } else if (namespace.get("command").equals("delete")) {
        deleteContext(namespace.get("contextId"), namespace.get("sessionId"),
            namespace.get("projectId"));
      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
