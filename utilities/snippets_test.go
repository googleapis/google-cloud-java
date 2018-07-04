// Copyright 2018 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package main

import (
	"reflect"
	"testing"
)

var sniptests = []struct {
	txt string
	out map[string]string
}{
	{
		`package com.google.cloud.examples.pubsub.snippets;

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.pubsub.v1.PubsubMessage;
import java.util.concurrent.BlockingQueue;

/** This class contains snippets for the {@link MessageReceiver} interface. */

public class MessageReceiverSnippets {
	private final BlockingQueue<PubsubMessage> blockingQueue;

	public MessageReceiverSnippets(BlockingQueue<PubsubMessage> blockingQueue) {
	this.blockingQueue = blockingQueue;
	}

	public MessageReceiver messageReceiver() {
	// SNIPPET receiveMessage
	MessageReceiver receiver =
		new MessageReceiver() {
			public void receiveMessage(final PubsubMessage message, final AckReplyConsumer consumer) {
			if (blockingQueue.offer(message)) {
				consumer.ack();
			} else {
				consumer.nack();
			}
			}
		};
	// SNIPPET receiveMessage
	return receiver;
	}

	// SNIPPET secondSnippet
	// some example code.
	// SNIPPET secondSnippet
}
`,
		map[string]string{
			"<!--SNIPPET receiveMessage-->": `	MessageReceiver receiver =
		new MessageReceiver() {
			public void receiveMessage(final PubsubMessage message, final AckReplyConsumer consumer) {
			if (blockingQueue.offer(message)) {
				consumer.ack();
			} else {
				consumer.nack();
			}
			}
		};
	`,
			"<!--SNIPPET secondSnippet-->": "\t// some example code.\n\t",
		},
	},
}

func TestGetSnip(t *testing.T) {
	for _, tt := range sniptests {
		t.Run(tt.txt, func(t *testing.T) {

			got := map[string]string{}
			if err := getSnip("testfile.java", tt.txt, got); err != nil {
				t.Errorf("error getting snips: %s", err)
			}
			if !reflect.DeepEqual(tt.out, got) {
				t.Errorf("expected %v, got %v", tt.out, got)
			}
		})
	}
}
