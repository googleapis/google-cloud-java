import urllib.request
import json
req = urllib.request.Request('https://api.github.com/repos/googleapis/google-cloud-java/pulls/13901/comments')
with urllib.request.urlopen(req) as response:
    comments = json.loads(response.read().decode())
    for c in comments:
        print(f"[{c['user']['login']}] {c['path']}:{c.get('line')}\n{c['body']}\n")
