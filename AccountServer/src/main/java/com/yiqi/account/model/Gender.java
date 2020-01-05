package com.yiqi.account.model;

public enum Gender{
    Male(0, "男"), Female(1, "女");

    private int op;
    private String describe;

    private Gender(int op, String describe){
        this.op = op;
        this.describe = describe;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return describe;
    }
}
