package com.ballot.rigging.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wkd
 */
@RestController
public class OptionLe {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        addArray(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public void addArray(List<String> result, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            result.add(cur.toString());
        }
        if (open > close) {
            cur.append("(");
            addArray(result, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (open < close) {
            cur.append(")");
            addArray(result, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
