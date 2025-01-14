package Week8.Tutorial;

public class P4 {
    public static void main(String[] args) {
        String[] courses = new String[] {
                "Intro to Programming",
                "Further Programming",
                "Algorithms",
                "Database Applications"
        };
        int[][] requires = new int[][] {
                { 0, 0, 0, 0 },
                { 1, 0, 0, 0 },
                { 0, 1, 0, 0 },
                { 1, 0, 0, 0 }
        };
        //Topological sorting 
        String[] learningOrder = topoSort(courses, requires);
        print(learningOrder);
    }

    static class Course {
        String name;
        int index;
        int inDegree;
        boolean visited;

        public Course(String n, int i) {
            name = n;
            index = i;
            inDegree = 0;
            visited = false;
        }

        public void increaseDegree() {
            inDegree++;
        }

        public void decreaseDegree() {
            inDegree--;
        }

        public boolean isSource() {
            return (inDegree == 0);
        }
    }
/**
     * Performs a topological sort on the given courses and prerequisites.
     *
     * @param courseNames Array of course names.
     * @param requires    Adjacency matrix representing prerequisites.
     * @return An array representing the order in which the courses can be taken.
     */
    static String[] topoSort(String[] courseNames, int[][] requires) {
        // initialization
        int n = courseNames.length;
        String[] res = new String[n];
        Course[] courses = new Course[n];
        LinkedListQueue<Course> queue = new LinkedListQueue<>();

        // course objects creation
        for (int i = 0; i < n; i++) {
            courses[i] = new Course(courseNames[i], i);
            // indegree calculation
            for (int j = 0; j < n; j++) {
                if (requires[i][j] != 0) {
                    courses[i].increaseDegree();
                }
            }
        }
        // Enqueue all source courses (with in-degree 0)
        for (int i = 0; i < n; i++) {
            if (courses[i].isSource()) {
                queue.enQueue(courses[i]);
                courses[i].visited = true;
            }
        }

        int p = 0; // Pointer for the result array
        while (!queue.isEmpty()) {
            Course u = queue.peekFront(); // Dequeue a source course
            queue.deQqueue(); 
            res[p++] = u.name; // Add the course to the result array
            int source = u.index;

            // Decrease the in-degree of all dependent courses
            for (int target = 0; target < n; target++) {
                if (requires[target][source] != 0) {
                    if (!courses[target].visited) {
                        courses[target].decreaseDegree();
                        if (courses[target].isSource()) {
                            queue.enQueue(courses[target]);
                            courses[target].visited = true;
                        }
                    }
                }
            }
        }
        if (p < n) {
            System.out.println("Cannot take all courses"); // Cycle detected
        }
        return res;
    }
    
    //Prints the course order
    static void print(String[] arr) {
        System.out.println(String.join(" > ", arr));
    }
}
