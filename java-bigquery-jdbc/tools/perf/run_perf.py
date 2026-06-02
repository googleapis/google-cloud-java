# Copyright 2026 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import argparse
import subprocess
import statistics
import sys
import os

# Base directory of the script
BASE_DIR = os.path.dirname(os.path.abspath(__file__))

def run_test(url, driver_jar, driver_class, query=None, generate_rows=0, generate_cols=5, no_output=True):
    # Base client folder is tools/client. Relative to tools/perf it is ../client.
    client_dir = os.path.join(os.path.dirname(BASE_DIR), "client")
        
    cp = f"{client_dir}:{driver_jar}"
    
    cmd = [
        "java",
        "--add-opens=java.base/java.nio=ALL-UNNAMED",
        "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED",
        "-Xmx2g",
        "-cp", cp,
        "JDBCClient",
        "--action", "query",
        "--url", url,
        "--driver-class", driver_class,
    ]
    
    if query:
        cmd.extend(["--query", query])
    if generate_rows > 0:
        cmd.extend(["--generate-rows", str(generate_rows)])
        cmd.extend(["--generate-cols", str(generate_cols)])
    if no_output:
        cmd.append("--no-output")

    print(f"Running command: {' '.join(cmd)}")
    result = subprocess.run(cmd, capture_output=True, text=True, cwd=BASE_DIR)
    
    if result.returncode != 0:
        print(f"Error running test: {result.stderr}", file=sys.stderr)
        return None
        
    metrics = {}
    for line in result.stdout.splitlines():
        if "Rows retrieved:" in line:
            metrics["rows"] = int(line.split(":")[-1].strip())
        elif "Values retrieved:" in line:
            metrics["values"] = int(line.split(":")[-1].strip())
        elif "Execution time:" in line:
            metrics["execution_time"] = float(line.split(":")[-1].replace("seconds", "").strip())
        elif "Fetch time:" in line:
            metrics["fetch_time"] = float(line.split(":")[-1].replace("seconds", "").strip())
        elif "Total e2e time:" in line:
            metrics["e2e_time"] = float(line.split(":")[-1].replace("seconds", "").strip())

    if metrics:
        exec_time = metrics.get("execution_time", 0)
        fetch_time = metrics.get("fetch_time", 0)
        total_time = exec_time + fetch_time
        return {
            "metric": "totalTimeSec",
            "value": total_time,
            "metadata": {
                "iterationTimeSec": total_time,
                "execution_time": exec_time,
                "fetch_time": fetch_time,
                "e2e_time": metrics.get("e2e_time", 0),
                "rows": metrics.get("rows", 0),
                "values": metrics.get("values", 0)
            }
        }
        
    print(f"Could not find metrics in output. Output follows:\n{result.stderr}\n{result.stdout}", file=sys.stderr)
    return None

def compute_percentile(data, p):
    if not data:
        return 0
    size = len(data)
    sorted_data = sorted(data)
    idx = (p / 100) * (size - 1)
    if idx.is_integer():
        return sorted_data[int(idx)]
    else:
        lower = int(idx)
        upper = lower + 1
        weight = idx - lower
        return sorted_data[lower] * (1 - weight) + sorted_data[upper] * weight

def extract_metrics(results):
    metrics_data = {}
    for res in results:
        main_val = res.get("value")
        metric_name = res.get("metric", "value")
        if main_val is not None and isinstance(main_val, (int, float)):
            metrics_data.setdefault(metric_name, []).append(main_val)
            
        metadata = res.get("metadata", {})
        for k, v in metadata.items():
            if isinstance(v, (int, float)):
                metrics_data.setdefault(k, []).append(v)
    return metrics_data

def calculate_stats(values):
    valid_values = [v for v in values if v != -1.0]
    if not valid_values:
        return None
    return {
        "avg": statistics.mean(valid_values),
        "count": len(valid_values),
        "p50": compute_percentile(valid_values, 50),
        "p75": compute_percentile(valid_values, 75),
        "p95": compute_percentile(valid_values, 95)
    }

