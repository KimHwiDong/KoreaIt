package com.koreait.board.bean;

import lombok.Data;

@Data
public class SubjectVO {
    private int kor;
    private int math;
    private int eng;
    private int sum;
    private float avg;

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public int getSum(){
        return kor+math+eng;
    }

    public float getAvg(){
        return (kor+math+eng)/3F;
    }
}
