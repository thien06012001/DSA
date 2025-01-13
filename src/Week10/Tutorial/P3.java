package Week10.Tutorial;

public class P3 {
    public static void main(String[] args) {
      SearchState begin = new SearchState(0, 0, null, null);
      WaterJugs.BFS(begin, 4);
    }
  }
  
  class WaterJugs {
    // Solving the water jug problem with BFS
    static void BFS(SearchState begin, int target) {
      LinkedListQueue<SearchState> queue = new LinkedListQueue<SearchState>();
      boolean[][] visited = new boolean[SearchState.FIRST_MAX + 1][SearchState.SECOND_MAX + 1];
    
      queue.enQueue(begin);
      visited[begin.first][begin.second] = true;
    
      while (!queue.isEmpty()) {
        SearchState current = queue.peekFront();
        queue.deQqueue();
        if (current.first == target || current.second == target) {
          // construct the solution from current to the beginning
          showSolution(current, begin);
          return;
        }
        SearchState[] nextStates = current.generate();
        for (int i = 0; i < nextStates.length; i++) {
          if (nextStates[i] == null) {
            break;
          }
          if (visited[nextStates[i].first][nextStates[i].second]) {
            continue;
          }
          queue.enQueue(nextStates[i]);
          visited[nextStates[i].first][nextStates[i].second] = true;
        }
      }
      System.out.println("No solution");
    }
  
    static void showSolution(SearchState current, SearchState beginState) {
      StringBuilder solution = new StringBuilder();
      while (!current.equals(beginState)) {
        solution.insert(0, String.format("\n%s to reach (%d, %d)", current.howto, current.first, current.second));
        current = current.parent;
      }
      // insert begin state
      solution.insert(0, String.format("Begin state (%d, %d)", beginState.first, beginState.second));
      System.out.println(solution);
    }
  }
  
  // a search state: amount of water in two jugs
  class SearchState {
    // capacity of the two water jugs
    public static final int FIRST_MAX = 5;
    public static final int SECOND_MAX = 7;
    int first, second;  // amount of water in the two jugs
    SearchState parent;  // the previous state
    String howto;  // how to reach to this state from the previous state
    
    public SearchState(int f, int s, SearchState p, String h) {
      first = f;
      second = s;
      parent = p;
      howto = h;
    }
    
    // generate new states from the current state
    public SearchState[] generate() {
      // at most six new states can be generated
      SearchState[] res = new SearchState[6];
      int idx = 0;
      // empty first
      if (first > 0) {
        res[idx++] = new SearchState(0, second, this, "Empty First");
      }
      
      // empty second
      if (second > 0) {
        res[idx++] = new SearchState(first, 0, this, "Empty Second");
      }
      
      // fill first
      if (first < FIRST_MAX) {
        res[idx++] = new SearchState(FIRST_MAX, second, this, "Fill First");
      }
      
      // fill second
      if (second < SECOND_MAX) {
        res[idx++] = new SearchState(first, SECOND_MAX, this, "Fill Second");
      }
      
      // pour first to second
      if (first > 0) {
        // first becomes empty first OR second becomes full first
        if (first + second <= SECOND_MAX) {
          res[idx++] = new SearchState(0, first + second, this, "Pour First to Second");
        } else {
          res[idx++] = new SearchState(first + second - SECOND_MAX, SECOND_MAX, this, "Pour First to Second");
        }
      }
      
      // pour second to first
      if (second > 0) {
        // second becomes empty first OR first becomes full first
        if (first + second <= FIRST_MAX) {
          res[idx++] = new SearchState(first + second, 0, this, "Pour Second to First");
        } else {
          res[idx++] = new SearchState(FIRST_MAX, first + second - FIRST_MAX, this, "Pour Second to First");
        }
      }    
      return res;
    }
  
    @Override
    public boolean equals(Object other) {
      if (!(other instanceof SearchState)) {
        return false;
      }
      SearchState otherState = (SearchState)other;
      return (first == otherState.first && second == otherState.second);
    }
  }
  