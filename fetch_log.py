import urllib.request
import json
import zipfile
import io
import sys
import ssl

ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

repo = "googleapis/google-cloud-java"
pr_num = 13873
url = f"https://api.github.com/repos/{repo}/pulls/{pr_num}"

print(f"Fetching PR data from {url}")
req = urllib.request.Request(url)
with urllib.request.urlopen(req, context=ctx) as res:
    pr_data = json.loads(res.read().decode())
    sha = pr_data["head"]["sha"]

runs_url = f"https://api.github.com/repos/{repo}/commits/{sha}/check-runs?per_page=100"
print(f"Fetching runs from {runs_url}")
req2 = urllib.request.Request(runs_url)
with urllib.request.urlopen(req2, context=ctx) as res2:
    runs_data = json.loads(res2.read().decode())

target_run = None
for run in runs_data["check_runs"]:
    if "java-bigquery" in run["name"] and "25" in run["name"]:
        target_run = run
        break

if not target_run:
    print("Could not find the check run.")
    sys.exit(0)

run_name = target_run["name"]
run_id = target_run["id"]
status = target_run["conclusion"]
print(f"Found run: {run_name} (ID: {run_id}, Status: {status})")

log_url = f"https://api.github.com/repos/{repo}/actions/jobs/{run_id}/logs"
print(f"Fetching logs from {log_url}")
try:
    req_log = urllib.request.Request(log_url)
    with urllib.request.urlopen(req_log, context=ctx) as res_log:
        logs = res_log.read().decode()
        lines = logs.split("\n")
        print("\n".join(lines[-200:]))
except Exception as e:
    import urllib.error
    if isinstance(e, urllib.error.HTTPError):
        print(f"Log fetch failed: {e.code} {e.reason}")
    else:
        print(f"Error fetching logs: {e}")
