package src.graphlatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Here’s the breakdown 👇

Let:

* `N` = number of words (`words.length`)
* `L` = average / max length of a word
* `M` = total number of characters across all words = `Σ len(words[i])`
* `K` = alphabet size = 26 (fixed here)

---

### 1. `isCharPresent(words)`

```java
private boolean[] isCharPresent(String[] words){
    boolean[] charArray = new boolean[26];
    Arrays.fill(charArray, false);
    for(String str : words){
        for(int i=0;i<str.length();i++){
            charArray[str.charAt(i)-'a'] = true;
        }
    }
    return charArray;
}
```

* Time:

  * `Arrays.fill` → O(26) = O(1)
  * Double loop over all characters → O(M)
    ⇒ **O(M)**

* Space:

  * boolean[26] → **O(1)**

---

### 2. `getAdjList(k, words)`

```java
for (int i=0; i<k; i++) adj.add(new ArrayList<>());
for (int i=0; i<words.length-1; i++) {
    String s1 = words[i], s2 = words[i+1];
    int len = Math.min(s1.length(), s2.length());
    if (s1.length() > s2.length() && s1.startsWith(s2)) return new ArrayList<>();
    for (int j=0; j<len; j++) {
        if (s1.charAt(j) != s2.charAt(j)) {
            adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
            break;
        }
    }
}
```

* Time:

  * First loop to init 26 lists → O(26) = O(1)
  * Outer loop over word pairs → O(N - 1)
  * Inner loop compares characters → in total across all pairs this is **O(M)** (each character in adjacent pair comparisons is looked at at most once)
    ⇒ **O(M)** overall

* Space:

  * Adjacency list of size `K` lists, each containing edges
  * Max edges `E` ≤ K², but practically `E ≤ M` (one edge per first-difference pair)
    ⇒ **O(K + E)** = **O(E)** (since K is constant 26)

---

### 3. `findTopo(n, adj)` – Kahn’s Algorithm

```java
int[] indegree  = new int[n];
for (int i=0; i<n; i++)
    for (int element : adj.get(i))
        indegree[element]++;

Queue<Integer> queue = new LinkedList<>();
for (int i=0; i<n; i++)
    if (indegree[i]==0) queue.add(i);

while (!queue.isEmpty()) {
    int element = queue.peek();
    queue.remove();
    result.add(element);
    for (int edge : adj.get(element)) {
        indegree[edge]--;
        if (indegree[edge]==0) queue.add(edge);
    }
}
```

* Time:

  * Build indegree: visit each edge once → **O(E)**
  * Initialize queue over `n = K = 26` → **O(1)**
  * While loop:

    * Each node dequeued once → O(K)
    * Each edge processed once → O(E)
      ⇒ **O(K + E)** = **O(E)**

* Space:

  * `indegree[n]` → O(K)
  * `result` list up to K → O(K)
  * `queue` up to K → O(K)
    ⇒ **O(K + E)** = **O(E)**

---

### 4. `findOrder(words)` overall

Main work:

* `isCharPresent(words)` → **O(M)**
* `getAdjList(k, words)` → **O(M)**
* `findTopo(k, adj)` → **O(E)**, and `E ≤ M`
* Final loop over `res` (at most 26) → **O(1)**

So:

* **Time Complexity:**
  **O(M + E)**, with `E ≤ M` → **O(M)**
  In terms of `N` and `L`, that’s **O(N · L)**.

* **Space Complexity:**

  * Adjacency list: **O(E)**
  * `indegree`, `queue`, `result`, `charPresent`: all O(K) = O(1)
    ⇒ **O(E)**, which is **O(M)** in the worst case.

So you can safely say:

> **Time:** O(N · L)
> **Space:** O(N · L) in the worst case (through edges), but practically O(E) with fixed alphabet size.
* */
public class AlienDictionaryUsingTopoSort {
        public String findOrder(String[] words) {
            int k = 26;
            boolean[] charPresent = isCharPresent(words);
            // code here
            ArrayList<ArrayList<Integer>> adj = getAdjList(k, words);
            if(adj.size()==0){
                return "";
            }
            ArrayList<Integer> res = findTopo(k,  adj);
            if(res.size()==0){
                return "";
            }
            StringBuilder result = new StringBuilder("");
            for(Integer element : res){
                if(charPresent[element]){
                    result.append((char)(element+((int)'a')));
                }
            }
            //System.out.println(result.toString());
            return result.toString();
        }



        private ArrayList<ArrayList<Integer>> getAdjList(int k, String[] words){
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<k;i++){
                adj.add(new ArrayList<>());
            }


            for(int i=0;i<words.length-1;i++){
                String s1 = words[i];
                String s2 = words[i+1];
                int len = Math.min(s1.length(), s2.length());
                if(s1.length() > s2.length() && s1.startsWith(s2)){
                    return new ArrayList<>();
                }
                for(int j=0;j<len;j++){
                    if(s1.charAt(j)!=s2.charAt(j)){
                        adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                        break;
                    }
                }
            }
            return adj;
        }

        public ArrayList<Integer> findTopo(int n, ArrayList<ArrayList<Integer>> adj) {
            // code here
            ArrayList<Integer> result = new ArrayList<>();
            int[] indegree  = new int[n];
            Arrays.fill(indegree, 0);
            for(int i=0;i<n;i++){
                for(int element : adj.get(i)){
                    indegree[element]++;
                }
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            for(int i=0;i<n;i++){
                if(indegree[i]==0){
                    queue.add(i);
                }
            }

            while(!queue.isEmpty()){
                int element = queue.peek();
                queue.remove();
                result.add(element);
                for(int edge : adj.get(element)){
                    indegree[edge]--;
                    if(indegree[edge]==0){
                        queue.add(edge);
                    }
                }

            }
            if(result.size()==n){
                return result;
            }
            return new ArrayList<>();
        }

        private boolean[] isCharPresent(String[] words){
            boolean[] charArray = new boolean[26];
            Arrays.fill(charArray, false);
            for(String str : words){
                for(int i=0;i<str.length();i++){
                    charArray[str.charAt(i)-'a'] = true;
                }
            }
            return charArray;
        }
}
