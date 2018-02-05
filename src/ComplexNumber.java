public class ComplexNumber {
    private double a;  //Den realla delen av det komplexa talet.
    private double b; // Den Imaginära delen av talet.
    private double arg; // Argumentet.


    public ComplexNumber(double a, double b){ //Konstuktorn
        this.a = a; // Set a
        this.b = b; // Set b
        this.arg = Math.atan(b/a); // set arg
    }

    //Retunerar resultatet av att lägga till det Komplexa talet a till det som kallade metoden.
    public ComplexNumber addComp(ComplexNumber a){
        return new ComplexNumber(a.a + this.a, a.b + this.b);
    }


    //Retunerar producten av det Komplexa talet a och det som kallade metoden.
    public ComplexNumber multiplyComp(ComplexNumber a){
        return new ComplexNumber(a.a * this.a - a.b * this.b, a.a * this.b + a.b * this.a);
    }

    public double getArg(){
        return this.arg;
    }

    //Jämnför Komplexa tal
    public boolean equals(ComplexNumber c){
      if(this.a == c.a && this.b == c.b && this.arg == c.getArg()){
          return true;
      } else return false;
    }

    //Override för toString() metoden för att istället få det Komplexa talet i formen a + bi.
    @Override
    public String toString(){
        if(b == 0){
            return new String("" + a);
        } else if( a == 0){
            return new String(""+ b + 'i');
        } else if(b < 0){
            return new String(a + " - " + (-b) + 'i');
        }
        return new String(a + " + " + b + 'i');
    }

    //Test main för Magnus.
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(3, 3); // Talet 3 + 3i
        ComplexNumber b = new ComplexNumber( 9 , 0); // Talet 9 + 0i eller 9
        ComplexNumber c = a.addComp(b); // Talet (3 + 3i) + 9-
        ComplexNumber d = a.multiplyComp(b); // Talet (3 + 3i)(9 + 0i).
        ComplexNumber e = new ComplexNumber(-3, -10); // Talet -3 - 10i
        ComplexNumber f = a.multiplyComp(e); //Talet (3 + 3i)(-3 - 10i)
        ComplexNumber g = a.addComp(e); //Talet (3 + 3i) + (-3 - 10i)

        System.out.println("a: " + a.toString());
        System.out.println("b: " + b.toString());
        System.out.println("c: " + c.toString());
        System.out.println("d: " + d.toString());
        System.out.println("e: " + e.toString());
        System.out.println("f: " + f.toString());
        System.out.println("g: " + g.toString());

        System.out.println("a arg: " + a.getArg() + " rad");
        System.out.println("a == a: " + a.equals(a));
        System.out.println("a == b: " + a.equals(b));
    }
}