def print_comparison(base_results, new_results, base_label, new_label, diff_label, spec_name, output_md=None, filter_metrics=None):
    is_single = base_label == new_label
    
    print("\n" + "=" * 90)
    if is_single:
        print(f"{f'Metrics for {base_label}':^90}")
    else:
        print(f"{f'Side-by-Side Metrics Comparison ({base_label} vs {new_label})':^90}")
    print("=" * 90)
    
    base_metrics = extract_metrics(base_results)
    new_metrics = extract_metrics(new_results) if not is_single else {}
    
    all_metric_names = sorted(list(set(base_metrics.keys()) | set(new_metrics.keys())))
    
    if not all_metric_names:
        print("No valid metrics found to compare.")
        return
        
    if is_single:
        print(f"{'Metric':<30} | {'Stat':<5} | {base_label:<15}")
        print("-" * 60)
    else:
        print(f"{'Metric':<30} | {'Stat':<5} | {base_label:<15} | {new_label:<15} | {diff_label:<12}")
        print("-" * 90)
    
    filter_list = filter_metrics.split(",") if filter_metrics else None
    
    md_lines = []
    if output_md:
        md_lines.append(f"### Results for spec: `{spec_name}`")
        md_lines.append("")
        if is_single:
            md_lines.append(f"| Metric | Stat | {base_label} |")
            md_lines.append(f"|---|---|---|")
        else:
            md_lines.append(f"| Metric | Stat | {base_label} | {new_label} | {diff_label} |")
            md_lines.append(f"|---|---|---|---|---|")
    
    for metric in all_metric_names:
        b_vals = base_metrics.get(metric, [])
        n_vals = new_metrics.get(metric, []) if not is_single else []
        
        b_stats = calculate_stats(b_vals)
        n_stats = calculate_stats(n_vals) if not is_single else None
        
        if not b_stats and not n_stats:
            continue
            
        if is_single:
            print(f"{metric:<30} |       |                 |")
        else:
            print(f"{metric:<30} |       |                 |                 |")
        
        for stat in ["avg", "p50", "p75", "p95"]:
            b_val_str = f"{b_stats[stat]:.4f}" if b_stats else "N/A"
            
            if is_single:
                print(f"{'':<30} | {stat.upper():<5} | {b_val_str:<15}")
                if output_md:
                    if not filter_list or metric in filter_list:
                        md_lines.append(f"| {metric} | {stat.upper()} | {b_val_str} |")
            else:
                n_val_str = f"{n_stats[stat]:.4f}" if n_stats else "N/A"
                diff_str = ""
                if n_stats and b_stats and b_stats[stat] != 0:
                    diff = ((n_stats[stat] - b_stats[stat]) / b_stats[stat]) * 100
                    diff_str = f"{diff:+.2f}%"
                elif n_stats and b_stats and b_stats[stat] == 0:
                    if n_stats[stat] == 0:
                        diff_str = "+0.00%"
                    else:
                        diff_str = "INF"
                
                print(f"{'':<30} | {stat.upper():<5} | {b_val_str:<15} | {n_val_str:<15} | {diff_str:<12}")
                if output_md:
                    if not filter_list or metric in filter_list:
                        md_lines.append(f"| {metric} | {stat.upper()} | {b_val_str} | {n_val_str} | {diff_str} |")
        
        if is_single:
            print("-" * 60)
        else:
            print("-" * 90)
        
    if output_md:
        md_lines.append("")
        md_lines.append("---")
        md_lines.append("")
        with open(output_md, "a") as f:
            f.write("\n".join(md_lines))


def main():
    parser = argparse.ArgumentParser(description="Run JDBC Perf tests and aggregate metrics.")
    parser.add_argument("--url", required=True, help="JDBC connection URL")
    parser.add_argument("--jar1", required=True, help="Path to first driver jar")
    parser.add_argument("--jar2", help="Path to second driver jar (optional, for comparison)")
    parser.add_argument("--class1", default="com.google.cloud.bigquery.jdbc.BigQueryDriver", help="Class name for first driver")
    parser.add_argument("--class2", default="com.google.cloud.bigquery.jdbc.BigQueryDriver", help="Class name for second driver")
    parser.add_argument("-n", "--iterations", type=int, default=5, help="Number of iterations to run (default 5)")
    parser.add_argument("--generate-rows", type=int, default=0, help="Number of rows to generate")
    parser.add_argument("--generate-cols", type=int, default=5, help="Number of columns to generate")
    parser.add_argument("--query", help="Query to run (if not using generated data)")
    parser.add_argument("--output-md", help="Append markdown table to this file containing the results")
    parser.add_argument("--filter-metrics", help="Comma-separated list of metrics to include in markdown tables")
    
    args = parser.parse_args()

    print("=" * 70)
    print(f"JDBC Performance Runner")
    print(f"URL          : {args.url}")
    print(f"Iterations   : {args.iterations}")
    print(f"Jar 1        : {args.jar1} ({args.class1})")
    if args.jar2:
        print(f"Jar 2        : {args.jar2} ({args.class2})")
    if args.generate_rows > 0:
        print(f"Generate Rows: {args.generate_rows}")
        print(f"Generate Cols: {args.generate_cols}")
    elif args.query:
        print(f"Query        : {args.query}")
    print("=" * 70)

    driver_results = {}
    drivers_to_run = [("driver1", args.jar1, args.class1)]
    if args.jar2:
        drivers_to_run.append(("driver2", args.jar2, args.class2))
        base_key, new_key = "driver1", "driver2"
        base_label, new_label = "Driver 1", "Driver 2"
        diff_label = "% Diff (D2/D1)"
    else:
        base_key = "driver1"
        new_key = "driver1" # Fallback if only 1 driver
        base_label, new_label = "Driver 1", "Driver 1"
        diff_label = "% Diff"

    for driver_key, driver_jar, driver_class in drivers_to_run:
        driver_results[driver_key] = []
        for i in range(args.iterations):
            print(f"-> Running {driver_key} iteration {i+1}/{args.iterations}...")
            res = run_test(
                url=args.url,
                driver_jar=driver_jar,
                driver_class=driver_class,
                query=args.query,
                generate_rows=args.generate_rows,
                generate_cols=args.generate_cols,
                no_output=True
            )
            if res:
                driver_results[driver_key].append(res)
        
    print_comparison(
        base_results=driver_results[base_key], 
        new_results=driver_results[new_key], 
        base_label=base_label, 
        new_label=new_label, 
        diff_label=diff_label, 
        spec_name=f"Rows: {args.generate_rows}, Cols: {args.generate_cols}" if args.generate_rows > 0 else args.query,
        output_md=args.output_md,
        filter_metrics=args.filter_metrics
    )

if __name__ == "__main__":
    main()
