class Solution {
    class Task {
        char name;
        int taskCount;
        int availableAt;
        public Task (char name, int taskCount) {
            this.name = name;
            this.taskCount = taskCount;
            this.availableAt = Integer.MAX_VALUE;
        }
        public Task (char name, int taskCount, int availableAt) {
            this.name = name;
            this.taskCount = taskCount;
            this.availableAt = availableAt;
        }
    }
    public int leastInterval(char[] tasks, int k) {
        // Find out what's the count for each task

        Map<Character, Integer> counts = new HashMap<>();

        for (char task: tasks) counts.put(task, counts.getOrDefault(task, 0) + 1);
        
        // We can use a maxHeap to get the task with most frequency
        

        // Put that task in a queue to consume later when currentTime = availableTaskTime
        // So we are allowing the task to cooldown before it can be reused.

        int time = 0;
        PriorityQueue<Task> maxHeap = new PriorityQueue<>((a, b) -> {return b.taskCount - a.taskCount; });
        
        for (Map.Entry<Character, Integer> count: counts.entrySet()) {
            maxHeap.offer(
                new Task(
                    count.getKey(), 
                    count.getValue()
                )
            );
        }

        Queue<Task> cooldown = new LinkedList<>();

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            // Some tasks to process
            time++;
            if (maxHeap.isEmpty()) {
                time = cooldown.peek().availableAt;
            }
            else {
                Task task = maxHeap.poll();
                task.taskCount -= 1;
                task.availableAt = time + k;
                if (task.taskCount > 0) cooldown.add(task);
            }
            
            if (!cooldown.isEmpty() && cooldown.peek().availableAt == time) {
                // we can process the item since it's finished cooling down
                maxHeap.offer(cooldown.poll());
            }
        }

        return time;
    }
}
