package designPatterns;

public class NutritionFacts {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    public static class Builder{
        private final int a;
        private final int b;
        private int c;
        private int d;
        private int e;
        private int f;
        public Builder(int a,int b){
            this.a = a;
            this.b = b;
        }
        public Builder setC(int val){
            c = val;
            return this;
        }
        public Builder setD(int val){
            d = val;
            return this;
        }
        public Builder setE(int val){
            e = val;
            return this;
        }
        public Builder setF(int val){
            f= val;
            return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(12,12).build();
    }
}
