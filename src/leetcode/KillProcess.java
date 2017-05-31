package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-32/problems/kill-process/
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

 Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

 We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

 Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.
 */
public class KillProcess {

    private static void add(HashMap<Integer, List<Integer>> parentVsChild, List<Integer> res, int kill) {
        res.add(kill);
        List<Integer> children = parentVsChild.get(kill);
        if (children != null) {
            for (Integer val : children) {
                add(parentVsChild, res, val);
            }
        }
    }
    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> parentVsChild = new HashMap<>();

        for (int i = 0; i < ppid.size(); i++) {
            Integer parentId = ppid.get(i);
            if (parentId == 0 && kill == pid.get(i)) {
                return pid;
            }
            List<Integer> children = parentVsChild.get(parentId);
            if (children == null) {
                children = new ArrayList<>();
                parentVsChild.put(parentId, children);
            }
            children.add(pid.get(i));
        }
        List<Integer> res = new ArrayList<>();
        add(parentVsChild, res, kill);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = killProcess(Arrays.asList(1,2,3,10,9,8,7,4,6), Arrays.asList(7,1,9,8,8,0,8,3,4), 9);
        for (Integer val : res) {
            System.out.print(val + " ");
        }
    }
}
