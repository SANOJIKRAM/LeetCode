class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int maxDuration = logs[0][1];
        int employeeId = logs[0][0];

        for (int i = 1; i < logs.length; i++) {
            int id = logs[i][0];
            int duration = logs[i][1] - logs[i - 1][1];

            if (duration > maxDuration || (duration == maxDuration && id < employeeId)) {
                maxDuration = duration;
                employeeId = id;
            }
        }

        return employeeId;
    }
}
