package com.rivne.vmm408.brainring.models;

import java.util.List;

public class QuestionSetModel extends IdModel {
    private List<Integer> integerList;

    public QuestionSetModel() {
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }
}
