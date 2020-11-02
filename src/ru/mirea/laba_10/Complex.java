package ru.mirea.laba_10;

public class Complex
{
    /**Используется для форматирования комплексного числа как x + yi*/
    public static final int XY = 0;
    /**Используется для форматирования комплексного числа как R.cis (theta), где theta - это arg (z).*/
    public static final int RCIS = 1;
    /** Действительная, Re (z), часть ComplexNumber */
    private double real;
    /**Мнимое, Im (z), часть ComplexNumber*/
    private double imaginary;
    /**Создает новый объект ComplexNumber с действительной и мнимой частями 0 (z = 0 + 0i).*/
    public Complex() {
        real = 0.0;
        imaginary = 0.0;
    }

    /**
     * Создает новый объект <code> ComplexNumber </code>.
     * @param real действительная часть Re (z) комплексного числа
     * @param imaginary мнимая часть Im (z) комплексного числа
     */

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Добавляет еще один ComplexNumber к текущему комплексному числу.
     * @param z комплексное число, которое будет добавлено к текущему комплексному числу
     */

    public void add(Complex z) {
        set(add(this,z));
    }

    /**
     * Вычитает другое ComplexNumber из текущего комплексного числа.
     * @param z комплексное число, которое нужно вычесть из текущего комплексного числа
     */

    public void subtract(Complex z) {
        set(subtract(this,z));
    }

    /**
     * Умножает другое ComplexNumber на текущее комплексное число.
     * @param z комплексное число, которое нужно умножить на текущее комплексное число
     */

    public void multiply(Complex z) {
        set(multiply(this,z));
    }

    /**
     * Делит текущий ComplexNumber на другой ComplexNumber.
     * @param z делитель
     */

    public void divide(Complex z) {
        set(divide(this,z));
    }

    /**
     * Устанавливает значение текущего комплексного числа на переданное комплексное число.
     * @param z комплексное число
     */

    public void set(Complex z) {
        this.real = z.real;
        this.imaginary = z.imaginary;
    }

    /**
     * Добавляет два ComplexNumber.
     * @param z1 - первый ComplexNumber.
     * @param z2 второй ComplexNumber.
     * @ вернуть результат ComplexNumber (z1 + z2).
     */

    public static Complex add(Complex z1, Complex z2) {
        return new Complex(z1.real + z2.real, z1.imaginary + z2.imaginary);
    }

    /**
    * Вычитает одно ComplexNumber из другого.
    * @param z1 - первый ComplexNumber.
    * @param z2 второй ComplexNumber.
    * @ вернуть результат ComplexNumber (z1 - z2).
    */

    public static Complex subtract(Complex z1, Complex z2) {
        return new Complex(z1.real - z2.real, z1.imaginary - z2.imaginary);
    }

    /**
    * Умножает одно ComplexNumber на другое.
    * @param z1 - первый ComplexNumber.
    * @param z2 второй ComplexNumber.
    * @ вернуть результат ComplexNumber (z1 * z2).
    */

    public static Complex multiply(Complex z1, Complex z2)
    {
        double _real = z1.real*z2.real - z1.imaginary*z2.imaginary;
        double _imaginary = z1.real*z2.imaginary + z1.imaginary*z2.real;
        return new Complex(_real,_imaginary);
    }

    /**
    * Делит одно ComplexNumber на другое.
    * @param z1 - первый ComplexNumber.
    * @param z2 второй ComplexNumber.
    * @ вернуть результат ComplexNumber (z1 / z2).
    */

    public static Complex divide(Complex z1, Complex z2)
    {
        Complex output = multiply(z1,z2.conjugate());
        double div = Math.pow(z2.mod(),2);
        return new Complex(output.real/div,output.imaginary/div);
    }

    /**
    * Комплексное сопряжение текущего комплексного числа.
    * @return объект ComplexNumber, который является конъюгатом текущего комплексного числа
    */

    public Complex conjugate()
    {
        return new Complex(this.real,-this.imaginary);
    }

    /**
     * Модуль, величина или абсолютное значение текущего комплексного числа.
     * @ вернуть величину или модуль текущего комплексного числа
     */

    public double mod()
    {
        return Math.sqrt(Math.pow(this.real,2) + Math.pow(this.imaginary,2));
    }

    /**
    * Квадрат текущего комплексного числа.
    * @return ComplexNumber, который представляет собой квадрат текущего комплексного числа.
    */

    public Complex square()
    {
        double _real = this.real*this.real - this.imaginary*this.imaginary;
        double _imaginary = 2*this.real*this.imaginary;
        return new Complex(_real,_imaginary);
    }
    /**
     * @вернуть комплексное число в формате x + yi
     */
    @Override
    public String toString()
    {
        String re = this.real+"";
        String im = "";
        if(this.imaginary < 0)
            im = this.imaginary+"i";
        else
            im = "+"+this.imaginary+"i";
        return re+im;
    }
    /**
    * Вычисляет экспоненту ComplexNumber
    * @param z Входное комплексное число
    * @return a ComplexNumber, который равен e ^ (введите z)
    */
    public static Complex exp(Complex z)
    {
        double a = z.real;
        double b = z.imaginary;
        double r = Math.exp(a);
        a = r*Math.cos(b);
        b = r*Math.sin(b);
        return new Complex(a,b);
    }
    /**
    * Вычисляет ComplexNumber до переданной целой степени.
    * @param z Входное комплексное число
    * @param power Сила.
    * @return ComplexNumber, который равен (z) ^ power
    */
    public static Complex pow(Complex z, int power)
    {
        Complex output = new Complex(z.getRe(),z.getIm());
        for(int i = 1; i < power; i++)
        {
            double _real = output.real*z.real - output.imaginary*z.imaginary;
            double _imaginary = output.real*z.imaginary + output.imaginary*z.real;
            output = new Complex(_real,_imaginary);
        }
        return output;
    }

