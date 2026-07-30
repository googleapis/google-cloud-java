import json

def parse_comments():
    try:
        with open('pr_13246_review_comments.json', 'r') as f:
            r_comments = json.load(f)
        
        with open('pr_13246_issue_comments.json', 'r') as f:
            i_comments = json.load(f)

        with open('comments_13246.txt', 'w') as out:
            out.write("--- ISSUE COMMENTS ---\n")
            if isinstance(i_comments, list):
                for c in i_comments:
                    user = c.get('user', {}).get('login', 'unknown')
                    body = c.get('body', '')
                    out.write(f"@{user}: {body}\n\n")

            out.write("\n--- REVIEW COMMENTS ---\n")
            if isinstance(r_comments, list):
                for c in r_comments:
                    user = c.get('user', {}).get('login', 'unknown')
                    file = c.get('path', 'unknown')
                    line = c.get('line', 'unknown')
                    body = c.get('body', '')
                    out.write(f"@{user} on {file}:{line}:\n{body}\n\n")
    except Exception as e:
        print(e)

if __name__ == '__main__':
    parse_comments()
