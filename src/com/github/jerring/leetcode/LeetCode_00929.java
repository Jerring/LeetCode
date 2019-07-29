package com.github.jerring.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_00929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int index = email.indexOf('@');
            String local = email.substring(0, index);
            String domain = email.substring(index);
            index = local.indexOf('+');
            if (index != -1) {
                local = local.substring(0, index);
            }
            local = local.replace(".", "");
            set.add(local + domain);
        }
        return set.size();
    }
}
