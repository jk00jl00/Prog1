public class ComplexNumber {
    private double a;
    private double b;
    private double arg;
    private static final char i = 'i';

    public ComplexNumber(double a, double b){
        this.a = a;
        this.b = b;
        this.arg = Math.atan(b/a);
    }

    public ComplexNumber addComp(ComplexNumber a){
        return new ComplexNumber(a.a + this.a, a.b + this.b);
    }

    public ComplexNumber multiplyComp(ComplexNumber a){
        return new ComplexNumber(a.a * this.a - a.b * this.b, a.a * this.b + a.b * this.a);
    }

    public double getArg(){
        return this.arg;
    }

    public boolean equals(ComplexNumber c){
      if(this.a == c.a && this.b == c.b && this.arg == c.getArg()){
          return true;
      } else return false;
    }

    @Override
    public String toString(){
        return new String("Re(" + this.a + ") + i im(" + this.b + ")"  + " Eller " + "(" + a + " + " + b + i + ")");
    }

    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(3, 3);
        ComplexNumber b = new ComplexNumber( 9 , 0);
        ComplexNumber c = a.addComp(b);
        ComplexNumber d = a.multiplyComp(b);

        System.out.println("a: " + a.toString());
        System.out.println("b: " + b.toString());
        System.out.println("c: " + c.toString());
        System.out.println("d: " + d.toString());

        System.out.println("a arg: " + a.getArg());
        System.out.println("a == a: " + a.equals(a));
        System.out.println("a == b: " + a.equals(b));
    }
}