    /**
    * Вычисляет синус ComplexNumber
    * @param z входное комплексное число
    * @return ComplexNumber, который является синусом z.
    */
    public static Complex sin(Complex z)
    {
        double x = Math.exp(z.imaginary);
        double x_inv = 1/x;
        double r = Math.sin(z.real) * (x + x_inv)/2;
        double i = Math.cos(z.real) * (x - x_inv)/2;
        return new Complex(r,i);
    }
    /**
    * Вычисляет косинус ComplexNumber
    * @param z входное комплексное число
    * @return ComplexNumber, который является косинусом z.
    */
    public static Complex cos(Complex z)
    {
        double x = Math.exp(z.imaginary);
        double x_inv = 1/x;
        double r = Math.cos(z.real) * (x + x_inv)/2;
        double i = -Math.sin(z.real) * (x - x_inv)/2;
        return new Complex(r,i);
    }
    /**
    * Вычисляет тангенс ComplexNumber
    * @param z входное комплексное число
    * @return ComplexNumber, который является касательной к z.
    */
    public static Complex tan(Complex z)
    {
        return divide(sin(z),cos(z));
    }

    /**
    * Вычисляет касательную к ComplexNumber
    * @param z входное комплексное число
    * @return ComplexNumber, который является касательной к z.
    */

    public static Complex cot(Complex z)
    {
        return divide(new Complex(1,0),tan(z));
    }

    /**
    * Вычисляет секанс ComplexNumber
    * @param z входное комплексное число
    * @return ComplexNumber, который является секансом z.
    */

    public static Complex sec(Complex z)
    {
        return divide(new Complex(1,0),cos(z));
    }

    /**
    * Вычисляет косеканс ComplexNumber
    * @param z входное комплексное число
    * @return ComplexNumber, который является сопредставителем z.
    */

    public static Complex cosec(Complex z)
    {
        return divide(new Complex(1,0),sin(z));
    }
    /**
    * Действительная часть ComplexNumber
    * @ вернуть действительную часть комплексного числа
    */
    public double getRe()
    {
        return this.real;
    }
    /**
        * Мнимая часть ComplexNumber
        * @ вернуть мнимую часть комплексного числа
     */
    public double getIm()
    {
        return this.imaginary;
    }
    /**
        * Аргумент / фаза текущего комплексного числа.
        * @return arg (z) - аргумент текущего комплексного числа
    */
    public double getArg()
    {
        return Math.atan2(imaginary,real);
    }
    /**
        * Анализирует String как ComplexNumber типа x + yi.
     * @param s входное комплексное число в виде строки
     * @return ComplexNumber, который представлен строкой.
    */
    public static Complex parseComplex(String s)
    {
        s = s.replaceAll(" ","");
        Complex parsed = null;
        if(s.contains(String.valueOf("+")) || (s.contains(String.valueOf("-")) && s.lastIndexOf('-') > 0))
        {
            String re = "";
            String im = "";
            s = s.replaceAll("i","");
            s = s.replaceAll("I","");
            if(s.indexOf('+') > 0)
            {
                re = s.substring(0,s.indexOf('+'));
                im = s.substring(s.indexOf('+')+1,s.length());
                parsed = new Complex(Double.parseDouble(re),Double.parseDouble(im));
            }
            else if(s.lastIndexOf('-') > 0)
            {
                re = s.substring(0,s.lastIndexOf('-'));
                im = s.substring(s.lastIndexOf('-')+1,s.length());
                parsed = new Complex(Double.parseDouble(re),-Double.parseDouble(im));
            }
        }
        else
        {
            // Pure imaginary number
            if(s.endsWith("i") || s.endsWith("I"))
            {
                s = s.replaceAll("i","");
                s = s.replaceAll("I","");
                parsed = new Complex(0, Double.parseDouble(s));
            }
            // Pure real number
            else
            {
                parsed = new Complex(Double.parseDouble(s),0);
            }
        }
        return parsed;
    }
    /**
        * Проверяет, совпадает ли переданный ComplexNumber с текущим.
        * @param z комплексное число, которое нужно проверить
     * @return true, если они равны, иначе false
     */
    @Override
    public final boolean equals(Object z)
    {
        if (!(z instanceof Complex))
            return false;
        Complex a = (Complex) z;
        return (real == a.real) && (imaginary == a.imaginary);
    }
    /**
        * Обратное / обратное значение комплексного числа.
        * @ вернуть обратную величину текущего комплексного числа.
    */
    public Complex inverse()
    {
        return divide(new Complex(1,0),this);
    }
    /**
        * Форматирует комплексное число как x + yi или r.cis (theta)
        * @param format_id идентификатор формата ComplexNumber.XY или ComplexNumber.RCIS.
        * @ return строковое представление комплексного числа
     * @ выдает исключение IllegalArgumentException, если format_id не совпадает.
    */
    public String format(int format_id) throws IllegalArgumentException
    {
        String out = "";
        if(format_id == XY)
            out = toString();
        else if(format_id == RCIS)
        {
            out = mod()+" cis("+getArg()+")";
        }
        else
        {
            throw new IllegalArgumentException("Unknown Complex Number format.");
        }
        return out;
    }
}