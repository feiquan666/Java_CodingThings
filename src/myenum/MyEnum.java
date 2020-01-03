package myenum;
public enum MyEnum {
    ONE{
        String getInfo(){
            return "This is ONE";
        }
    },
    TWO{
        String getInfo(){
            return "This is TWO";
        }
    },
    THREE{
        String getInfo(){
            return "This is THREE";
        }
    };
    abstract String getInfo();
    public static void main(String[] args) {
        for (MyEnum item : values()){
            System.out.println(item.getInfo());
        }
    }
}
